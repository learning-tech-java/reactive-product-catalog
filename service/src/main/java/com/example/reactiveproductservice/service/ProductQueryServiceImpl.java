package com.example.reactiveproductservice.service;

import com.example.reactiveproductservice.response.find.FoundProduct;
import com.example.reactiveproductservice.response.find.FoundProductDetails;
import com.example.reactiveproductservice.exception.ProductNotFoundException;
import com.example.reactiveproductservice.mapper.ProductMapper;
import com.example.reactiveproductservice.repository.ProductRepository;
import com.example.reactiveratingservice.common.AvgRating;
import com.example.reactiveratingservice.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductQueryServiceImpl implements ProductQueryService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final RatingService ratingService;

    @Override
    public Flux<FoundProduct> findAll() {
        return productRepository.findAll()
                .map(productMapper::toFoundProduct);
    }

    @Override
    public Mono<FoundProduct> findByCode(String code) {
        return productRepository.findByCode(code)
                .switchIfEmpty(
                        Mono.error(new ProductNotFoundException(code))
                )
                .map(productMapper::toFoundProduct);
    }

    @Override
    public Mono<FoundProductDetails> findDetailsByCode(String code) {
        Mono<FoundProduct> product = findByCode(code);
        Mono<AvgRating> rating = ratingService.getAvgRatingByProductCode(code);

        return Mono.zip(product, rating)
                .map(tuple -> productMapper.toFoundProductDetails(tuple.getT1(), tuple.getT2()));
    }

    @Override
    public Mono<Boolean> existsByCode(String code) {
        return productRepository.existsByCode(code);
    }
}
