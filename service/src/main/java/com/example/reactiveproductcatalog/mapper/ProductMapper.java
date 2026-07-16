package com.example.reactiveproductcatalog.mapper;

import com.example.reactiveproductcatalog.common.Product;
import com.example.reactiveproductcatalog.common.ProductDetails;
import com.example.reactiveproductcatalog.config.MapStructConfig;
import com.example.reactiveproductcatalog.entity.ProductEntity;
import com.example.reactiveratingservice.common.Rating;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(config = MapStructConfig.class)
public interface ProductMapper {

    Product toProduct(ProductEntity productEntity);

    ProductEntity toEntity(Product product);

    @Mapping(target = "id", ignore = true)
    ProductEntity merge(Product product, @MappingTarget ProductEntity productEntity);

    ProductDetails toProductDetails(Product product, Double rating);

}
