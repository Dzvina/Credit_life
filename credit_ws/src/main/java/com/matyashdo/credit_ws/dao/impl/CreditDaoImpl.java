package com.matyashdo.credit_ws.dao.impl;

import com.matyashdo.credit_ws.dao.CreditDao;
import com.matyashdo.credit_ws.model.Credit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CreditDaoImpl implements CreditDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreditDao.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addCredit(Credit credit) {
        LOGGER.info("Inserting credit into DB");
        String sql = "insert into credit (customer_id ,product_id ,name_credit) values (?,?,?)";
        jdbcTemplate.update(sql, credit.getCustomerId(), credit.getProductId(), credit.getNameCredit());
        LOGGER.info("Credit was successfully inserted into DB");
    }

    @Override
    public List<Credit> getAllCredits() {
        LOGGER.info("Fetching all credits from DB");
        String sql = "select * from credit";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Credit.class));
    }

    @Override
    public Credit getCreditById(int creditId) {
        LOGGER.info("Fetching credit by id from DB");
        String sql = "select * from credit where credit_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{creditId}, new BeanPropertyRowMapper<>(Credit.class));
    }

    @Override
    public void deleteCreditById(int creditId) {
        LOGGER.info("Delete credit by id from DB");
        String sql = "delete from credit where credit_id = ?";
        jdbcTemplate.update(sql, creditId);
    }

    @Override
    public List<Credit> getCreditsByCustomerId(int customerId) {
        LOGGER.info("Fetching credit by customer id from DB");
        String sql = "select * from credit where customer_id = ?";
        return jdbcTemplate.query(sql, new Object[]{customerId}, new BeanPropertyRowMapper<>(Credit.class));
    }

    @Override
    public List<Credit> getCreditsByProductId(int productId) {
        LOGGER.info("Fetching credit by product id from DB");
        String sql = "select * from credit where product_id = ?";
        return jdbcTemplate.query(sql, new Object[]{productId}, new BeanPropertyRowMapper<>(Credit.class));
    }
}
