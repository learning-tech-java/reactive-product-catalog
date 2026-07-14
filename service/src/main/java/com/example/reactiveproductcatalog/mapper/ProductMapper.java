package com.example.reactiveproductcatalog.mapper;

import com.example.reactiveproductcatalog.common.Product;
import com.example.reactiveproductcatalog.config.MapStructConfig;
import com.example.reactiveproductcatalog.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(config = MapStructConfig.class)
public interface ProductMapper {

    Product toProduct(ProductEntity productEntity);

    ProductEntity toEntity(Product product);

    ProductEntity merge(Product product, @MappingTarget ProductEntity productEntity);

}
