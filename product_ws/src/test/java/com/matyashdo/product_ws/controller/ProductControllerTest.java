package com.matyashdo.product_ws.controller;

import com.matyashdo.product_ws.dto.ProductDto;
import com.matyashdo.product_ws.model.Product;
import com.matyashdo.product_ws.service.ProductService;
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

public class ProductControllerTest {

    private static final int PRODUCT_ID = 1;
    private static final String PRODUCT_NAME = "Product";
    private static final int VALUE = 10;

    private ProductDto productDto = new ProductDto();
    private Product expectedProduct = new Product();

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        expectedProduct.setProductId(PRODUCT_ID);
        expectedProduct.setProductName(PRODUCT_NAME);
        expectedProduct.setValue(VALUE);
    }

    @Test
    public void testAddProduct() {
        productController.addProduct(productDto);
        verify(productService).addProduct(productDto);
    }

    @Test
    public void testGetAllProduct() {
        List<Product> products = new ArrayList<>();

        when(productService.getAllProduct()).thenReturn(new ArrayList<>());

        List<Product> actualProductList = productController.getAllProduct();
        Assert.assertEquals(products, actualProductList);
    }

    @Test
    public void testGetProductById() {
        when(productService.getProductById(PRODUCT_ID)).thenReturn(expectedProduct);

        Product actualProduct = productController.getProductById(PRODUCT_ID);
        Assert.assertEquals(expectedProduct, actualProduct);
    }

    @Test
    public void testDeleteProductById() {
        productController.deleteProductById(PRODUCT_ID);
        verify(productService).deleteProductById(PRODUCT_ID);

    }
}