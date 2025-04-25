/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.jdbc.controller;

import java.util.ArrayList;
import lk.jdbc.dto.OrderDetailDto;
import lk.jdbc.dto.OrderDto;
import lk.jdbc.model.OrderModel;

/**
 *
 * @author dinuka
 */
public class OrderController {

    public String placeOrder(OrderDto orderDto, ArrayList<OrderDetailDto> orderDetailDtos) throws Exception {
        String resp = OrderModel.placeOrder(orderDto, orderDetailDtos);
        return resp;
    }

}
