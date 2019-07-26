package com.matyashdo.product_ws.service.impl;

import com.matyashdo.product_ws.dao.ProductDao;
import com.matyashdo.product_ws.dto.ProductDto;
import com.matyashdo.product_ws.model.Product;
import com.matyashdo.product_ws.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public void addProduct(ProductDto productDto) {
        Product product = new Product(productDto.getProductName(), productDto.getValue());
        productDao.addProduct(product);
    }

    @Override
    public List<Product> getAllProduct() {
        return productDao.getAllProduct();
    }

    @Override
    public Product getProductById(int productId) {
        return productDao.getProductById(productId);
    }

    @Override
    public void deleteProductById(int productId) {
        productDao.deleteProductById(productId);
    }
}
