package com.toosterr.backend.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveProductRequest {

    @NotBlank(message = "Product Name is mandatory")
    public String name;
    @NotBlank(message = "Product Description is mandatory")
    public String description;
    @NotBlank(message = "Product detail is mandatory")
    public String detail;
    @Min(value = 1, message = "Product Price must be greater than 1")
    public double price;
    @Min(value = 1, message = "Product quantity must be greater than 1")
    public int quantity;

}
