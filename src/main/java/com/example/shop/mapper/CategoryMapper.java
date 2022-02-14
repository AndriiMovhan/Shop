package com.example.shop.mapper;

import com.example.shop.dto.CategoryDto;
import com.example.shop.model.Category;
import org.mapstruct.Mapper;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = IGNORE,
        implementationPackage = "com.example.shop.mapper.impl"
)
public abstract class CategoryMapper {

    public abstract CategoryDto toDto(Category category);

    public abstract Category toEntity(CategoryDto categoryDto);


}
