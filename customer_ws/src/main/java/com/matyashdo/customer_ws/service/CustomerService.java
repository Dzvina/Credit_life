package com.matyashdo.customer_ws.service;

import com.matyashdo.customer_ws.model.Customer;

import java.util.List;

public interface CustomerService {

    void addCustomer(Customer customer);

    Customer getCustomer(int creditId);

    List<Integer> getCreditIdsByCustomerId(int customerId);
}
