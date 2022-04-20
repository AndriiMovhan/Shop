package com.example.shop.mapper;

import com.example.shop.dto.GoodDto;
import com.example.shop.model.Good;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = IGNORE,
        implementationPackage = "com.example.shop.mapper.impl"
)
public abstract class GoodMapper {

    @Mapping(source = "category.id", target = "categoryId")
    public abstract GoodDto toDto(Good good);

    @Mapping(source = "categoryId", target = "category.id")
    public abstract Good toEntity(GoodDto goodDto);


}
