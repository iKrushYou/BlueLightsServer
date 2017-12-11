package com.ikrushyou.bluelightsserver.bluelights.entity;

import com.ikrushyou.bluelightsserver.redalert.entity.DispCall;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Firecall {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String type;
    private String address;
    private Integer dispcallId;

    public String toString() {
        return id + "(" + dispcallId + ") : " + type + " : " + address;
    }

    public Firecall() {
    }

    public Firecall(DispCall dispCall) {
        if (dispCall == null) return;

        this.type = dispCall.getType();
        this.address = dispCall.getAddress();
        this.dispcallId = dispCall.getId();
    }

    public Firecall(String type, String address, Integer dispcallId) {
        this.type = type;
        this.address = address;
        this.dispcallId = dispcallId;
    }

    public Firecall(String type, String address) {
        this.type = type;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getDispcallId() {
        return dispcallId;
    }

    public void setDispcallId(Integer dispcallId) {
        this.dispcallId = dispcallId;
    }
}
