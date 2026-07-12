package com.example.reactiveproductcatalog.service;

import com.example.reactiveproductcatalog.common.Product;
import com.example.reactiveproductcatalog.exception.ProductNotFoundException;
import com.example.reactiveproductcatalog.mapper.ProductMapper;
import com.example.reactiveproductcatalog.repository.ProductRepository;
import com.example.reactiveproductcatalog.request.CreateProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public Mono<Product> findById(UUID id) {

        return productRepository.findById(id)
                .switchIfEmpty(
                        Mono.error(new ProductNotFoundException())
                )
                .map(productMapper::toProduct);

    }

    @Override
    public Flux<Product> findAll() {

        return productRepository.findAll()
                .map(productMapper::toProduct);

    }

    @Override
    public Mono<Product> create(CreateProductRequest request) {

        return productRepository.save(productMapper.toEntity(request.getProduct()))
                .map(productMapper::toProduct);

    }

    @Override
    public Mono<Void> deleteById(UUID id) {

        return productRepository.deleteById(id);

    }

}
