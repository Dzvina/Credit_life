package com.matyashdo.creditDetails_ws.service;

import com.matyashdo.creditDetails_ws.dto.ProductDto;

import java.util.List;

public interface ProductService {

    void addProduct(ProductDto productDto);

    ProductDto getProductById(int productId);

    void deleteProductById(int productId);

    List<ProductDto> getAllProducts();
}
