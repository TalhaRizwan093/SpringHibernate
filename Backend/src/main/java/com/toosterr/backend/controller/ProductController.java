package com.toosterr.backend.controller;

import com.toosterr.backend.entity.Product;
import com.toosterr.backend.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productService.findAll();
    }

    @PostMapping("/add/product")
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

}
