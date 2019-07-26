package com.matyashdo.product_ws.service;

import com.matyashdo.product_ws.dto.ProductDto;
import com.matyashdo.product_ws.model.Product;

import java.util.List;

public interface ProductService {

    void addProduct(ProductDto productDto);

    List<Product> getAllProduct();

    Product getProductById(int productId);

    void deleteProductById(int productId);
}
