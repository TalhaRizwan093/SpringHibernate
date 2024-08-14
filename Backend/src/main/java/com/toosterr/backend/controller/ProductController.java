package com.toosterr.backend.controller;

import com.toosterr.backend.dto.SaveProductRequest;
import com.toosterr.backend.entity.Product;
import com.toosterr.backend.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> getProducts() {
        try {
            return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/add/product")
    public ResponseEntity<?> addProduct(@RequestBody @Valid SaveProductRequest product) {
        try {
            return new ResponseEntity<>(productService.addProduct(product), HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
