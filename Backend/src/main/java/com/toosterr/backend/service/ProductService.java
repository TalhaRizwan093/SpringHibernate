package com.toosterr.backend.service;

import com.toosterr.backend.dto.SaveProductRequest;
import com.toosterr.backend.entity.Product;
import com.toosterr.backend.repository.ProductRepository;
import com.toosterr.backend.util.Helper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final Helper helper;

    public ProductService(ProductRepository productRepository, Helper helper) {
        this.productRepository = productRepository;
        this.helper = helper;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product addProduct(SaveProductRequest product) {
        Product prod = Product.builder()
                .name(product.getName())
                .sku(generateSKU(product))
                .detail(product.getDetail())
                .description(product.getDescription())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .build();
        return productRepository.save(prod);
    }

    public String generateSKU(SaveProductRequest product) {
//        String categoryCode = getCodeFromString(product.getBrand().getCategory().getName(), 2);
//        String brandCode = getCodeFromString(product.getBrand().getName(), 2);
        String productNameCode = helper.getCodeFromString(product.getName(), 3);

        int uniqueNumber = new Random().nextInt(9000) + 1000;

//        String sku = categoryCode + "-" + brandCode + "-" + productNameCode + "-" + uniqueNumber;
        String sku = productNameCode + "-" + uniqueNumber;

        while (productRepository.existsBySku(sku)) {
            uniqueNumber = new Random().nextInt(9000) + 1000;
            sku = productNameCode + "-" + uniqueNumber;
        }

        return sku;
    }
}
