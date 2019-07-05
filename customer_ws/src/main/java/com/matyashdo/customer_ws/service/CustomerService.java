package com.matyashdo.customer_ws.service;

import com.matyashdo.customer_ws.model.Customer;

public interface CustomerService {

    void addCustomer(Customer customer);

    Customer getCustomer(int creditId);
}
