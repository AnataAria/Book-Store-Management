/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controler;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
/**
 *
 * @author AnataArisa
 */
public class Noficiation extends Thread {

    private JLabel noficate;
    private String content;
    public Noficiation(JLabel noficate) {
        this.noficate = noficate;
    }
    @Override
    public void run() {
        noficate.setText(content);
        try {
            System.out.println(Thread.currentThread().getId());
            Thread.sleep(1000);
            noficate.setText("");
            Thread.yield();
        } catch (InterruptedException ex) {
            Logger.getLogger(Noficiation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setContent(String content){
        this.content = content;
    }
}
