package com.matyashdo.creditDetails_ws.service.impl;

import com.matyashdo.creditDetails_ws.client.RestClient;
import com.matyashdo.creditDetails_ws.dto.ProductDto;
import com.matyashdo.creditDetails_ws.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public void addProduct(ProductDto productDto) {
        RestClient.createProduct(productDto);
    }

    @Override
    public ProductDto getProductById(int productId) {
        return RestClient.getProductById(productId);
    }

    @Override
    public void deleteProductById(int productId) {
        RestClient.deleteProductById(productId);
    }
}
