package com.example.shop.mapper;

import com.example.shop.dto.CategoryDto;
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
        uses = GoodMapper.class
)
public abstract class CategoryMapper {

    @Mapping(source = "category.goods", target = "goodIds", qualifiedByName = "goodsToIds")
    public abstract CategoryDto toDto(Category category);

    @Mapping(target = "goods", ignore = true)
    public abstract Category toEntity(CategoryDto categoryDto);

    @Named("goodsToIds")
    public Set<Integer> goodsToIds(Collection<Good> goods) {
        return goods.stream().map(Good::getId).collect(toSet());
    }
}
