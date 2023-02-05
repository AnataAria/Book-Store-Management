/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dao;

import java.util.List;

/**
 *
 * @author AnataArisa
 */
public interface IDAO<E> {
    //CRUD
    public List<E> getAll();
    public boolean create(E data);
    public List<E> read(E data);
    public List<E> read(String searchName);
    public E read(int index);
    public boolean update(E data);
    public E delete(E data);
    public E delete(String deleteName);
    public E delete(int index);
    public boolean addIDList(String ID);
    public boolean deleteIDList(String ID);
}
