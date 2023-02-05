/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.model.Book;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AnataArisa
 */
public class BookDAO implements IDAO<Book> {

    private List<Book> bookList;
    private List<String> pubID;

    public BookDAO() {
        this.bookList = new ArrayList();
        this.pubID = new ArrayList();
    }

    public BookDAO(List<Book> bookList) {
        this.bookList = bookList;
        this.pubID = new ArrayList();
    }

    @Override
    public List<Book> getAll() {
        if (bookList.isEmpty() || bookList == null) {
            return null;
        }
        return this.bookList;
    }

    private List<String> getpIDList() {
        if (pubID.isEmpty() || pubID == null) {
            return null;
        }
        return this.pubID;
    }

    private boolean bIDMatched(String ID) {
        if (getAll() == null) {
            return false;
        }
        for (Book temp : getAll()) {
            if (temp.getbID().equalsIgnoreCase(ID)) {
                return true;
            }
        }
        return false;
    }

    private boolean pIDMatched(String ID) {
        if (getpIDList() == null) {
            return false;
        }
        for (String temp : getpIDList()) {
            if (temp.equalsIgnoreCase(ID)) {
                return true;
            }
        }
        return false;
    }

    private boolean IsBookValid(String pID, String bID) {
        return !(!pIDMatched(pID) || bIDMatched(bID));
    }

    private List<Book> searchBookByPID(String pID) {
        if (pID.isEmpty()) {
            return null;
        }
        if (!pIDMatched(pID)) {
            return null;
        }
        List<Book> tempList = new ArrayList();
        for (Book temp : getAll()) {
            if (temp.getpID().equalsIgnoreCase(pID)) {
                tempList.add(temp);
            }
        }
        if (tempList.isEmpty()) {
            return null;
        }
        return tempList;
    }

    private List<Book> searchBookByName(String bookName) {
        if (bookName.isEmpty()) {
            return null;
        }
        List<Book> tempList = new ArrayList();
        for (Book temp : getAll()) {
            if (temp.getName().contains(bookName)) {
                tempList.add(temp);
            }
        }
        if (tempList.isEmpty()) {
            return null;
        }
        return tempList;
    }

    private Book searchBookByBID(String ID) {
        if (ID.isEmpty()) {
            return null;
        }
        for (Book temp : getAll()) {
            if (temp.getbID().equalsIgnoreCase(ID)) {
                return temp;
            }
        }
        return null;
    }
    
    private int returnBookIndex(String bID){
        if(getAll().isEmpty()) return -1;
        for(int i = 0; i < getAll().size(); i++){
            if(getAll().get(i).getbID().equalsIgnoreCase(bID)) return i;
        }
        return -1;
    }
    
    @Override
    public boolean addIDList(String ID){
        return pubID.add(ID);
    }
    //CRUD

    @Override
    public boolean create(Book data) {
        if (data == null || !data.checkBook()) {
            return false;
        }
        if (IsBookValid(data.getpID(), data.getbID())) {
            return this.bookList.add(data);
        }
        return false;
    }

    @Override
    public List<Book> read(Book data) {
        if (getAll() == null || data == null) {
            return null;
        }
        List<Book> tempList;
        if (!data.getName().isEmpty()) {
            tempList = searchBookByName(data.getName());
            if (tempList == null) {
                return null;
            }
            return tempList;
        } else if (!data.getpID().isEmpty()) {
            tempList = searchBookByPID(data.getpID());
            if (tempList == null) {
                return null;
            }
            return tempList;
        } else {
            return null;
        }
    }

    @Override
    public List<Book> read(String searchName) {
        Book temp = new Book();
        List<Book> tempList;
        if (searchName == null || searchName.isEmpty()) {
            return null;
        }
        if (searchName.matches("P[\\d]{5}")) {
            temp.setpID(searchName);
            tempList = read(temp);
            if (tempList == null) {
                return null;
            }
        } else {
            temp.setName(searchName);
            tempList = read(temp);
            if (tempList == null) {
                return null;
            }
        }
        return tempList;
    }

    @Override
    public Book read(int index) {
        if (getAll().isEmpty()) {
            return null;
        }
        if (index <= 0 || index >= getAll().size()) {
            return null;
        }
        return getAll().get(index);
    }

    @Override
    public boolean update(Book data) {
        if (getAll() == null || data == null) {
            return false;
        }
        Book updateB = searchBookByBID(data.getbID());
        if (updateB == null) {
            return false;
        }
        if (data.checkBook() && bIDMatched(data.getbID()) && pIDMatched(data.getpID())) {
            updateB.setpID(data.getpID());
            updateB.setName(data.getName());
            updateB.setPrice(data.getPrice());
            updateB.setQuantity(data.getQuantity());
            updateB.setStatus(data.isStatus());
            return true;
        }
        return false;
    }
    
    @Override
    public Book delete(Book data){
        if(getAll() == null) return null;
        if(data == null) return null;
        if(data.getbID().isEmpty()) return null;
        int index = returnBookIndex(data.getbID());
        if(index >= 0){
            Book temp = read(index);
            if(temp != null){
                getAll().remove(index);
                return temp;
            }
        }
        return null;
    }
    @Override
    public Book delete(String deleteName){
        if(deleteName.isEmpty()) return null;
        Book temp = new Book();
        temp.setbID(deleteName);
        return delete(temp);
    }
    @Override
    public Book delete(int index){
         if (getAll().isEmpty()) {
            return null;
        }
        if (index <= 0 || index >= getAll().size()) {
            return null;
        }
        Book temp = getAll().get(index);
        getAll().remove(index);
        return temp;
    }

    @Override
    public boolean deleteIDList(String ID) {
        if(pubID.isEmpty()) return false;
        for(int i = 0; i < pubID.size(); i++){
            if(pubID.get(i).equalsIgnoreCase(ID)){
                pubID.remove(i);
                return true;
            }
        }
        return false;
    }
}
