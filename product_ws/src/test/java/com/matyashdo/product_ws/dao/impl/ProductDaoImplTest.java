package com.matyashdo.product_ws.dao.impl;

import com.matyashdo.product_ws.model.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class ProductDaoImplTest {

    private static final int PRODUCT_ID = 1;
    private static final String PRODUCT_NAME = "Product";
    private static final int VALUE = 10;

    private Product product = new Product();

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private ProductDaoImpl productDaoImpl;

    @Captor
    ArgumentCaptor<Object[]> objectsArray;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        product.setProductId(PRODUCT_ID);
        product.setProductName(PRODUCT_NAME);
        product.setValue(VALUE);
    }

    @Test
    public void testAddProduct() {
        String sql = "insert into product(product_name, value) values (?,?)";

        productDaoImpl.addProduct(product);
        verify(jdbcTemplate).update(sql, product.getProductName(), product.getValue());
    }

    @Test
    public void testGetAllProduct() {
        List<Product> products = new ArrayList<>();

        when(jdbcTemplate.query(anyString(), any(BeanPropertyRowMapper.class))).thenReturn(products);

        List<Product> actualProductList = productDaoImpl.getAllProduct();
        Assert.assertEquals(products, actualProductList);
    }

    @Test
    public void testGetProductById() {
        when(jdbcTemplate.queryForObject(anyString(), objectsArray.capture(), any(BeanPropertyRowMapper.class))).thenReturn(product);

        Product actualProduct = productDaoImpl.getProductById(PRODUCT_ID);
        Assert.assertEquals(product, actualProduct);
    }

    @Test
    public void testDeleteProductById() {
        String sql = "delete from product where product_id = ?";

        productDaoImpl.deleteProductById(PRODUCT_ID);
        verify(jdbcTemplate).update(sql, PRODUCT_ID);
    }
}