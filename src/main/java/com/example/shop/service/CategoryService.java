package com.example.shop.service;

import com.example.shop.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    List<CategoryDto> findAll();

    List<CategoryDto> findById(String id);

    CategoryDto save(CategoryDto categoryDto);

    CategoryDto update(CategoryDto categoryDto);

    void deleteBy(String id);
}
