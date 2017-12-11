package com.ikrushyou.bluelightsserver.redalert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "redalertEntityManagerFactory",
        transactionManagerRef = "redalertTransactionManager",
        basePackages = {"com.ikrushyou.bluelightsserver.redalert"})
public class RedAlertDBConfig {
    @Autowired
    JpaVendorAdapter jpaVendorAdapter;

    @Value("${redalert.datasource.url}")
    private String databaseUrl;

    @Value("${redalert.datasource.username}")
    private String username;

    @Value("${redalert.datasource.password}")
    private String password;

    @Value("${redalert.jpa.hibernate.hbm2ddl.auto}")
    private String hibernateHbm2ddl;

//    @Value("${redalert.datasource.driverClassName}")
//    private String driverClassName;

//    @Value("${redalert.datasource.hibernate.dialect}")
//    private String dialect;

    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource(databaseUrl, username, password);
//        dataSource.setDriverClassName(driverClassName);
        return dataSource;
    }

    @Bean(name = "redalertEntityManager")
    public EntityManager entityManager() {
        return entityManagerFactory().createEntityManager();
    }

    @Bean(name = "redalertEntityManagerFactory")
    public EntityManagerFactory entityManagerFactory() {
        Properties properties = new Properties();
//        properties.setProperty("hibernate.hbm2ddl.auto", hibernateHbm2ddl);

        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource());
        emf.setJpaVendorAdapter(jpaVendorAdapter);
        emf.setPackagesToScan("com.ikrushyou.bluelightsserver.redalert");   // <- package for entities
        emf.setPersistenceUnitName("redalertPersistenceUnit");
        emf.setJpaProperties(properties);
        emf.afterPropertiesSet();
        return emf.getObject();
    }

    @Bean(name = "redalertTransactionManager")
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager(entityManagerFactory());
    }
}