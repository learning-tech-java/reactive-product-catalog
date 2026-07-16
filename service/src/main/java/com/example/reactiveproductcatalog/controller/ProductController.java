package com.example.reactiveproductcatalog.controller;

import com.example.reactiveproductcatalog.common.Product;
import com.example.reactiveproductcatalog.common.ProductDetails;
import com.example.reactiveproductcatalog.request.CreateProductRequest;
import com.example.reactiveproductcatalog.request.UpdateProductRequest;
import com.example.reactiveproductcatalog.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Product> create(@Valid @RequestBody CreateProductRequest request) {

        return productService.create(request);

    }

    @GetMapping("/{code}")
    public Mono<Product> findByCode(@PathVariable String code) {

        return productService.findByCode(code);

    }

    @GetMapping("/details/{code}")
    public Mono<ProductDetails> findDetailsByCode(@PathVariable String code) {

        return productService.findDetailsByCode(code);

    }

    @GetMapping
    public Flux<Product> findAll() {

        return productService.findAll();

    }

    @PutMapping("/{code}")
    public Mono<Product> update(@PathVariable String code, @Valid @RequestBody UpdateProductRequest request) {

        return productService.updateByCode(code, request);

    }

    @DeleteMapping("/{code}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> delete(@PathVariable String code) {

        return productService.deleteByCode(code);

    }

}
