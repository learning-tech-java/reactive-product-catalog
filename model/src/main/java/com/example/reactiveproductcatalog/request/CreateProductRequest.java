package com.example.reactiveproductcatalog.request;

import com.example.reactiveproductcatalog.common.Product;
import jakarta.validation.Valid;
import lombok.Getter;

@Getter
public class CreateProductRequest {

    @Valid
    private Product product;

}
