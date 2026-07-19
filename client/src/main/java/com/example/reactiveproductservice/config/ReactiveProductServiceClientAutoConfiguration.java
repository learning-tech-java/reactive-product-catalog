package com.example.reactiveproductservice.config;

import com.example.reactiveproductservice.service.ProductService;
import com.example.reactiveproductservice.service.ProductServiceImpl;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@AutoConfiguration
@EnableConfigurationProperties(WebClientProperties.class)
public class ReactiveProductServiceClientAutoConfiguration {

    @Bean
    public ProductService ratingService(WebClientProperties webClientProperties, WebClient.Builder builder) {
        return new ProductServiceImpl(webClientProperties, builder);
    }
}
