package com.matyashdo.product_ws.service.impl;

import com.matyashdo.product_ws.dao.ProductDao;
import com.matyashdo.product_ws.model.Product;
import com.matyashdo.product_ws.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public void addProduct(Product product) {
        productDao.addProduct(product);
    }

    @Override
    public Product getProduct(int creditId) {
        return productDao.getProduct(creditId);
    }
}
