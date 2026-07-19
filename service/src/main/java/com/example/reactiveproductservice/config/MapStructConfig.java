package com.example.reactiveproductservice.config;

import org.mapstruct.MapperConfig;
import org.mapstruct.MappingConstants;

import java.util.UUID;

@MapperConfig(
        componentModel = MappingConstants.ComponentModel.SPRING,
        imports = UUID.class
)
public class MapStructConfig {
}
