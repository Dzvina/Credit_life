package com.matyashdo.customer_ws.dao.impl;

import com.matyashdo.customer_ws.dao.CustomerDao;
import com.matyashdo.customer_ws.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addCustomer(Customer customer) {
        String sql = "insert into customer values(?,?,?,?)";
        jdbcTemplate.update(sql, customer.getCreditId(), customer.getFirstNameCustomer(), customer.getLastNameCustomer(), customer.getPeselCustomer());
    }

    @Override
    public Customer getCustomer(int creditId) {
        String sql = "select * from customer where credit_id=?";
        Customer customer = jdbcTemplate.queryForObject(sql, new Object[]{creditId}, new BeanPropertyRowMapper<>(Customer.class));
        return customer;
    }
}
