package com.example.shop.service;

import com.example.shop.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    List<CategoryDto> findAll();

    List<CategoryDto> findById(String id);

    /**
     * Method is used to create new Category
     *
     * @param categoryDto categoryDto to create
     *
     * @return {@link CategoryDto} created category
     */
    CategoryDto save(CategoryDto categoryDto);

    CategoryDto update(CategoryDto categoryDto);

    void deleteBy(String id);
}
