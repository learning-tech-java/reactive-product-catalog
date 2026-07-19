package com.example.reactiveproductservice.service;

import reactor.core.publisher.Mono;

public interface ProductService {

    /**
     * Проверка существования товара по коду
     *
     * @param code - код товара
     * @return - true если существует, false если нет
     */
    Mono<Boolean> existsByCode(String code);
}
