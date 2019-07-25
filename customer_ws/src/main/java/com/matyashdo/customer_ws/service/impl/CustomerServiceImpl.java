package com.matyashdo.customer_ws.service.impl;

import com.matyashdo.customer_ws.dao.CustomerDao;
import com.matyashdo.customer_ws.dto.CustomerDto;
import com.matyashdo.customer_ws.model.Customer;
import com.matyashdo.customer_ws.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public void addCustomer(CustomerDto customerDto) {
        Customer customer = new Customer(customerDto.getFirstNameCustomer(), customerDto.getLastNameCustomer(), customerDto.getPeselCustomer());
        customerDao.addCustomer(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerDao.getAllCustomers();
    }

    @Override
    public Customer getCustomerById(int customerId) {
        return customerDao.getCustomerById(customerId);
    }

    @Override
    public void deleteCustomerById(int customerId) {
        customerDao.deleteCustomerById(customerId);
    }
}
