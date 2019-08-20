package com.matyashdo.creditDetails_ws.service.impl;

import com.matyashdo.creditDetails_ws.client.RestClientCredit;
import com.matyashdo.creditDetails_ws.client.RestClientProduct;
import com.matyashdo.creditDetails_ws.dto.ProductDto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ProductServiceImplTest {

    private static final int PRODUCT_ID = 1;
    private static final String PRODUCT_NAME = "Product";
    private static final int VALUE = 10;

    private ProductDto productDto = new ProductDto();

    @Mock
    private RestClientProduct restClientProduct;

    @InjectMocks
    private ProductServiceImpl productServiceImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        productDto.setProductId(PRODUCT_ID);
        productDto.setProductName(PRODUCT_NAME);
        productDto.setValue(VALUE);
    }

    @Test
    public void testAddProduct() {
        productServiceImpl.addProduct(productDto);
        verify(restClientProduct).createProduct(productDto);
    }

    @Test
    public void testGetProductById() {
        when(restClientProduct.getProductById(PRODUCT_ID)).thenReturn(productDto);

        ProductDto actualProduct = productServiceImpl.getProductById(PRODUCT_ID);
        Assert.assertEquals(productDto, actualProduct);
    }

    @Test
    public void testDeleteProductById() {
        productServiceImpl.deleteProductById(PRODUCT_ID);
        verify(restClientProduct).deleteProductById(PRODUCT_ID);
    }
}