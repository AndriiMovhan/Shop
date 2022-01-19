package com.example.shop.mapper;

import com.example.shop.dto.GoodDto;
import com.example.shop.model.Good;
import org.mapstruct.Mapper;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = IGNORE,
        implementationPackage = "com.example.shop.mapper.impl"
)
public abstract class GoodMapper {

    public abstract GoodDto toDto(Good car);

    public abstract Good toEntity(GoodDto car);


}
