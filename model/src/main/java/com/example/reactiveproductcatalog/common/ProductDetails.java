package com.example.reactiveproductcatalog.common;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductDetails(

        @NotBlank
        String code,

        @NotBlank
        String name,

        @Positive
        BigDecimal price,

        Double rating

) {
}
