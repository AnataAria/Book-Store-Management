/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main;

import com.gui.*;
import com.controler.*;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author AnataArisa
 */
public class Main {
    private static LoginControler login;
    private static UserControler user;
    private static String bookPath = "src\\local\\data\\book.dat";
    private static String pubPath = "src\\local\\data\\publisher.dat";

    public static void main(String[] args) {
        login = new LoginControler();
        user = new UserControler(bookPath, pubPath);
        if (!login.checkSession()) {
            LoginFrame loginWindow = new LoginFrame(user, login);
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    if (user.getFbcStatus() && user.getFpcStatus()) {
                        loginWindow.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(new JFrame(), "Can't load data, crashing");
                    }
                }
            });
        } else {
            Menu menu = new Menu(login.getSs(), user, login);
            EventQueue.invokeLater(() -> {
                if (user.getFbcStatus() && user.getFpcStatus()) {
                    menu.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "Can't load data, crashing");
                }
            });
        }
    }
}
