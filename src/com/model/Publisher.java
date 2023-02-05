/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model;

import java.io.Serializable;
import java.util.Comparator;
import my.lib.Validate;

/**
 *
 * @author AnataArisa
 */
public class Publisher implements Serializable, Comparator<Publisher>{

    private String pID;
    private String name;
    private String phoneNumber;

    public Publisher() {
    }

    public Publisher(String pID, String name, String phoneNumber) {
        this.pID = pID;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    
    public Publisher(String pID){
        this.pID = pID;
    }

    public String getpID() {
        return pID;
    }

    public void setpID(String pID) {
        this.pID = pID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public boolean checkPublisher(){
        return (getpID().matches("P[\\d]{5}") && Validate.stringValidationSize(this.getName(),5, 30) && Validate.phoneValidate(this.getPhoneNumber(),10, 12));
    }

    @Override
    public int compare(Publisher o1, Publisher o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
