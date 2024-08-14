package com.toosterr.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCategoryRequest {

    @NotBlank(message = "Category name should not be blank")
    @NotNull(message = "Category name should not be null")
    private String name;
    @NotBlank(message = "Category description should not be blank")
    @NotNull(message = "Category description should not be null")
    private String description;

}
