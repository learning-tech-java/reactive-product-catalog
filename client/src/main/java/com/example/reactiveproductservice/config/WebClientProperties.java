package com.example.reactiveproductservice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "client.reactive-product-service")
public class WebClientProperties {

    /**
     * Базовый URL сервиса товаров
     */
    private String baseUrl = "http://localhost:8080";

    /**
     * Максимальное время ожидания ответа от сервиса в миллисекундах
     */
    private long timeout = 60000;

    /**
     * Количество повторных попыток выполнения запроса при возникновении ошибки
     */
    private long numRetries = 2;
}
