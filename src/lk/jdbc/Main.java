/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lk.jdbc;

import lk.jdbc.db.DBConnection;
import lk.jdbc.view.ItemView;

import java.sql.SQLException;
import lk.jdbc.view.CustomerView;
import lk.jdbc.view.OrderView;

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

        new ItemView().setVisible(true);
       new CustomerView().setVisible(true);
       new OrderView().setVisible(true);
    }
    
}
