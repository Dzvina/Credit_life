package com.matyashdo.creditDetails_ws.service.impl;

import com.matyashdo.creditDetails_ws.client.RestClient;
import com.matyashdo.creditDetails_ws.dto.ProductDto;
import com.matyashdo.creditDetails_ws.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Override
    public void addProduct(ProductDto productDto) {
        LOGGER.info("Sending create product request to product_ws");
        RestClient.createProduct(productDto);
        LOGGER.info("Product created successfully");
    }

    @Override
    public ProductDto getProductById(int productId) {
        LOGGER.info("Sending get product by id request to product_ws");
        ProductDto productDto = RestClient.getProductById(productId);
        LOGGER.info("Received following productDto in response: {}", productDto);
        return productDto;
    }

    @Override
    public void deleteProductById(int productId) {
        LOGGER.info("Sending delete product by id request to product_ws");
        RestClient.deleteProductById(productId);
        LOGGER.info("Product deleted successfully");
    }
}
