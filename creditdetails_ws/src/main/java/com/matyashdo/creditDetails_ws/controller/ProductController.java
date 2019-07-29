package com.matyashdo.creditDetails_ws.controller;

import com.matyashdo.creditDetails_ws.dto.ProductDto;
import com.matyashdo.creditDetails_ws.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(value = "/create")
    public void addProduct(@RequestBody ProductDto productDto) {
        productService.addProduct(productDto);
    }

    @GetMapping(value = "/{productId}")
    public ProductDto getProductById(@PathVariable(value = "productId") int productId) {
        return productService.getProductById(productId);
    }

    @DeleteMapping(value = "/{productId}/delete")
    public void deleteProductById(@PathVariable(value = "productId") int productId) {
        productService.deleteProductById(productId);
    }
}
