package com.matyashdo.product_ws.service.impl;

import com.matyashdo.product_ws.dao.ProductDao;
import com.matyashdo.product_ws.dto.ProductDto;
import com.matyashdo.product_ws.model.Product;
import com.matyashdo.product_ws.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductDao productDao;

    @Override
    public void addProduct(ProductDto productDto) {
        LOGGER.info("Creating product from productDto: {}", productDto);
        Product product = new Product(productDto.getProductName(), productDto.getValue());
        LOGGER.info("Product creation: {}", product);
        LOGGER.info("Calling dao to insert product");
        productDao.addProduct(product);
        LOGGER.info("Dao successfully inserted product");
    }

    @Override
    public List<Product> getAllProduct() {
        LOGGER.info("Calling dao to get all products");
        List<Product> product = productDao.getAllProduct();
        LOGGER.info("Dao successfully got products");
        return product;
    }

    @Override
    public Product getProductById(int productId) {
        LOGGER.info("Calling dao to get product by id: {}", productId);
        Product product = productDao.getProductById(productId);
        LOGGER.info("Dao successfully got product by product id: {}", product);
        return product;
    }

    @Override
    public void deleteProductById(int productId) {
        LOGGER.info("Calling dao to delete product by id: {}", productId);
        productDao.deleteProductById(productId);
        LOGGER.info("Dao successfully deleted product");
    }
}
