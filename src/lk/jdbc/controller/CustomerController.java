package lk.jdbc.controller;

import lk.jdbc.dto.CustomerDto;

import java.util.ArrayList;
import lk.jdbc.model.CustomerModel;

public class CustomerController {
    
    CustomerModel customerModel = new CustomerModel();

    public String saveCustomer(CustomerDto customerDto){
        String resp = customerModel.saveCustomer(customerDto);
        return resp;
    }

    public String updateCustomer(CustomerDto customerDto){
        String resp = customerModel.updateCustomer(customerDto);
        return resp;
    }

    public String deleteCustomer(String customerCode){
        String resp = customerModel.deleteCustomer(customerCode);
        return resp;
    }

    public CustomerDto searchCustomer(String customerCode){
        CustomerDto customerDto = customerModel.searchCustomer(customerCode);
        return  customerDto;
    }

    public ArrayList<CustomerDto> getAll(){
        ArrayList<CustomerDto> customerDtos = customerModel.getAllCustomers();
        return customerDtos;
    }
}
