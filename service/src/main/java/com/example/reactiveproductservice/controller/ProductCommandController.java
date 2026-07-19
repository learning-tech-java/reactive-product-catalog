package com.example.reactiveproductservice.controller;

import com.example.reactiveproductservice.request.create.CreateProductRequest;
import com.example.reactiveproductservice.request.update.UpdateProductRequest;
import com.example.reactiveproductservice.response.create.CreatedProduct;
import com.example.reactiveproductservice.response.update.UpdatedProduct;
import com.example.reactiveproductservice.service.ProductCommandService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductCommandController {

    private final ProductCommandService productCommandService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<CreatedProduct> create(@Valid @RequestBody CreateProductRequest request) {
        return productCommandService.create(request);
    }

    @PutMapping("/{code}")
    public Mono<UpdatedProduct> update(@PathVariable String code, @Valid @RequestBody UpdateProductRequest request) {
        return productCommandService.updateByCode(code, request);
    }

    @DeleteMapping("/{code}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> delete(@PathVariable String code) {
        return productCommandService.deleteByCode(code);
    }
}
