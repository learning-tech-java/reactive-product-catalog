package com.example.reactiveproductservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class ReactiveProductCatalogApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactiveProductCatalogApplication.class, args);
    }
}
