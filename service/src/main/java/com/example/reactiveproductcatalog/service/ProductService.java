package com.example.reactiveproductcatalog.service;

import com.example.reactiveproductcatalog.common.Product;
import com.example.reactiveproductcatalog.request.CreateProductRequest;
import com.example.reactiveproductcatalog.request.UpdateProductRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {

    Mono<Product> create(CreateProductRequest request);

    Mono<Product> findByCode(String code);

    Flux<Product> findAll();

    Mono<Product> updateByCode(String code, UpdateProductRequest request);

    Mono<Void> deleteByCode(String code);

}
