package com.matyashdo.customer_ws.dao;

import com.matyashdo.customer_ws.model.Customer;

public interface CustomerDao {

    void addCustomer(Customer customer);

    Customer getCustomer(int creditId);
}
