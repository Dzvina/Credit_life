package com.matyashdo.credit_ws.dao.impl;

import com.matyashdo.credit_ws.dao.CreditDao;
import com.matyashdo.credit_ws.model.Credit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CreditDaoImpl implements CreditDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addCredit(Credit credit) {
        String sql = "insert into credit (customer_id ,product_id ,name_credit) values (?,?,?)";
        jdbcTemplate.update(sql, credit.getCustomerId(), credit.getProductId(), credit.getNameCredit());
    }

    @Override
    public List<Credit> getAllCredits() {
        String sql = "select * from credit";
        List<Credit> credits = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Credit.class));
        return credits;
    }

    @Override
    public Credit getCreditById(int creditId) {
        String sql = "select * from credit where credit_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{creditId}, new BeanPropertyRowMapper<>(Credit.class));
    }

    @Override
    public void deleteCreditById(int creditId) {
        String sql = "delete from credit where credit_id = ?";
        jdbcTemplate.update(sql, creditId);
    }

}
