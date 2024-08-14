package com.toosterr.backend.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveProductRequest {

    @NotBlank(message = "Product Name is mandatory")
    private String name;
    @NotBlank(message = "Product Description is mandatory")
    private String description;
    @NotBlank(message = "Product detail is mandatory")
    private String detail;
    @Min(value = 1, message = "Product Price must be greater than 1")
    private double price;
    @Min(value = 1, message = "Product quantity must be greater than 1")
    private int quantity;
    private Integer brandId;
    @NotBlank(message = "Product must have a category")
    private Integer categoryId;

}
