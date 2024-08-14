package com.toosterr.backend.controller;

import com.toosterr.backend.dto.AddCategoryRequest;
import com.toosterr.backend.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<?> getAllCategories() {
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/category/add")
    public ResponseEntity<?> addCategory(@RequestBody AddCategoryRequest category) {
        return new ResponseEntity<>(categoryService.add(category), HttpStatus.OK);
    }

}
