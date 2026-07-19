package com.example.reactiveproductservice.service;

import com.example.reactiveproductservice.request.create.CreateProductRequest;
import com.example.reactiveproductservice.request.update.UpdateProductRequest;
import com.example.reactiveproductservice.response.create.CreatedProduct;
import com.example.reactiveproductservice.response.update.UpdatedProduct;
import reactor.core.publisher.Mono;

public interface ProductCommandService {

    /**
     * Создание товара
     *
     * @param request - запрос на создание товара
     * @return - созданный товар
     */
    Mono<CreatedProduct> create(CreateProductRequest request);

    /**
     * Обновление товара по коду
     *
     * @param code - код товара
     * @param request - запрос на обновление товара
     * @return - обновленный товар
     */
    Mono<UpdatedProduct> updateByCode(String code, UpdateProductRequest request);

    /**
     * Удаление товара по коду
     *
     * @param code - код товара
     * @return -
     */
    Mono<Void> deleteByCode(String code);
}
