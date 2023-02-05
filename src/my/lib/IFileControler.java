/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package my.lib;

import java.util.List;

/**
 *
 * @author AnataArisa
 * @param <T>
 */
public interface IFileControler <T>{
    public List<T> getAll();
    public boolean updateList(List<T> list);
    public boolean updateList(T t);
    public boolean uploadToFile();
    public boolean loadFromFile();
    public void setFilepath(String filepath);
    public String getFilepath();
}
