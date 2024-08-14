package com.toosterr.backend.service;

import com.toosterr.backend.dto.SaveProductRequest;
import com.toosterr.backend.entity.Product;
import com.toosterr.backend.entity.ProductCategory;
import com.toosterr.backend.exception.brandException.BrandNotFoundException;
import com.toosterr.backend.repository.BrandRepository;
import com.toosterr.backend.repository.ProductRepository;
import com.toosterr.backend.util.Helper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final BrandRepository brandRepository;
    private final Helper helper;

    public ProductService(ProductRepository productRepository, BrandRepository brandRepository, Helper helper) {
        this.productRepository = productRepository;
        this.brandRepository = brandRepository;
        this.helper = helper;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product addProduct(SaveProductRequest product) {
        try {

            ProductCategory productCategory = new ProductCategory();

            Product prod = Product.builder()
                    .name(product.getName())
                    .sku(generateSKU(product))
                    .detail(product.getDetail())
                    .description(product.getDescription())
                    .price(product.getPrice())
                    .quantity(product.getQuantity())
                    .brand(brandRepository.getBrandById(product.getBrandId())
                            .orElseThrow(() -> new BrandNotFoundException(String.format("Brand with id {0} not found",product.getBrandId()))))
                    .build();
            return productRepository.save(prod);
        } catch (BrandNotFoundException e) {
            throw new RuntimeException(e);
        }
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
