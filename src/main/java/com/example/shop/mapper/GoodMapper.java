package com.example.shop.mapper;

import com.example.shop.dto.GoodDto;
import com.example.shop.model.Category;
import com.example.shop.model.Good;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Collection;
import java.util.Set;

import static java.util.stream.Collectors.toSet;
import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = IGNORE,
        implementationPackage = "com.example.shop.mapper.impl",
        uses = CategoryMapper.class
)
public abstract class GoodMapper {

    @Mapping(source = "good.categories", target = "categoryIds", qualifiedByName = "categoriesToIds")
    public abstract GoodDto toDto(Good good);

    @Mapping(target = "categories", ignore = true)
    public abstract Good toEntity(GoodDto goodDto);

    @Named("categoriesToIds")
    public Set<Integer> categoriesToIds(Collection<Category> categories) {
        return categories.stream().map(Category::getId).collect(toSet());
    }
}
