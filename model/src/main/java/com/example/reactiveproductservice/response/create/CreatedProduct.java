package com.example.reactiveproductservice.response.create;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record CreatedProduct(

        @NotBlank
        String code,

        @NotBlank
        String name,

        @Positive
        BigDecimal price
) {
}
