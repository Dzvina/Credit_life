package com.matyashdo.product_ws.dao.impl;

import com.matyashdo.product_ws.dao.ProductDao;
import com.matyashdo.product_ws.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addProduct(Product product) {
       String sql ="insert into product values (?,?,?)";
       jdbcTemplate.update(sql, product.getCreditId(), product.getProductName(), product.getValue());
    }

    @Override
    public Product getProduct(int creditId) {
        String sql = "select * from product where credit_id =?";
        Product product = jdbcTemplate.queryForObject(sql,new Object[]{creditId}, new BeanPropertyRowMapper<>(Product.class));
        return product;
    }
}
