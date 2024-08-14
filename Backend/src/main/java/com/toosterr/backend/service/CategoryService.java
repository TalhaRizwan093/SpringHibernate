package com.toosterr.backend.service;

import com.toosterr.backend.dto.AddCategoryRequest;
import com.toosterr.backend.entity.Category;
import com.toosterr.backend.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category add(AddCategoryRequest category) {
        try {
            Category categoryEntity = Category.builder()
                    .categoryName(category.getName())
                    .description(category.getDescription())
                    .build();
            return categoryRepository.save(categoryEntity);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
