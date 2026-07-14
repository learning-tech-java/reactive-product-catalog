package com.example.reactiveproductcatalog.exception;

public class ProductNotFoundException extends Exception {

    public ProductNotFoundException(String code) {

        super(String.format("Product not found: %s", code));

    }

}
