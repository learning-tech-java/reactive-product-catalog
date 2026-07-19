package com.example.reactiveproductservice.response.find;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record FoundProductDetails(

        @NotBlank
        String code,

        @NotBlank
        String name,

        @Positive
        BigDecimal price,

        @NotNull
        @DecimalMin("0.00")
        @DecimalMax("5.00")
        @Digits(integer = 1, fraction = 2)
        BigDecimal rating
) {
}
