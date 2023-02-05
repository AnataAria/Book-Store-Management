/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AnataArisa
 * @param <T>
 */
public class FileControler<T> implements IFileControler<T> {

    private String filepath = null;

    @Override
    public String getFilepath() {
        return filepath;
    }

    @Override
    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    private List<T> dataList = new ArrayList<>();

    @Override
    public List<T> getAll() {
        return dataList;
    }

    @Override
    public boolean updateList(List<T> list) {
        if (list.isEmpty()) {
            return false;
        } else {
            for (T temp : list) {
                for (T temp2 : getAll()) {
                    if (!temp2.equals(temp)) {
                        getAll().add(temp);
                    }
                }
            }
        }
        uploadToFile();
        return true;
    }

    @Override
    public boolean uploadToFile() {
        File file = new File(this.getFilepath());
        FileOutputStream fis = null;
        ObjectOutputStream ois = null;
        try {
            if(!file.exists()) file.createNewFile();
            fis = new FileOutputStream(file);
            ois = new ObjectOutputStream(fis);
            ois.writeObject(getAll());
            return true;
        } catch (IOException e) {
            
        }finally {
            try {
                if (ois != null) {
                    ois.close();
                }
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException ef) {
                
            }
        }
        return false;
    }

    @Override
    public boolean loadFromFile() {
        File file = new File(this.getFilepath());
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            if(!file.exists()) file.createNewFile();
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            this.dataList = (ArrayList<T>) ois.readObject();
            return true;
        } catch (IOException e) {

        } catch (ClassNotFoundException ex) {
            System.out.println("ClassError");
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException ef) {

            }
        }
        return false;
    }

    @Override
    public boolean updateList(T t) {
        dataList.add(t);
        uploadToFile();
        return true;
    }

}
