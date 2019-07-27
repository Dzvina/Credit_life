package com.matyashdo.customer_ws.service;

import com.matyashdo.customer_ws.dao.impl.CustomerDaoImpl;
import com.matyashdo.customer_ws.dto.CustomerDto;
import com.matyashdo.customer_ws.model.Customer;

import java.util.List;

public interface CustomerService {

    void addCustomer(CustomerDto customerDto);

    List<Customer> getAllCustomers();

    Customer getCustomerById(int customerId);

    void deleteCustomerById(int customerId);

    Customer getCustomerByPesel(String pesel);
}
