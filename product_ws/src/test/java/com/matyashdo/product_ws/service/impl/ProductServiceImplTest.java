package com.matyashdo.product_ws.service.impl;

import com.matyashdo.product_ws.dao.ProductDao;
import com.matyashdo.product_ws.dto.ProductDto;
import com.matyashdo.product_ws.model.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class ProductServiceImplTest {

    private static final int PRODUCT_ID = 1;
    private static final String PRODUCT_NAME = "Product";
    private static final int VALUE = 10;

    private ProductDto productDto = new ProductDto();
    private Product product = new Product();

    @Mock
    private ProductDao productDao;

    @InjectMocks
    private ProductServiceImpl productServiceImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        productDto.setProductName(PRODUCT_NAME);
        productDto.setValue(VALUE);

        product.setProductName(PRODUCT_NAME);
        product.setValue(VALUE);
    }

    @Test
    public void testAddProduct() {
        productServiceImpl.addProduct(productDto);
        verify(productDao).addProduct(product);
    }

    @Test
    public void testGetAllProduct() {
        List<Product> products = new ArrayList<>();

        when(productDao.getAllProduct()).thenReturn(new ArrayList<>());

        List<Product> actualProductList = productServiceImpl.getAllProduct();
        Assert.assertEquals(products, actualProductList);
    }

    @Test
    public void testGetProductById() {
        when(productDao.getProductById(PRODUCT_ID)).thenReturn(product);

        Product actualProduct = productServiceImpl.getProductById(PRODUCT_ID);
        Assert.assertEquals(product, actualProduct);
    }

    @Test
    public void testDeleteProductById() {
        productServiceImpl.deleteProductById(PRODUCT_ID);
        verify(productDao).deleteProductById(PRODUCT_ID);
    }
}