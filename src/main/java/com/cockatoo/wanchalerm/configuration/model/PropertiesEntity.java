package com.cockatoo.wanchalerm.configuration.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "properties")
@Data
public class PropertiesEntity {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "application")
    private String application;

    @Column(name = "profile")
    private String profile;

    @Column(name = "key")
    private String key;

    @Column(name = "value")
    private String value;
/*
    @Column(name = "label")
    private String label;*/
}
