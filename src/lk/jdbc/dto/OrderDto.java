/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.jdbc.dto;

/**
 *
 * @author dinuka
 */
public class OrderDto {
    private String orderId;
    private String date;
    private String custId;

    public OrderDto() {
    }

    public OrderDto(String orderIt, String date, String custId) {
        this.orderId = orderIt;
        this.date = date;
        this.custId = custId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    @Override
    public String toString() {
        return "OrderDto{" + "orderIt=" + orderId + ", date=" + date + ", custId=" + custId + '}';
    }
    
}
