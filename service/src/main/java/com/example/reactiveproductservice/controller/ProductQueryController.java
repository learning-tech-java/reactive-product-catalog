package com.example.reactiveproductservice.controller;

import com.example.reactiveproductservice.response.find.FoundProduct;
import com.example.reactiveproductservice.response.find.FoundProductDetails;
import com.example.reactiveproductservice.service.ProductQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductQueryController {

    private final ProductQueryService productQueryService;

    @GetMapping
    public Flux<FoundProduct> findAll() {
        return productQueryService.findAll();
    }

    @GetMapping("/{code}")
    public Mono<FoundProduct> findByCode(@PathVariable String code) {
        return productQueryService.findByCode(code);
    }

    @GetMapping("/{code}/details")
    public Mono<FoundProductDetails> findDetailsByCode(@PathVariable String code) {
        return productQueryService.findDetailsByCode(code);
    }

    @GetMapping("/{code}/exists")
    public Mono<Boolean> existsByCode(@PathVariable String code) {
        return productQueryService.existsByCode(code);
    }
}
