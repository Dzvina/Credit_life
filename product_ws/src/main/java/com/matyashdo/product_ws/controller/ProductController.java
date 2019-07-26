package com.matyashdo.product_ws.controller;

import com.matyashdo.product_ws.dto.ProductDto;
import com.matyashdo.product_ws.model.Product;
import com.matyashdo.product_ws.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping(value = "/create")
    public void addProduct(@RequestBody ProductDto productDto) {
        productService.addProduct(productDto);
    }

    @GetMapping
    public List<Product> getAllProduct(){
        return productService.getAllProduct();
    }

    @GetMapping(value = "/{productId}")
    public Product getProductById(@PathVariable("productId") int productId) {
        return productService.getProductById(productId);
    }

    @DeleteMapping(value = "/{productId}/delete")
    public void deleteProductById(@PathVariable int productId){
        productService.deleteProductById(productId);
    }
}
