/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.gui;

import com.controler.LoginControler;
import com.controler.UserControler;
import com.model.Account;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

/**
 *
 * @author AnataArisa
 */
public class LoginFrame extends JFrame {

    private LoginControler login = null;
    private UserControler users = null;

    /**
     * Creates new form LoginFrame
     */
    public LoginFrame(UserControler user, LoginControler login) {
        this.login = login;
        this.users = user;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        username = new JTextField();
        password = new JPasswordField();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        login_btn = new JButton();
        authorinfo_btn = new JButton();
        nofication = new JLabel();

        FormListener formListener = new FormListener();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login Terminal");
        setBackground(new Color(0, 0, 0));
        setBounds(new Rectangle(0, 0, 1280, 720));
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        setForeground(Color.black);
        setIconImage(new ImageIcon("src//com//gui//img//login-.png").getImage());
        setName("Login"); // NOI18N
        setSize(new Dimension(1280, 720));

        jPanel1.setBackground(new Color(0, 153, 153));
        jPanel1.setForeground(new Color(0, 255, 255));
        jPanel1.setName("jPanel1"); // NOI18N

        jLabel1.setFont(new Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setForeground(new Color(255, 255, 255));
        jLabel1.setText("LOGIN TERMINAL");
        jLabel1.setToolTipText("");
        jLabel1.setName("jLabel1"); // NOI18N

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jLabel1.getAccessibleContext().setAccessibleName("LoginTitle");

        username.setFont(new Font("Times New Roman", 2, 24)); // NOI18N
        username.setToolTipText("Enter your username here");
        username.setInheritsPopupMenu(true);
        username.setName("username"); // NOI18N
        username.addKeyListener(formListener);

        password.setFont(new Font("Times New Roman", 2, 24)); // NOI18N
        password.setToolTipText("Enter your password here");
        password.setName("password"); // NOI18N
        password.addKeyListener(formListener);

        jLabel2.setFont(new Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new Color(0, 0, 0));
        jLabel2.setText("Password");
        jLabel2.setToolTipText("");
        jLabel2.setName("jLabel2"); // NOI18N

        jLabel3.setFont(new Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setForeground(new Color(0, 0, 0));
        jLabel3.setText("UserName");
        jLabel3.setToolTipText("");
        jLabel3.setName("jLabel3"); // NOI18N

        login_btn.setBackground(new Color(255, 51, 51));
        login_btn.setFont(new Font("Segoe UI", 1, 24)); // NOI18N
        login_btn.setText("Login");
        login_btn.setName("login_btn"); // NOI18N
        login_btn.addActionListener(formListener);

        authorinfo_btn.setBackground(new Color(0, 0, 0));
        authorinfo_btn.setFont(new Font("Dialog", 0, 18)); // NOI18N
        authorinfo_btn.setForeground(new Color(255, 255, 255));
        authorinfo_btn.setText("Author Info");
        authorinfo_btn.setToolTipText("");
        authorinfo_btn.setName("authorinfo_btn"); // NOI18N
        authorinfo_btn.addActionListener(formListener);

        nofication.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        nofication.setForeground(new Color(255, 51, 51));
        nofication.setName("nofication"); // NOI18N

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(298, 298, 298)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(username)
                            .addComponent(password, GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel2))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(278, 278, 278)
                        .addComponent(authorinfo_btn)
                        .addGap(482, 482, 482)
                        .addComponent(login_btn, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(210, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(nofication)
                .addGap(316, 316, 316))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(308, 308, 308)
                    .addComponent(jLabel3)
                    .addContainerGap(865, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(158, 158, 158)
                .addComponent(username, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(password, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(nofication)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(authorinfo_btn)
                    .addComponent(login_btn, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(185, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(249, 249, 249)
                    .addComponent(jLabel3)
                    .addContainerGap(449, Short.MAX_VALUE)))
        );

        username.getAccessibleContext().setAccessibleName("username");
        password.getAccessibleContext().setAccessibleName("password");

        pack();
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements ActionListener, KeyListener {
        FormListener() {}
        public void actionPerformed(ActionEvent evt) {
            if (evt.getSource() == login_btn) {
                LoginFrame.this.login_btnActionPerformed(evt);
            }
            else if (evt.getSource() == authorinfo_btn) {
                LoginFrame.this.authorinfo_btnActionPerformed(evt);
            }
        }

        public void keyPressed(KeyEvent evt) {
            if (evt.getSource() == username) {
                LoginFrame.this.usernameKeyPressed(evt);
            }
            else if (evt.getSource() == password) {
                LoginFrame.this.passwordKeyPressed(evt);
            }
        }

        public void keyReleased(KeyEvent evt) {
        }

        public void keyTyped(KeyEvent evt) {
        }
    }// </editor-fold>//GEN-END:initComponents

    private void login_btnActionPerformed(ActionEvent evt) {//GEN-FIRST:event_login_btnActionPerformed
        String user = username.getText();
        String pass = new String(password.getPassword());
        if ((user.equals("Arisa") && pass.equals("123"))) {
            Account account = new Account(user, pass);
            account.setName("Admin-kun");
            Menu menu = new Menu(account, users, login, this);
            this.setVisible(false);
            menu.setVisible(true);
        } else if (login.checkUserPass(user, pass)) {
            Account account = login.searchAccount(user, pass);
            Menu menu = new Menu(account, users, login, this);
            this.setVisible(false);
            menu.setVisible(true);
            login.createSession(account);
        } else {
            nofication.setText("Sai r thang LOL");
        }
    }//GEN-LAST:event_login_btnActionPerformed

    private void usernameKeyPressed(KeyEvent evt) {//GEN-FIRST:event_usernameKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
            username.transferFocus();
    }//GEN-LAST:event_usernameKeyPressed

    private void passwordKeyPressed(KeyEvent evt) {//GEN-FIRST:event_passwordKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String user = username.getText();
            String pass = new String(password.getPassword());
            if ((user.equals("Arisa") && pass.equals("123"))) {
                Account account = new Account(user, pass);
                account.setName("Admin-kun");
                Menu menu = new Menu(account, users, login, this);
                this.setVisible(false);
                menu.setVisible(true);
            } else if (login.checkUserPass(user, pass)) {
                Account account = login.searchAccount(user, pass);
                Menu menu = new Menu(account, users, login, this);
                this.setVisible(false);
                menu.setVisible(true);
                login.createSession(account);
            } else {
                nofication.setText("Sai r thang LOL");
            }
        }
    }//GEN-LAST:event_passwordKeyPressed

    private void authorinfo_btnActionPerformed(ActionEvent evt) {//GEN-FIRST:event_authorinfo_btnActionPerformed
        // TODO add your handling code here:
        Desktop temp = Desktop.getDesktop();
        try {
            temp.browse(new URI("https://github.com/AnataAria"));
        } catch (URISyntaxException | IOException ex) {
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_authorinfo_btnActionPerformed

    /**
     * @param args the command line arguments
     */
    public boolean visibleSet(boolean set) {
        boolean flag = true;
        try {
            this.visibleSet(set);
        } catch (Exception e) {
            flag = false;
            return flag;
        }
        return flag;
    }

    public JTextField getUsername() {
        return username;
    }

    public JTextField getPassword() {
        return password;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton authorinfo_btn;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JPanel jPanel1;
    private JButton login_btn;
    private JLabel nofication;
    private JPasswordField password;
    private JTextField username;
    // End of variables declaration//GEN-END:variables
}
