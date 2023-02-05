/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controler;

import com.model.Account;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AnataArisa
 */
public class SessionControler extends ArrayList<Account> {

    private final File file = new File("src\\local\\sec\\session.dat");
    private FileInputStream fis;
    private FileOutputStream fos;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private Account ss;
   
    public Account getSs() {
        return ss;
    }
    
    public Account readSession() {
        Account temp = null;
        try {
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            temp = (Account) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {

        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(SessionControler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (temp == null) {
            return null;
        }
        return temp;
    }

    public boolean checkSession() {
        Account temp = readSession();
        if (temp == null) {
            return false;
        }
        LocalTime now = LocalTime.now();
        LocalTime session = temp.getLoginTime();
        if (Math.abs(ChronoUnit.HOURS.between(now, session)) >= 1) {
            deleteSession();
        } else {
            ss = temp;
            return true;
        }
        return false;
    }

    public boolean createSession(Account t) {
        if(t == null) return false;
        try {
            if(!file.exists()) file.createNewFile();
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            t.setLoginTime(LocalTime.now());
            oos.writeObject(t);
        } catch (IOException e) {
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(SessionControler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        ss = t;
        return true;
    }

    public boolean deleteSession() {
        if (file.exists()) {
            int index = getAccIndex(readSession().getID());
            this.get(index).setLoginTime(null);
            ss = null;
            return file.delete();
        }
        return false;
    }
    
    private int getAccIndex(String ID){
        for(int i = 0; i < this.size(); i++){
            if(this.get(i).getID().equals(ID)) return i;
        }
        return -1;
    }
}
