/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.jdbc.model;

import lk.jdbc.db.DBConnection;
import lk.jdbc.dto.ItemDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author dinuka
 */
public class ItemModel {
    public String saveItem (ItemDto itemDto) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnecttion();
        String sql = "INSERT INTO item VALUES(?,?,?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,itemDto.getItemCode());
        preparedStatement.setString(2,itemDto.getItemDesc());
        preparedStatement.setString(3,itemDto.getPackSize());
        preparedStatement.setDouble(4,itemDto.getUnitPrice());
        preparedStatement.setInt(5,itemDto.getQoh());

        return preparedStatement.executeUpdate()>0 ? "Success":"Fail";
    }

    public String updateItem (ItemDto itemDto) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnecttion();
        String sql = "UPDATE item SET Description =?,PackSize =?, UnitPrice =?, QtyOnHand=? WHERE ItemCode =?" ;

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,itemDto.getItemDesc());
        preparedStatement.setString(2,itemDto.getPackSize());
        preparedStatement.setDouble(3,itemDto.getUnitPrice());
        preparedStatement.setInt(4,itemDto.getQoh());
        preparedStatement.setString(5,itemDto.getItemCode());


        return preparedStatement.executeUpdate()>0 ? "Success":"Fail";
    }

    public String deleteItem(String code) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnecttion();
        String sql= "DELETE FROM item WHERE itemCode =? ";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1,code);
        return preparedStatement.executeUpdate()>0?"Success": "Fail";
    }

    public ItemDto searchItem(String code) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnecttion();
        String sql = "SELECT * FROM item WHERE ItemCode =?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1,code);

        ResultSet resultSet= preparedStatement.executeQuery();
        if (resultSet.next()){
            return new ItemDto(resultSet.getString("ItemCode"),
                    resultSet.getString("Description"),
                    resultSet.getString("PackSize"),
                    resultSet.getDouble("UnitPrice"),
                    resultSet.getInt("QtyOnHand"));
        }
        return null;
    }

    public ArrayList<ItemDto> getAllItems() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnecttion();
        String sql = "SELECT * FROM item";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ArrayList<ItemDto>  dtos = new ArrayList<>();

        ResultSet rst = preparedStatement.executeQuery();
        while (rst.next()){
            dtos.add(new ItemDto(rst.getString("ItemCode"),
                    rst.getString("Description"),
                    rst.getString("PackSize"),
                    rst.getDouble("UnitPrice"),
                    rst.getInt("QtyOnHand")));
        }
        return dtos;
    }
}
