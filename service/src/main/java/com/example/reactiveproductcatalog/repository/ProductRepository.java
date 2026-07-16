package com.example.reactiveproductcatalog.repository;

import com.example.reactiveproductcatalog.entity.ProductEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface ProductRepository extends ReactiveCrudRepository<ProductEntity, UUID> {

    /**
     * Поиск товара по коду
     *
     * @param code - код товара
     * @return - товар
     */
    Mono<ProductEntity> findByCode(String code);

    /**
     * Удаление товара по коду
     *
     * @param code - код товара
     * @return -
     */
    Mono<Void> deleteByCode(String code);

}
