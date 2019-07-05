package com.matyashdo.product_ws.dao;

import com.matyashdo.product_ws.model.Product;

public interface ProductDao {

    void addProduct(Product product);

    Product getProduct(int creditId);
}
