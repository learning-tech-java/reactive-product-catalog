package com.example.reactiveproductcatalog.repository;

import com.example.reactiveproductcatalog.entity.ProductEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;

public interface ProductRepository extends ReactiveCrudRepository<ProductEntity, UUID> {
}
