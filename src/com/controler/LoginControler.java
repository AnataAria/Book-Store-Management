/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controler;

import com.model.Account;
import java.util.ArrayList;
import java.util.List;
import my.lib.FileControler;
import my.lib.IFileControler;

/**
 *
 * @author AnataArisa
 */
public class LoginControler extends SessionControler{

    private String path ="src\\local\\data\\account.dat";
    private IFileControler<Account> file;

    public LoginControler() {
        file = new FileControler();
        file.setFilepath(path);
        file.loadFromFile();
        this.addAll(file.getAll());
    }

    public boolean checkUserPass(String username, String password) {
        if (username.isEmpty() || password.isEmpty()) {
            return false;
        }

        file.setFilepath(path);
        if (file.loadFromFile()) {
            if (file.getAll() != null) {
                for (Account temp : file.getAll()) {
                    if (temp.getUsername().equals(username) && temp.getPassword().equalsIgnoreCase(password)) {
                        this.createSession(temp);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean registerAccount(Account t) {
        if (t == null) {
            return false;
        }
        if (searchAccount(t.getUsername(), t.getPassword()) == null) {
            t.setID();
            if (file.updateList(t)) {
                file.uploadToFile();
                return true;
            }
        }
        return false;
    }

    public Account searchAccount(String username, String password) {
        if (username.isEmpty() || password.isEmpty()) {
            return null;
        }

        file.setFilepath(path);
        if (file.loadFromFile()) {
            for (Account temp : file.getAll()) {
                if (temp.getUsername().equals(username) && temp.getPassword().equals(password)) {
                    return temp;
                }
            }
        }
        return null;
    }
}
