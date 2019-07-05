package com.matyashdo.product_ws.controller;

import com.matyashdo.product_ws.model.Product;
import com.matyashdo.product_ws.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping(value = "/creditId/{creditId}/productName/{productName}/value/{value}/create")
    public void addProduct(@PathVariable("creditId") int creditId,
                           @PathVariable("productName") String productName,
                           @PathVariable("value") int value) {
        Product product = new Product(creditId, productName, value);
        productService.addProduct(product);
    }

    @GetMapping(value = "/creditId/{creditId}/getProduct")
    public Product getProduct(@PathVariable("creditId") int creditId) {
        return productService.getProduct(creditId);
    }
}
