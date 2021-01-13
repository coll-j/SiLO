/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author Gema Adi Perwira
 */

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Koneksi {
     Connection koneksi;
    
    public static Connection Koneksi() {
        try {
            System.out.println("com.mysql.cj.jdbc.Driver1");
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/silo?serverTimezone=UTC", "root", "");
            
            return koneksi;
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
            
            return null;
        }
    }
}


