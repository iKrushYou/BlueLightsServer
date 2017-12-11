package com.ikrushyou.bluelightsserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BluelightsServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BluelightsServerApplication.class, args);
	}
}
