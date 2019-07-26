package com.matyashdo.product_ws.dao.impl;

import com.matyashdo.product_ws.dao.ProductDao;
import com.matyashdo.product_ws.dto.ProductDto;
import com.matyashdo.product_ws.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addProduct(Product product) {
        String sql = "insert into product(product_name, value) values (?,?)";
        jdbcTemplate.update(sql, product.getProductName(), product.getValue());
    }

    @Override
    public List<Product> getAllProduct() {
        String sql = "select * from product";
        List<Product> products = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Product.class));
        return products;
    }

    @Override
    public Product getProductById(int product_id) {
        String sql = "select * from product where product_id = ?";
        Product product = jdbcTemplate.queryForObject(sql, new Object[]{product_id}, new BeanPropertyRowMapper<>(Product.class));
        return product;
    }

    @Override
    public void deleteProductById(int productId) {
        String sql = "delete from product where product_id = ?";
        jdbcTemplate.update(sql, productId);
    }
}
