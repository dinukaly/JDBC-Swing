/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.jdbc.model;

import java.util.ArrayList;
import lk.jdbc.db.DBConnection;
import lk.jdbc.dto.OrderDetailDto;
import lk.jdbc.dto.OrderDto;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author dinuka
 */
public class OrderModel {

    public static String placeOrder(OrderDto orderDto, ArrayList<OrderDetailDto> orderDetailDtos) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();

        try {
            connection.setAutoCommit(false);

            String orderSQL = "INSERT INTO orders VALUES (?,?,?)";
            PreparedStatement orderStatement = connection.prepareStatement(orderSQL);
            orderStatement.setString(1, orderDto.getOrderId());
            orderStatement.setString(2, orderDto.getDate());
             orderStatement.setString(3, orderDto.getCustId());
            
           

            boolean isOrderSaved = orderStatement.executeUpdate() > 0;

            if (isOrderSaved) {
                String orderDetailSQL = "INSERT INTO orderDetail VALUES(?,?,?,?)";

                boolean isOrderDetailSaved = true;

                for (OrderDetailDto orderDetailDto : orderDetailDtos) {
                    PreparedStatement orderDetailStatment = connection.prepareStatement(orderDetailSQL);
                    orderDetailStatment.setString(1, orderDto.getOrderId());
                    orderDetailStatment.setString(2, orderDetailDto.getItemCode());
                    orderDetailStatment.setInt(3, orderDetailDto.getQty());
                    orderDetailStatment.setInt(4, orderDetailDto.getDiscount());

                    if (!(orderDetailStatment.executeUpdate() > 0)) {
                        isOrderDetailSaved = false;
                    }
                }

                if (isOrderDetailSaved) {
                    String itemUpdateSQL = "UPDATE Item SET QtyOnHand =(QtyOnHand-?) WHERE ItemCode=?";
                    boolean isItemUpdated = true;

                    for (OrderDetailDto orderDetailDto : orderDetailDtos) {
                        PreparedStatement itemStatement = connection.prepareStatement(itemUpdateSQL);
                        itemStatement.setInt(1, orderDetailDto.getQty());
                        itemStatement.setString(2, orderDetailDto.getItemCode());

                        if (!(itemStatement.executeUpdate() > 0)) {
                            isItemUpdated = false;
                        }
                    }
                    if (isItemUpdated) {
                        connection.commit();
                        return "success";
                    } else {
                        connection.rollback();
                        return "Item Update Error";
                    }
                } else {
                    connection.rollback();
                    return "Order Detail Save Error";
                }
            } else {
                connection.rollback();
                return "Order save Error";
            }

        } catch (Exception e) {
            connection.rollback();
            throw e;
        } finally {
            connection.setAutoCommit(true);
        }
    }

}
