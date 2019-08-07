package com.matyashdo.customer_ws.service.impl;

import com.matyashdo.customer_ws.dao.CustomerDao;
import com.matyashdo.customer_ws.dto.CustomerDto;
import com.matyashdo.customer_ws.model.Customer;
import com.matyashdo.customer_ws.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Autowired
    private CustomerDao customerDao;

    @Override
    public void addCustomer(CustomerDto customerDto) {
        LOGGER.info("Creating customer from customerDto: {}", customerDto);
        Customer customer = new Customer(customerDto.getFirstNameCustomer(), customerDto.getLastNameCustomer(), customerDto.getPeselCustomer());
        LOGGER.info("Customer creation: {}", customer);
        LOGGER.info("Calling dao to insert customer");
        customerDao.addCustomer(customer);
        LOGGER.info("Dao successfully inserted customer");
    }

    @Override
    public List<Customer> getAllCustomers() {
        LOGGER.info("Calling dao to get all customers");
        List<Customer> customers = customerDao.getAllCustomers();
        LOGGER.info("Dao successfully got customers");
        return customers;
    }

    @Override
    public Customer getCustomerById(int customerId) {
        LOGGER.info("Calling dao to get customer by id: {}", customerId);
       Customer customer = customerDao.getCustomerById(customerId);
        LOGGER.info("Dao successfully got customer by customer id: {}", customer);
        return customer;
    }

    @Override
    public void deleteCustomerById(int customerId) {
        LOGGER.info("Calling dao to delete customer by id: {}", customerId);
        customerDao.deleteCustomerById(customerId);
        LOGGER.info("Dao successfully deleted customer");
    }

    @Override
    public Customer getCustomerByPesel(String pesel) {
        LOGGER.info("Calling dao to get customer by pesel: {}", pesel);
        Customer customer = customerDao.getCustomerByPesel(pesel);
        LOGGER.info("Dao successfully got customer by customer pesel: {}", customer);
        return customer;
    }
}
