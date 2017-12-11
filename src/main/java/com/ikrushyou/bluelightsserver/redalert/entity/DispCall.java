package com.ikrushyou.bluelightsserver.redalert.entity;

import javax.persistence.*;

@Entity
@Table(name = "dispcall")
public class DispCall {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "DISPCALLID")
    private Integer id;

    @Column(name = "FDID", columnDefinition="CHAR(5)")
    private String fdid;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "INCTYPE")
    private String type;

    public DispCall() {

    }

    public DispCall(String fdid, String address) {
        this.fdid = fdid;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFdid(String fdid) {
        this.fdid = fdid;
    }

    public String getFdid() {
        return fdid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
