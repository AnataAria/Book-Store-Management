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
public class Book implements Serializable, Comparator<Book> {

    private String bID;
    private String name;
    private int price;
    private int quantity;
    private String pID;
    private String status;

    public Book() {

    }

    public Book(String bID, String name, int price, int quantity, String pID, String status) {
        this.bID = bID;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.pID = pID;
        this.status = status;
    }

    public Book(String pID) {
        this.pID = pID;
    }

    public String getbID() {
        return bID;
    }

    public void setbID(String bID) {
        this.bID = bID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getpID() {
        return pID;
    }

    public void setpID(String pID) {
        this.pID = pID;
    }

    public String isStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean checkBook() {
        return (Validate.intValidate(this.getPrice(), 0, Integer.MAX_VALUE) && Validate.intValidate(this.getQuantity(), 2, Integer.MAX_VALUE) && !this.pID.isEmpty() && this.getbID().matches("B[\\d]{5}") && Validate.stringValidationSize(this.getName(), 5, 30));
    }

    @Override
    public int compare(Book o1, Book o2) {
        if(o1.getQuantity() > o2.getQuantity()) return -1;
        if(o1.getQuantity() < o2.getQuantity()) return 1;
        if(o1.getQuantity() == o2.getQuantity()){
            if(o1.getPrice() < o2.getPrice()) return -1;
            if(o1.getPrice() > o2.getPrice()) return 1;
        }
        return 0;
    }
}
