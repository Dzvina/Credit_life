package com.matyashdo.product_ws.service;

import com.matyashdo.product_ws.model.Product;

public interface ProductService {

    void addProduct(Product product);

    Product getProduct(int creditId);
}
