package com.example.reactiveproductservice.request.update;

import jakarta.validation.Valid;
import lombok.Getter;

@Getter
public class UpdateProductRequest {

    @Valid
    private UpdateProduct product;
}
