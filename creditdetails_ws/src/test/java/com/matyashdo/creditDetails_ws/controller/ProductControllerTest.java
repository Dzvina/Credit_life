package com.matyashdo.creditDetails_ws.controller;

import com.matyashdo.creditDetails_ws.dto.ProductDto;
import com.matyashdo.creditDetails_ws.service.ProductService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ProductControllerTest {

    private static final int PRODUCT_ID = 1;
    private static final String PRODUCT_NAME = "Product";
    private static final int VALUE = 10;

    private ProductDto productDto = new ProductDto();

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        productDto.setProductId(PRODUCT_ID);
        productDto.setProductName(PRODUCT_NAME);
        productDto.setValue(VALUE);
    }

    @Test
    public void addProduct() {
        productController.addProduct(productDto);
        verify(productService).addProduct(productDto);
    }

    @Test
    public void getProductById() {
        when(productService.getProductById(PRODUCT_ID)).thenReturn(productDto);

        ProductDto actualProductDto = productController.getProductById(PRODUCT_ID);
        Assert.assertEquals(productDto, actualProductDto);
    }

    @Test
    public void deleteProductById() {
        productController.deleteProductById(PRODUCT_ID);
        verify(productService).deleteProductById(PRODUCT_ID);
    }
}