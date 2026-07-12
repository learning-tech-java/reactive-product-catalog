package com.example.reactiveproductcatalog.controller;

import com.example.reactiveproductcatalog.common.Product;
import com.example.reactiveproductcatalog.request.CreateProductRequest;
import com.example.reactiveproductcatalog.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public Flux<Product> findAll() {

        return productService.findAll();

    }

    @GetMapping("/{id}")
    public Mono<Product> findById(
            @PathVariable UUID id
    ) {

        return productService.findById(id);

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Product> create(
            @Valid
            @RequestBody
            CreateProductRequest request
    ) {

        return productService.create(request);

    }

    @PutMapping("/{id}")
    public Mono<Product> update(
            @PathVariable UUID id,
            @Valid
            @RequestBody
            CreateProductRequest request
    ) {

        return productService.update(id, request);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> delete(
            @PathVariable UUID id
    ) {

        return productService.deleteById(id);

    }
}
