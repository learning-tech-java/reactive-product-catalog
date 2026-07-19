package com.example.reactiveproductservice.response.find;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record FoundProduct(

        @NotBlank
        String code,

        @NotBlank
        String name,

        @Positive
        BigDecimal price
) {
}
