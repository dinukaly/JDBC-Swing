/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.jdbc.dto;

/**
 *
 * @author dinuka
 */
public class ItemDto {
    private String itemCode;
    private String itemDesc;
    private String packSize;
    private double unitPrice;
    private int qoh;

    @Override
    public String toString() {
        return "ItemDto{" + "itemCode=" + itemCode + ", itemDesc=" + itemDesc + ", packSize=" + packSize + ", unitPrice=" + unitPrice + ", qoh=" + qoh + '}';
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public String getPackSize() {
        return packSize;
    }

    public void setPackSize(String packSize) {
        this.packSize = packSize;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQoh() {
        return qoh;
    }

    public void setQoh(int qoh) {
        this.qoh = qoh;
    }

    public ItemDto() {
    }

    public ItemDto(String itemCode, String itemDesc, String packSize, double unitPrice, int qoh) {
        this.itemCode = itemCode;
        this.itemDesc = itemDesc;
        this.packSize = packSize;
        this.unitPrice = unitPrice;
        this.qoh = qoh;
    }
}
