package com.example.shop.service.serviceImpl;

import com.example.shop.dto.CategoryDto;
import com.example.shop.mapper.CategoryMapper;
import com.example.shop.repository.CategoryRepository;
import com.example.shop.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CategoryServiceImpl implements CategoryService {

    private final CategoryMapper categoryMapper;
    private final CategoryRepository categoryRepository;

    @Override
    @Transactional(readOnly = true)
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll().stream().map(categoryMapper::toDto).collect(toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoryDto> findById(String id) {
        return categoryRepository.findById(Integer.valueOf(id)).stream().map(categoryMapper::toDto).collect(toList());
    }

    @Override
    @Transactional
    public CategoryDto save(CategoryDto categoryDto) {
        return categoryMapper.toDto(categoryRepository.save(categoryMapper.toEntity(categoryDto)));
    }

    @Override
    @Transactional
    public CategoryDto update(CategoryDto categoryDto) {
        return categoryMapper.toDto(categoryRepository.save(categoryMapper.toEntity(categoryDto)));
    }

    @Override
    @Transactional
    public void deleteBy(String id) {
        categoryRepository.deleteById(Integer.valueOf(id));
    }
}
