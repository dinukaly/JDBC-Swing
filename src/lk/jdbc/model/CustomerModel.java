/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.jdbc.model;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import lk.jdbc.db.DBConnection;
import lk.jdbc.dto.CustomerDto;

/**
 *
 * @author dinuka
 */
public class CustomerModel {

    public String saveCustomer(CustomerDto customerDto) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = ("INSERT INTO customer VALUES(?,?,?,?,?,?,?,?,?)");

        PreparedStatement preparedStatment = connection.prepareStatement(sql);
        preparedStatment.setString(1, customerDto.getCusId());
        preparedStatment.setString(2, customerDto.getCusTitle());
        preparedStatment.setString(3, customerDto.getCusName());
        preparedStatment.setString(4, customerDto.getDob());
        preparedStatment.setDouble(5, customerDto.getSalary());
        preparedStatment.setString(6, customerDto.getCusAddress());
        preparedStatment.setString(7, customerDto.getCity());
        preparedStatment.setString(8, customerDto.getProvince());
        preparedStatment.setString(9, customerDto.getPostalCode());

        return preparedStatment.executeUpdate() > 0 ? "Success" : "Fail";

    }

    public String updateCustomer(CustomerDto customerDto) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE customer SET CustTitle=?, CustName =?, DOB=?, salary=?, CustAddress=?,City=?,Province=?,PostalCode=? WHERE CustID =?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        
        preparedStatement.setString(1, customerDto.getCusTitle());
        preparedStatement.setString(2, customerDto.getCusName());
        preparedStatement.setString(3, customerDto.getDob());
        preparedStatement.setDouble(4, customerDto.getSalary());
        preparedStatement.setString(5, customerDto.getCusAddress());
        preparedStatement.setString(6, customerDto.getCity());
        preparedStatement.setString(7, customerDto.getProvince());
        preparedStatement.setString(8, customerDto.getPostalCode());
        preparedStatement.setString(9, customerDto.getCusId());

        return preparedStatement.executeUpdate() > 0 ? "Success" : "Fail";
    }

    public String deleteCustomer(String customerCode) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM customer where CustID =?";
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, customerCode);
        
        return preparedStatement.executeUpdate()>0? "Success": "Fail";
    }

    public CustomerDto searchCustomer(String customerCode) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM customer where CustID =?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, customerCode);

        ResultSet rst = preparedStatement.executeQuery();

        if (rst.next()) {
            return new CustomerDto(rst.getString("CustID"),
                    rst.getString("CustTitle"),
                    rst.getString("CustName"),
                    rst.getString("DOB"),
                    rst.getDouble("salary"),
                    rst.getString("CustAddress"),
                    rst.getString("City"),
                    rst.getString("Province"),
                    rst.getString("PostalCode")
            );
        }
        return null;
    }

    public ArrayList<CustomerDto> getAllCustomers() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM customer";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ArrayList<CustomerDto> dtos = new ArrayList<>();

        ResultSet rst = preparedStatement.executeQuery();

        while (rst.next()) {
            dtos.add(new CustomerDto(
                    rst.getString("CustID"),
                    rst.getString("CustTitle"),
                    rst.getString("CustName"),
                    rst.getString("DOB"),
                    rst.getDouble("salary"),
                    rst.getString("CustAddress"),
                    rst.getString("City"),
                    rst.getString("Province"),
                    rst.getString("PostalCode")
            ));
        }
        return dtos;
    }

}
