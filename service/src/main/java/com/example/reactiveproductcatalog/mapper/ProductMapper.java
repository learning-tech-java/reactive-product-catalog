package com.example.reactiveproductcatalog.mapper;

import com.example.reactiveproductcatalog.common.Product;
import com.example.reactiveproductcatalog.entity.ProductEntity;
import org.mapstruct.Mapper;

@Mapper
public interface ProductMapper {

    Product toProduct(ProductEntity productEntity);

    ProductEntity toEntity(Product product);

}
