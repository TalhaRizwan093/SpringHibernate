package com.toosterr.backend.repository;

import com.toosterr.backend.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

        List<Category> findAll();

        Optional<Category> getCategoryById(Integer categoryId);
}