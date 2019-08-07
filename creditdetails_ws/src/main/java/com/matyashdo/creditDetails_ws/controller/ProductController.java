package com.matyashdo.creditDetails_ws.controller;

import com.matyashdo.creditDetails_ws.dto.ProductDto;
import com.matyashdo.creditDetails_ws.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @PostMapping(value = "/create")
    public void addProduct(@RequestBody ProductDto productDto) {
        LOGGER.info("Received request for product creation");
        productService.addProduct(productDto);
        LOGGER.info("Product was successfully created");
    }

    @GetMapping(value = "/{productId}")
    public ProductDto getProductById(@PathVariable(value = "productId") int productId) {
        LOGGER.info("Received request for get product by id");
        ProductDto productDto = productService.getProductById(productId);
        LOGGER.info("Product: {} was successfully fetched", productDto);
        return productDto;
    }

    @DeleteMapping(value = "/{productId}/delete")
    public void deleteProductById(@PathVariable(value = "productId") int productId) {
        LOGGER.info("Received request for product deletion");
        productService.deleteProductById(productId);
        LOGGER.info("Product was successfully deleted");
    }
}
