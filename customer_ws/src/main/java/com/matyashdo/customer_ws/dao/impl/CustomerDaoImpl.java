package com.matyashdo.customer_ws.dao.impl;

import com.matyashdo.customer_ws.dao.CustomerDao;
import com.matyashdo.customer_ws.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerDaoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addCustomer(Customer customer) {
        LOGGER.info("Inserting customer into DB");
        String sql = "insert into customer (first_name_customer, last_name_customer, pesel_customer) values(?,?,?)";
        jdbcTemplate.update(sql, customer.getFirstNameCustomer(), customer.getLastNameCustomer(), customer.getPeselCustomer());
        LOGGER.info("Customer was successfully inserted into DB");
    }

    @Override
    public List<Customer> getAllCustomers() {
        LOGGER.info("Fetching all customer from DB");
        String sql = "select * from customer";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Customer.class));
    }

    @Override
    public Customer getCustomerById(int customerId) {
        LOGGER.info("Fetching customer by id from DB");
        String sql = "select * from customer where customer_id=?";
        Customer customer = jdbcTemplate.queryForObject(sql, new Object[]{customerId}, new BeanPropertyRowMapper<>(Customer.class));
        return customer;
    }

    @Override
    public void deleteCustomerById(int customerId) {
        LOGGER.info("Delete customer by id from DB");
        String sql = "delete from customer where customer_id = ?";
        jdbcTemplate.update(sql, customerId);
    }

    @Override
    public Customer getCustomerByPesel(String pesel) {
        LOGGER.info("Fetching customer by pesel from DB");
        String sql = "select * from customer where pesel_customer = ?";
        Customer customer = jdbcTemplate.queryForObject(sql, new Object[]{pesel}, new BeanPropertyRowMapper<>(Customer.class));
        return customer;
    }

}
