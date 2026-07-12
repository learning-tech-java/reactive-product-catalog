package com.example.reactiveproductcatalog.exception;

import java.util.UUID;

public class ProductNotFoundException extends Exception {

    public ProductNotFoundException(UUID id) {

        super(String.format("Product not found: %s", id));

    }
}
