/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.jdbc.dto;

/**
 *
 * @author dinuka
 */
public class OrderDetailDto {
    private String orderId;
    private String itemCode;
    private int qty;
    private int discount;

    public OrderDetailDto() {
    }

    public OrderDetailDto(String orderId, String itemCode, int qty, int discount) {
        this.orderId = orderId;
        this.itemCode = itemCode;
        this.qty = qty;
        this.discount = discount;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "OrderDetailDto{" + "orderId=" + orderId + ", itemCode=" + itemCode + ", qty=" + qty + ", discount=" + discount + '}';
    }
    
}
