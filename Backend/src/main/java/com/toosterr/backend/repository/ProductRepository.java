package com.toosterr.backend.repository;

import com.toosterr.backend.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository  extends PagingAndSortingRepository<Product, Integer>, JpaRepository<Product, Integer> {

    List<Product> findAll();

    @Query("SELECT prod FROM Product prod")
    Page<Product> GetAll(Pageable pageable);

    boolean existsBySku(String sku);

}
