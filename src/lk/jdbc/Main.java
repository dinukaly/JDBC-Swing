/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lk.jdbc;

import lk.jdbc.db.DBConnection;
import lk.jdbc.view.ItemView;

import java.sql.SQLException;

/**
 *
 * @author dinuka
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // TODO code application logic here

       // DBConnection.getInstance().getConnecttion();
        new ItemView().setVisible(true);
    }
    
}
