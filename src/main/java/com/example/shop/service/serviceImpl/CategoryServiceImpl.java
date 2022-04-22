package com.example.shop.service.serviceImpl;

import com.example.shop.dto.CategoryDto;
import com.example.shop.mapper.CategoryMapper;
import com.example.shop.model.Category;
import com.example.shop.model.Good;
import com.example.shop.repository.CategoryRepository;
import com.example.shop.repository.GoodRepository;
import com.example.shop.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.springframework.util.CollectionUtils.isEmpty;


@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CategoryServiceImpl implements CategoryService {

    private final CategoryMapper categoryMapper;
    private final CategoryRepository categoryRepository;
    private final GoodRepository goodRepository;

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

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public CategoryDto save(CategoryDto categoryDto) {
        Category entity = categoryMapper.toEntity(categoryDto);
        List<Good> goods = goodRepository.findAllById(categoryDto.getGoodIds());
        if (!isEmpty(goods)){
            entity.setGoods(goods);
        }
        return categoryMapper.toDto(categoryRepository.save(entity));
    }

    @Override
    @Transactional
    public CategoryDto update(CategoryDto categoryDto) {
        Category entity = categoryMapper.toEntity(categoryDto);
        List<Good> goods = goodRepository.findAllById(categoryDto.getGoodIds());
        if (!isEmpty(goods)){
            entity.setGoods(goods);
        }
        return categoryMapper.toDto(categoryRepository.save(entity));
    }

    @Override
    @Transactional
    public void deleteBy(String id) {
        categoryRepository.deleteById(Integer.valueOf(id));
    }
}
