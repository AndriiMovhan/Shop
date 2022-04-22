package com.example.shop.service.serviceImpl;

import com.example.shop.dto.GoodDto;
import com.example.shop.mapper.GoodMapper;
import com.example.shop.model.Category;
import com.example.shop.model.Good;
import com.example.shop.repository.CategoryRepository;
import com.example.shop.repository.GoodRepository;
import com.example.shop.service.GoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.springframework.util.CollectionUtils.isEmpty;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GoodServiceImpl implements GoodService {

    private final GoodMapper goodMapper;
    private final GoodRepository goodRepository;
    private final CategoryRepository categoryRepository;


    @Override
    @Transactional(readOnly = true)
    public List<GoodDto> findAll() {
        return goodRepository.findAll().stream().map(goodMapper::toDto).collect(toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<GoodDto> findById(String id) {
        return goodRepository.findById(Integer.valueOf(id)).stream().map(goodMapper::toDto).collect(toList());
    }

    @Override
    @Transactional
    public GoodDto save(GoodDto goodDto) {
        Good entity = goodMapper.toEntity(goodDto);
        List<Category> categories = categoryRepository.findAllById(goodDto.getCategoryIds());
        if (!isEmpty(categories)){
            entity.setCategories(categories);
        }
        return goodMapper.toDto(goodRepository.save(entity));
    }

    @Override
    @Transactional
    public GoodDto update(GoodDto goodDto) {
        Good entity = goodMapper.toEntity(goodDto);
        List<Category> categories = categoryRepository.findAllById(goodDto.getCategoryIds());
        if (!isEmpty(categories)){
            entity.setCategories(categories);
        }
        return goodMapper.toDto(goodRepository.save(entity));
    }

    @Override
    @Transactional
    public void deleteBy(String id) {
        goodRepository.deleteById(Integer.valueOf(id));
    }
}
