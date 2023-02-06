/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controler;

import com.dao.*;
import com.model.Book;
import com.model.Publisher;
import java.util.List;
import my.lib.FileControler;
import my.lib.IFileControler;

/**
 *
 * @author AnataArisa
 */
public class UserControler {

    private IDAO<Book> bookDAO;
    private IDAO<Publisher> pubDAO;
    private String bookPath = "src\\local\\data\\book.dat";
    private String pubPath = "src\\local\\data\\publisher.dat";
    private IFileControler<Book> fBC;
    private FileControler<Publisher> fPC;
    private boolean fbcStatus = true;
    private boolean fpcStatus = true;

    public UserControler(String bookPath, String pubPath) {
        this.bookPath = bookPath;
        this.pubPath = pubPath;
        fBC = new FileControler();
        fBC.setFilepath(this.bookPath);
        fPC = new FileControler();
        fPC.setFilepath(this.pubPath);
        fbcStatus = fBC.loadFromFile();
        fpcStatus = fPC.loadFromFile();
        if (fbcStatus && fpcStatus) {
            List<Book> bookTemp = fBC.getAll();
            List<Publisher> pubTemp = fPC.getAll();
            bookDAO = new BookDAO(bookTemp);
            pubDAO = new PublisherDAO(pubTemp);
            for (Publisher temp : pubDAO.getAll()) {
                bookDAO.addIDList(temp.getpID());
            }
        }
    }

    public boolean getFbcStatus() {
        return fbcStatus;
    }

    public boolean getFpcStatus() {
        return fpcStatus;
    }

    public List<Book> getBookList() {
        return bookDAO.getAll();
    }

    public List<Publisher> getPubList() {
        return pubDAO.getAll();
    }

    public boolean addBook(Book dataIn) {
        boolean check = bookDAO.create(dataIn);
        if (check == true) {
            fBC.uploadToFile();
            return true;
        }
        return false;
    }

    public boolean addBook(String bID, String name, int price, int quantity, String pID, String status) {
        return addBook(new Book(bID, name, price, quantity, pID, status));
    }

    public List<Book> searchBookByPID(Book temp) {
        return bookDAO.read(temp);
    }

    public List<Book> searchBookByName(String name) {
        return bookDAO.read(name);
    }

    public Book searchBookByBID(String ID) {
        List<Book> temp = bookDAO.getAll();
        if (temp == null) {
            return null;
        }
        for (Book t : temp) {
            if (t.getbID().equalsIgnoreCase(ID)) {
                return t;
            }
        }
        return null;
    }

    public boolean updateBook(Book data) {
        boolean check = bookDAO.update(data);
        if (check == true) {
            fBC.uploadToFile();
            return true;
        }
        return false;
    }

    public boolean delete(String bID) {
        Book temp = bookDAO.delete(bID);
        if (temp == null) {
            return false;
        }
        fBC.uploadToFile();
        return true;
    }

    public boolean addPublisher(Publisher dataIn) {
        boolean temp = pubDAO.create(dataIn);
        if (temp == true) {
            bookDAO.addIDList(dataIn.getpID());
            fPC.uploadToFile();
            return true;
        }
        return false;
    }

    public boolean deletePublisher(Publisher data) {
        Publisher temp = pubDAO.delete(data);
        if (temp != null) {
            if (bookDAO.getAll() != null) {
                List<Book> t = bookDAO.getAll();
                for (Book a : t) {
                    if (a.getpID().equalsIgnoreCase(data.getpID())) {
                        a.setpID("Unknown");
                    }
                }
                bookDAO.deleteIDList(data.getpID());
                return true;
            }
            return true;
        }
        return false;
    }

    public boolean deletePublisher(String ID) {
        Publisher temp = new Publisher(ID);
        return deletePublisher(temp);
    }

    public Publisher searchPublisherByID(String ID) {
        Publisher temp;
        try {
            temp = pubDAO.read(ID).get(0);
        } catch (Exception e) {
            return null;
        }
        return temp;
    }
}
