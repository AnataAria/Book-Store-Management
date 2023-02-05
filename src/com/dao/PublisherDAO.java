/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.model.Publisher;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AnataArisa
 */
public class PublisherDAO implements IDAO<Publisher> {

    private List<Publisher> pubLists;

    public PublisherDAO() {
        pubLists = new ArrayList();
    }

    public PublisherDAO(List<Publisher> pubLists) {
        this.pubLists = pubLists;
    }

    @Override
    public List<Publisher> getAll() {
        if (pubLists.isEmpty()) {
            return null;
        }
        return pubLists;
    }

    public boolean isPublisherValid(String pID) {
        if (pID == null || pID.isEmpty()) {
            return false;
        }
        if (pubLists.isEmpty()) {
            return true;
        }
        for (Publisher temp : getAll()) {
            if (temp.getpID().equalsIgnoreCase(pID)) {
                return false;
            }
        }
        return true;
    }

    public Publisher searchByPID(String pID) {
        if (pID.isEmpty()) {
            return null;
        }
        if (pubLists.isEmpty()) {
            return null;
        }
        for (Publisher temp : getAll()) {
            if (temp.getpID().equalsIgnoreCase(pID)) {
                return temp;
            }
        }
        return null;
    }

    public List<Publisher> searchByName(String nameInput) {
        if (nameInput.isEmpty()) {
            return null;
        }
        if (pubLists.isEmpty()) {
            return null;
        }
        List<Publisher> tempList = new ArrayList();
        for (Publisher temp : getAll()) {
            if (temp.getpID().contains(nameInput)) {
                tempList.add(temp);
            }
        }
        if(tempList.isEmpty()) return null;
        return tempList;
    }

    public int returnIndexPublisher(String pID) {
        if (pID.isEmpty() || pubLists.isEmpty()) {
            return -1;
        }
        for (int i = 0; i < getAll().size(); i++) {
            if (getAll().get(i).getpID().equalsIgnoreCase(pID)) {
                return i;
            }
        }
        return -1;
    }
    @Override
    public boolean addIDList(String ID){
        return false;
    }
    //CRUD
    @Override
    public boolean create(Publisher data) {
        if (data == null || !data.checkPublisher()) {
            return false;
        }
        if (isPublisherValid(data.getpID())) {
            return this.pubLists.add(data);
        }
        return false;
    }

    @Override
    public List<Publisher> read(Publisher data) {
        if(data == null) return null;
        if(getAll() == null) return null;
        List<Publisher> tempList = new ArrayList();
        for(Publisher temp: getAll()){
            if(temp.getpID().equalsIgnoreCase(data.getpID())){
                tempList.add(temp);
            }
        }
        if(tempList.isEmpty()) return null;
        return tempList;
    }

    @Override
    public List<Publisher> read(String searchName) {
        if(searchName.isEmpty()) return null;
        Publisher temp = new Publisher(searchName);
        return read(temp);
    }

    @Override
    public Publisher read(int index) {
        if(getAll() == null) return null;
        if(index <0 || index>getAll().size()) return null;
        return getAll().get(index);
    }

    @Override
    public boolean update(Publisher data) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Publisher delete(Publisher data) {
        if (data == null || pubLists.isEmpty()) {
            return null;
        }
        if (data.getpID().isEmpty()) {
            return null;
        }
        int index = returnIndexPublisher(data.getpID());
        if (index >= 0) {
            Publisher temp = getAll().get(index);
            getAll().remove(index);
            return temp;
        }
        return null;
    }

    @Override
    public Publisher delete(String deleteName) {
        if (deleteName.isEmpty()) {
            return null;
        }
        Publisher temp = new Publisher();
        temp.setpID(deleteName);
        return delete(temp);
    }

    @Override
    public Publisher delete(int index) {
        if (pubLists.isEmpty()) {
            return null;
        }
        if (index <= 0 || index >= getAll().size()) {
            return null;
        }
        Publisher temp = getAll().get(index);
        getAll().remove(index);
        return temp;
    }

    @Override
    public boolean deleteIDList(String ID) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
