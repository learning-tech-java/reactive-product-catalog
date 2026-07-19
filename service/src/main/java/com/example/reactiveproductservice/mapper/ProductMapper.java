package com.example.reactiveproductservice.mapper;

import com.example.reactiveproductservice.request.create.CreateProduct;
import com.example.reactiveproductservice.request.update.UpdateProduct;
import com.example.reactiveproductservice.response.create.CreatedProduct;
import com.example.reactiveproductservice.response.find.FoundProduct;
import com.example.reactiveproductservice.response.find.FoundProductDetails;
import com.example.reactiveproductservice.config.MapStructConfig;
import com.example.reactiveproductservice.entity.ProductEntity;
import com.example.reactiveproductservice.response.update.UpdatedProduct;
import com.example.reactiveratingservice.common.AvgRating;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(config = MapStructConfig.class)
public interface ProductMapper {

    CreatedProduct toCreatedProduct(ProductEntity productEntity);

    UpdatedProduct toUpdatedProduct(ProductEntity productEntity);

    FoundProduct toFoundProduct(ProductEntity productEntity);

    @Mapping(target = "rating", source = "rating.value")
    FoundProductDetails toFoundProductDetails(FoundProduct product, AvgRating rating);

    @Mapping(target = "id", ignore = true)
    ProductEntity toEntity(CreateProduct product);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "code", ignore = true)
    ProductEntity merge(UpdateProduct product, @MappingTarget ProductEntity productEntity);
}
