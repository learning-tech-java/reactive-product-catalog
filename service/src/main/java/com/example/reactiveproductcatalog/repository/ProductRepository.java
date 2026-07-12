package com.example.reactiveproductcatalog.repository;

import com.example.reactiveproductcatalog.entity.ProductEntity;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ProductRepository {

    private final Map<UUID, ProductEntity> storage = new ConcurrentHashMap<>();

    public Mono<ProductEntity> findById(UUID id) {

        ProductEntity product = storage.get(id);

        return Mono.justOrEmpty(product);

    }

    public Flux<ProductEntity> findAll() {

        return Flux.fromIterable(
                storage.values()
        );

    }

    public Mono<ProductEntity> save(ProductEntity product) {

        storage.put(
                product.getId(),
                product
        );

        return Mono.just(product);

    }

    public Mono<Void> deleteById(UUID id) {

        storage.remove(id);

        return Mono.empty();

    }
}
