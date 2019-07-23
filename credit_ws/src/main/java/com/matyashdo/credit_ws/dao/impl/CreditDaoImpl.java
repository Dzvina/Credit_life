package com.matyashdo.credit_ws.dao.impl;

import com.matyashdo.credit_ws.dao.CreditDao;
import com.matyashdo.credit_ws.model.Credit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class CreditDaoImpl implements CreditDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int addCredit(Credit credit) {
        String sql = "insert into credit (name_credit) values (?)";
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, credit.getNameCredit());
            return statement;
        }, keyHolder);

        int creditId = keyHolder.getKey().intValue();
        return creditId;
    }

    @Override
    public List<Credit> getAllCredits() {
        String sql = "select * from credit";
        List<Credit> credits = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Credit.class));
        return credits;
    }

    @Override
    public Credit getCreditById(int creditId) {
        Credit credit;
        String sql = "select * from credit where credit_id = ?";
        credit = jdbcTemplate.queryForObject(sql,new Object[]{creditId}, new BeanPropertyRowMapper<>(Credit.class));
        return credit;
    }

}
