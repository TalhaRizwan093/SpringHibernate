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

    @PostMapping("/product/add")
    public ResponseEntity<?> addProduct(@Valid @RequestBody SaveProductRequest product) {
        return new ResponseEntity<>(productService.addProduct(product), HttpStatus.OK);
    }

    @DeleteMapping("/product/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer id) {
        return new ResponseEntity<>(productService.deleteProductById(id), HttpStatus.OK);
    }

    @GetMapping("/product/brand/{id}")
    public ResponseEntity<?> getProductByBrand(@PathVariable Integer id) {
        return new ResponseEntity<>(productService.getProductByBrandId(id), HttpStatus.OK);
    }

    @GetMapping("/product/category/{id}")
    public ResponseEntity<?> getProductByCategory(@PathVariable Integer id) {
        return new ResponseEntity<>(productService.getProductByCategoryId(id), HttpStatus.OK);
    }

    @GetMapping("/product/attribute/{id}")
    public ResponseEntity<?> getProductByAttribute(@PathVariable Integer id) {
        return new ResponseEntity<>(productService.getProductByAttributeId(id), HttpStatus.OK);
    }

}
