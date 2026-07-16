package com.example.reactiveproductcatalog.service;

import com.example.reactiveproductcatalog.common.Product;
import com.example.reactiveproductcatalog.common.ProductDetails;
import com.example.reactiveproductcatalog.exception.ProductNotFoundException;
import com.example.reactiveproductcatalog.mapper.ProductMapper;
import com.example.reactiveproductcatalog.repository.ProductRepository;
import com.example.reactiveproductcatalog.request.CreateProductRequest;
import com.example.reactiveproductcatalog.request.UpdateProductRequest;
import com.example.reactiveratingservice.common.Rating;
import com.example.reactiveratingservice.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final RatingService ratingService;

    @Override
    public Mono<Product> create(CreateProductRequest request) {

        return productRepository.save(productMapper.toEntity(request.getProduct()))
                .map(productMapper::toProduct);

    }

    @Override
    public Mono<Product> findByCode(String code) {

        return productRepository.findByCode(code)
                .switchIfEmpty(
                        Mono.error(new ProductNotFoundException(code))
                )
                .map(productMapper::toProduct);

    }

    @Override
    public Mono<ProductDetails> findDetailsByCode(String code) {

        Mono<Product> product = findByCode(code);
        Mono<Rating> rating = ratingService.getRatingByCode(code);

        return Mono.zip(
                        product,
                        rating)
                .map(tuple -> productMapper.toProductDetails(tuple.getT1(), tuple.getT2().value()));

    }

    @Override
    public Flux<Product> findAll() {

        return productRepository.findAll()
                .map(productMapper::toProduct);

    }

    @Override
    public Mono<Product> updateByCode(String code, UpdateProductRequest request) {

        return productRepository.findByCode(code)
                .switchIfEmpty(
                        Mono.error(new ProductNotFoundException(code))
                )
                .map(productEntity -> productMapper.merge(request.getProduct(), productEntity))
                .flatMap(productRepository::save)
                .map(productMapper::toProduct);

    }

    @Override
    public Mono<Void> deleteByCode(String code) {

        return productRepository.deleteByCode(code);

    }

}
