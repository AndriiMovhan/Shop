package com.example.shop.service;

import com.example.shop.dto.GoodDto;
import com.example.shop.mapper.GoodMapper;
import com.example.shop.repository.GoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GoodServiceImpl implements GoodService {

    private final GoodMapper goodMapper;
    private final GoodRepository goodRepository;

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
        return goodMapper.toDto(goodRepository.save(goodMapper.toEntity(goodDto)));
    }

    @Override
    @Transactional
    public GoodDto update(GoodDto id) {
       return goodMapper.toDto(goodRepository.save(goodMapper.toEntity(id)));
    }

    @Override
    @Transactional
    public void deleteBy(String id) {
        goodRepository.deleteById(Integer.valueOf(id));
    }
}
