package com.toosterr.backend.repository;

import com.toosterr.backend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository  extends JpaRepository<Product, Integer> {

    List<Product> findAll();
    boolean existsBySku(String sku);

}
