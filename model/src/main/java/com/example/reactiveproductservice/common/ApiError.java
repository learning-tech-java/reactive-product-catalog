package com.example.reactiveproductservice.common;

import jakarta.validation.constraints.NotBlank;

public record ApiError(

        @NotBlank
        String message
) {
}
