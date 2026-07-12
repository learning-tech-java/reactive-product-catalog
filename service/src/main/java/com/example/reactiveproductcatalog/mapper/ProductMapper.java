package com.example.reactiveproductcatalog.mapper;

import com.example.reactiveproductcatalog.common.Product;
import com.example.reactiveproductcatalog.config.MapStructConfig;
import com.example.reactiveproductcatalog.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.UUID;

@Mapper(config = MapStructConfig.class)
public interface ProductMapper {

    Product toProduct(ProductEntity productEntity);

    @Mapping(target = "id", expression = "java(UUID.randomUUID())")
    ProductEntity toEntity(Product product);

    @Mapping(target = "id", source = "id")
    ProductEntity toEntity(UUID id, Product product);
}
