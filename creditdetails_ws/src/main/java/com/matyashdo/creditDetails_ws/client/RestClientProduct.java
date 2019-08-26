package com.matyashdo.creditDetails_ws.client;

import com.matyashdo.creditDetails_ws.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

@Component
public class RestClientProduct {

    private static final String PRODUCT_BASE_URL = "http://localhost:8083";
    private static final String CREATE_PRODUCT_PATH = "/api/v1/products/create";
    private static final String GET_PRODUCT_BY_ID_PATH = "/api/v1/products/{0}";
    private static final String DELETE_PRODUCT_PATH = "/api/v1/products/{0}/delete";
    private static final String GET_ALL_PRODUCTS_PATH = "/api/v1/products";

    @Autowired
    private RestTemplate restTemplate;

    public void createProduct(ProductDto productDto) {
        String url = PRODUCT_BASE_URL + buildPath(CREATE_PRODUCT_PATH);
        restTemplate.postForLocation(url, productDto);
    }

    public ProductDto getProductById(int productId) {
        String url = PRODUCT_BASE_URL + buildPath(GET_PRODUCT_BY_ID_PATH, String.valueOf(productId));
        ResponseEntity<ProductDto> productResponseEntity = restTemplate.getForEntity(url, ProductDto.class);
        return productResponseEntity.getBody();
    }

    public void deleteProductById(int productId) {
        String url = PRODUCT_BASE_URL + buildPath(DELETE_PRODUCT_PATH, String.valueOf(productId));
        restTemplate.delete(url);
    }

    public List<ProductDto> getAllProducts(){
        String url = PRODUCT_BASE_URL + GET_ALL_PRODUCTS_PATH;
        List<ProductDto> productDtos = (ArrayList<ProductDto>) restTemplate.getForObject(url, List.class);
        return productDtos;
    }

    private String buildPath(String pathTemplate, String... args) {
        String resourcePath = MessageFormat.format(pathTemplate, args);
        return resourcePath;
    }
}
