package com.matyashdo.customer_ws.dao.impl;

import com.matyashdo.customer_ws.dao.CustomerDao;
import com.matyashdo.customer_ws.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addCustomer(Customer customer) {
        String sql = "insert into customer (first_name_customer, last_name_customer, pesel_customer) values(?,?,?)";
        jdbcTemplate.update(sql, customer.getFirstNameCustomer(), customer.getLastNameCustomer(), customer.getPeselCustomer());
    }

    @Override
    public List<Customer> getAllCustomers() {
        String sql = "select * from customer";
        List<Customer> customers = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Customer.class));
        return customers;
    }

    @Override
    public Customer getCustomerById(int customerId) {
        String sql = "select * from customer where customer_id=?";
        Customer customer = jdbcTemplate.queryForObject(sql, new Object[]{customerId}, new BeanPropertyRowMapper<>(Customer.class));
        return customer;
    }

    @Override
    public void deleteCustomerById(int customerId) {
        String sql = "delete from customer where customer_id = ?";
        jdbcTemplate.update(sql, customerId);
    }

    @Override
    public Customer getCustomerByPesel(String pesel) {
        String sql = "select * from customer where pesel_customer = ?";
        Customer customer = jdbcTemplate.queryForObject(sql, new Object[]{pesel}, new BeanPropertyRowMapper<>(Customer.class));
        return customer;
    }

}
