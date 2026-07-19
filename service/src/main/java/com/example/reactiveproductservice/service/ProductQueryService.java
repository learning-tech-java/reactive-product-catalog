package com.example.reactiveproductservice.service;

import com.example.reactiveproductservice.response.find.FoundProduct;
import com.example.reactiveproductservice.response.find.FoundProductDetails;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductQueryService {

    /**
     * Поиск всех товаров
     *
     * @return - найденные товары
     */
    Flux<FoundProduct> findAll();

    /**
     * Поиск товара по коду
     *
     * @param code - код товара
     * @return - найденный товар
     */
    Mono<FoundProduct> findByCode(String code);

    /**
     * Поиск деталей о товаре по коду
     *
     * @param code - код товара
     * @return - детали товара
     */
    Mono<FoundProductDetails> findDetailsByCode(String code);

    /**
     * Проверка существования товара по коду
     *
     * @param code - код товара
     * @return - true если существует, false если нет
     */
    Mono<Boolean> existsByCode(String code);
}
