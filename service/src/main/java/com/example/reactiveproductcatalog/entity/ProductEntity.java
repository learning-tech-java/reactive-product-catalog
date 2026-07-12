package com.example.reactiveproductcatalog.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class ProductEntity {

    private UUID id;

    private String name;

    private BigDecimal price;
}
