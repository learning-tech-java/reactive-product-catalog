package com.example.reactiveproductservice.service;

import com.example.reactiveproductservice.exception.ProductNotFoundException;
import com.example.reactiveproductservice.mapper.ProductMapper;
import com.example.reactiveproductservice.repository.ProductRepository;
import com.example.reactiveproductservice.request.create.CreateProductRequest;
import com.example.reactiveproductservice.request.update.UpdateProductRequest;
import com.example.reactiveproductservice.response.create.CreatedProduct;
import com.example.reactiveproductservice.response.update.UpdatedProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductCommandServiceImpl implements ProductCommandService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public Mono<CreatedProduct> create(CreateProductRequest request) {
        return productRepository.save(productMapper.toEntity(request.getProduct()))
                .map(productMapper::toCreatedProduct);
    }

    @Override
    public Mono<UpdatedProduct> updateByCode(String code, UpdateProductRequest request) {
        return productRepository.findByCode(code)
                .switchIfEmpty(
                        Mono.error(new ProductNotFoundException(code))
                )
                .map(productEntity -> productMapper.merge(request.getProduct(), productEntity))
                .flatMap(productRepository::save)
                .map(productMapper::toUpdatedProduct);

    }

    @Override
    public Mono<Void> deleteByCode(String code) {
        return productRepository.deleteByCode(code);
    }
}
