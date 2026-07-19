package com.example.reactiveproductservice.request.create;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record CreateProduct(

        @NotBlank
        String code,

        @NotBlank
        String name,

        @Positive
        BigDecimal price
) {
}
