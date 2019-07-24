package com.matyashdo.customer_ws.dao;

import com.matyashdo.customer_ws.model.Customer;

import java.util.List;

public interface CustomerDao {

    void addCustomer(Customer customer);

    Customer getCustomer(int creditId);

    List<Integer> getCreditIdsByCustomerId(int customerId);
}
