package com.matyashdo.customer_ws.dao;

import com.matyashdo.customer_ws.model.Customer;

import java.util.List;

public interface CustomerDao {

    void addCustomer(Customer customer);

    List<Customer> getAllCustomers();

    Customer getCustomerById(int customerId);

    void deleteCustomerById(int customerId);

}
