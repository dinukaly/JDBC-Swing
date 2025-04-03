/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.jdbc.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author dinuka
 */
public class DBConnection {
    private static DBConnection dbConnection;

    private Connection connection;
    
    public DBConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket","root","Default890");
    }
    
    public static DBConnection getInstance() throws SQLException, ClassNotFoundException {
    if(dbConnection == null){
    dbConnection = new DBConnection();
    }
    return dbConnection;
    }

    public Connection getConnecttion() {
        return connection;
    }
    
}
