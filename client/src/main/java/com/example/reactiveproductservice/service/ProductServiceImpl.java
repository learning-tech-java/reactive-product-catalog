package com.example.reactiveproductservice.service;

import com.example.reactiveproductservice.config.WebClientProperties;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class ProductServiceImpl implements ProductService {

    public static final String EXISTS_BY_CODE_URI = "/products/{productCode}/exists";
    public static final Boolean FALLBACK_VALUE = Boolean.FALSE;

    private final WebClientProperties webClientProperties;
    private final WebClient webClient;

    public ProductServiceImpl(WebClientProperties webClientProperties, WebClient.Builder builder) {
        this.webClientProperties = webClientProperties;
        this.webClient = builder
                .baseUrl(webClientProperties.getBaseUrl())
                .build();
    }

    @Override
    public Mono<Boolean> existsByCode(String code) {
        return webClient
                .get()
                .uri(EXISTS_BY_CODE_URI, code)
                .retrieve()
                .bodyToMono(Boolean.class)
                .timeout(Duration.ofMillis(webClientProperties.getTimeout()))
                .retry(webClientProperties.getNumRetries())
                .onErrorReturn(FALLBACK_VALUE);
    }
}
