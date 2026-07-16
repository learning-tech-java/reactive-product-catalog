package com.example.reactiveproductcatalog.service;

import com.example.reactiveproductcatalog.common.Product;
import com.example.reactiveproductcatalog.common.ProductDetails;
import com.example.reactiveproductcatalog.request.CreateProductRequest;
import com.example.reactiveproductcatalog.request.UpdateProductRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {

    /**
     * Создание товара
     *
     * @param request - запрос на создание товара
     * @return - созданный товар
     */
    Mono<Product> create(CreateProductRequest request);

    /**
     * Поиск товара по коду
     *
     * @param code - код товара
     * @return - найденный товар
     */
    Mono<Product> findByCode(String code);

    /**
     * Поиск деталей о товаре по коду
     *
     * @param code - код товара
     * @return - детали товара
     */
    Mono<ProductDetails> findDetailsByCode(String code);

    /**
     * Поиск всех товаров
     *
     * @return - найденные товары
     */
    Flux<Product> findAll();

    /**
     * Обновление товара по коду
     *
     * @param code - код товара
     * @param request - запрос на обновление товара
     * @return - обновленный товар
     */
    Mono<Product> updateByCode(String code, UpdateProductRequest request);

    /**
     * Удаление товара по коду
     *
     * @param code - код товара
     * @return -
     */
    Mono<Void> deleteByCode(String code);

}
