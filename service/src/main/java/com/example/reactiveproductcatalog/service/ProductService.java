package com.example.reactiveproductcatalog.service;

import com.example.reactiveproductcatalog.common.Product;
import com.example.reactiveproductcatalog.request.CreateProductRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface ProductService {

    Mono<Product> findById(UUID id);

    Flux<Product> findAll();

    Mono<Product> create(CreateProductRequest request);

    Mono<Void> deleteById(UUID id);

    Mono<Product> update(UUID id, CreateProductRequest request);

}
