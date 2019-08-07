package com.matyashdo.product_ws.dao.impl;

import com.matyashdo.product_ws.dao.ProductDao;
import com.matyashdo.product_ws.dto.ProductDto;
import com.matyashdo.product_ws.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductDaoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addProduct(Product product) {
        LOGGER.info("Inserting product into DB");
        String sql = "insert into product(product_name, value) values (?,?)";
        jdbcTemplate.update(sql, product.getProductName(), product.getValue());
        LOGGER.info("Product was successfully inserted into DB");
    }

    @Override
    public List<Product> getAllProduct() {
        LOGGER.info("Fetching all products from DB");
        String sql = "select * from product";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Product.class));
    }

    @Override
    public Product getProductById(int product_id) {
        LOGGER.info("Fetching product by id from DB");
        String sql = "select * from product where product_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{product_id}, new BeanPropertyRowMapper<>(Product.class));
    }

    @Override
    public void deleteProductById(int productId) {
        LOGGER.info("Delete product by id from DB");
        String sql = "delete from product where product_id = ?";
        jdbcTemplate.update(sql, productId);
    }
}
