package com.matyashdo.product_ws.controller;

import com.matyashdo.product_ws.dto.ProductDto;
import com.matyashdo.product_ws.model.Product;
import com.matyashdo.product_ws.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    ProductService productService;

    @PostMapping(value = "/create")
    public void addProduct(@RequestBody ProductDto productDto) {
        LOGGER.info("Received request for product creation");
        productService.addProduct(productDto);
        LOGGER.info("Product was successfully created");
    }

    @GetMapping
    public List<Product> getAllProduct() {
        LOGGER.info("Received request for get all products");
        List<Product> product = productService.getAllProduct();
        LOGGER.info("Products were successfully fetched: {}", product);
        return product;
    }

    @GetMapping(value = "/{productId}")
    public Product getProductById(@PathVariable("productId") int productId) {
        LOGGER.info("Received request for get product by id");
        Product product = productService.getProductById(productId);
        LOGGER.info("Product: {} was successfully fetched", product);
        return product;
    }

    @DeleteMapping(value = "/{productId}/delete")
    public void deleteProductById(@PathVariable int productId) {
        LOGGER.info("Received request for product deletion");
        productService.deleteProductById(productId);
        LOGGER.info("Product was successfully deleted");
    }
}
