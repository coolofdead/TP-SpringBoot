package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Entity1 {
    @Id
    @GeneratedValue
    private long id;
    private String property1;

    private int property2;

    protected Entity1(){}

    public Entity1(String property1){
        this.property1 = property1;
    }

    public Entity1(String property1, int property2){
        this.property1 = property1;
        this.property2 = property2;
    }

    public long getId(){
        return id;
    }

    public String getProperty1(){
        return property1;
    }

    public int getProperty2() {
        return property2;
    }

}