package lk.jdbc.controller;

import java.sql.SQLException;
import lk.jdbc.dto.CustomerDto;

import java.util.ArrayList;
import lk.jdbc.model.CustomerModel;

public class CustomerController {
  
    CustomerModel customerModel = new CustomerModel();

    public String saveCustomer(CustomerDto customerDto) throws Exception{
        String resp = customerModel.saveCustomer(customerDto);
        return resp;
    }

    public String updateCustomer(CustomerDto customerDto) throws SQLException, ClassNotFoundException{
        String resp = customerModel.updateCustomer(customerDto);
        return resp;
    }

    public String deleteCustomer(String customerCode) throws SQLException, ClassNotFoundException{
        String resp = customerModel.deleteCustomer(customerCode);
        return resp;
    }

    public CustomerDto searchCustomer(String customerCode) throws SQLException, ClassNotFoundException{
        CustomerDto customerDto = customerModel.searchCustomer(customerCode);
        return  customerDto;
    }

    public ArrayList<CustomerDto> getAll() throws SQLException, ClassNotFoundException{
        ArrayList<CustomerDto> customerDtos = customerModel.getAllCustomers();
        return customerDtos;
    }
}
