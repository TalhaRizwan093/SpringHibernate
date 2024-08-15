package com.toosterr.backend.controller;

import com.toosterr.backend.dto.ProductPageRequest;
import com.toosterr.backend.dto.SaveProductRequest;
import com.toosterr.backend.entity.Product;
import com.toosterr.backend.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.data.web.PageableDefault;
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
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/products/page")
    public ResponseEntity<?> getProducts(@RequestParam(defaultValue = "0") int pageNumber,
                                         @RequestParam(defaultValue = "10") int pageSize
    ) {
        return new ResponseEntity<>(productService.findAll(pageNumber, pageSize), HttpStatus.OK);
    }

    @PostMapping("/add/product")
    public ResponseEntity<?> addProduct(@Valid @RequestBody SaveProductRequest product) {
        return new ResponseEntity<>(productService.addProduct(product), HttpStatus.OK);
    }

}
