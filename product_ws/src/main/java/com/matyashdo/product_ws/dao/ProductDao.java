package com.matyashdo.product_ws.dao;

import com.matyashdo.product_ws.dto.ProductDto;
import com.matyashdo.product_ws.model.Product;

import java.util.List;

public interface ProductDao {

    void addProduct(Product product);

    List<Product> getAllProduct();

    Product getProductById(int productId);

    void deleteProductById(int productId);
}
