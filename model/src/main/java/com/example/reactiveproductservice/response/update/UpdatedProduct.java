package com.example.reactiveproductservice.response.update;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record UpdatedProduct(

        @NotBlank
        String code,

        @NotBlank
        String name,

        @Positive
        BigDecimal price
) {
}
