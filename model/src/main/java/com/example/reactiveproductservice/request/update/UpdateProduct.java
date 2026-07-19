package com.example.reactiveproductservice.request.update;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record UpdateProduct(

        @NotBlank
        String name,

        @Positive
        BigDecimal price
) {
}
