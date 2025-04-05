package lk.jdbc.controller;

import lk.jdbc.dto.ItemDto;
import lk.jdbc.model.ItemModel;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemController {
    private ItemModel itemModel = new ItemModel();
    public String saveItem(ItemDto itemDto) throws SQLException, ClassNotFoundException {
        String resp = itemModel.saveItem(itemDto);
        return resp;
    }
    public String updateItem(ItemDto itemDto) throws SQLException, ClassNotFoundException {
        String resp = itemModel.updateItem(itemDto);
        return resp;
    }

    public String deleteItem (String code) throws SQLException, ClassNotFoundException {
        String resp = itemModel.deleteItem(code);
        return resp;
    }

    public  ItemDto searchItem(String code) throws SQLException, ClassNotFoundException {
        ItemDto itemDto = itemModel.searchItem(code);
        return  itemDto;
    }

    public ArrayList<ItemDto> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<ItemDto> itemDtos = itemModel.getAllItems() ;
        return itemDtos;
    }
}
