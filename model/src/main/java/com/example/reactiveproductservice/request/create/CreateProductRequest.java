package com.example.reactiveproductservice.request.create;

import jakarta.validation.Valid;
import lombok.Getter;

@Getter
public class CreateProductRequest {

    @Valid
    private CreateProduct product;
}
