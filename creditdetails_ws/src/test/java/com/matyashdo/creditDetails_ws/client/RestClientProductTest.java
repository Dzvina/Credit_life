package com.matyashdo.creditDetails_ws.client;

import com.matyashdo.creditDetails_ws.controller.ProductController;
import com.matyashdo.creditDetails_ws.dto.ProductDto;
import com.matyashdo.creditDetails_ws.service.ProductService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RestClientProductTest {

    private static final int PRODUCT_ID = 1;
    private static final String PRODUCT_NAME = "Product";
    private static final int VALUE = 10;

    private static final String CREATE_PRODUCT_URL = "http://localhost:8083/api/v1/products/create";
    private static final String GET_PRODUCT_BY_ID_URL = "http://localhost:8083/api/v1/products/1";
    private static final String DELETE_PRODUCT_URL = "http://localhost:8083/api/v1/products/1/delete";
    private static final String GET_ALL_PRODUCTS_URL = "http://localhost:8083/api/v1/products";


    private ProductDto productDto = new ProductDto();

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private RestClientProduct restClientProduct;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        productDto.setProductId(PRODUCT_ID);
        productDto.setProductName(PRODUCT_NAME);
        productDto.setValue(VALUE);
    }

    @Test
    public void createProduct() {
        restClientProduct.createProduct(productDto);
        verify(restTemplate).postForLocation(CREATE_PRODUCT_URL, productDto);
    }

    @Test
    public void getProductById() {
        ResponseEntity<ProductDto> responseEntity = new ResponseEntity(productDto, HttpStatus.OK);

        when(restTemplate.getForEntity(GET_PRODUCT_BY_ID_URL, ProductDto.class)).thenReturn(responseEntity);
        ProductDto actualProductDto = restClientProduct.getProductById(PRODUCT_ID);

        Assert.assertEquals(productDto, actualProductDto);
    }

    @Test
    public void deleteProductById() {
        restClientProduct.deleteProductById(PRODUCT_ID);
        verify(restTemplate).delete(DELETE_PRODUCT_URL);
    }

    @Test
    public void testGetAllCustomersProducts() {
        List<ProductDto> expectedProductDtoList = new ArrayList<>();

        when(restTemplate.getForObject(GET_ALL_PRODUCTS_URL, List.class)).thenReturn(new ArrayList<>());

        List<ProductDto> actualProductDtoList = restClientProduct.getAllProducts();

        Assert.assertEquals(expectedProductDtoList, actualProductDtoList);
    }
}