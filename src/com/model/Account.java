/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.UUID;

/**
 *
 * @author AnataArisa
 */
public class Account implements Serializable {

    private String ID;
    private String username;
    private String password;
    private String name;
    private DateTimeFormatter registerdate;
    private LocalTime loginTime;

   
    
    
    public Account(String username, String password){
        this.username = username;
        this.password = password;
    }
    
    public Account(){
        this.setID();
        this.setRegisterdate();
    }
    
    public Account(String username, String password, String name){
        this(username, password);
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID() {
        this.ID = UUID.randomUUID().toString();
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DateTimeFormatter getRegisterdate() {
        return registerdate;
    }

    public void setRegisterdate(DateTimeFormatter registerdate) {
        this.registerdate = registerdate;
    }

    public void setRegisterdate() {
        this.registerdate = DateTimeFormatter.ISO_DATE;
    }
    
     public LocalTime getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(LocalTime loginTime) {
        this.loginTime = loginTime;
    }
}
