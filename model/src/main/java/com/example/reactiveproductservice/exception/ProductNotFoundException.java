package com.example.reactiveproductservice.exception;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(String code) {
        super(String.format("Product not found: %s", code));
    }
}
