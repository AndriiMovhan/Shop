package com.example.shop.service;

import com.example.shop.dto.GoodDto;

import java.util.List;

public interface GoodService {

    List<GoodDto> findAll();

    List<GoodDto> findById(String id);

    GoodDto save(GoodDto goodDto);

    GoodDto update(GoodDto id);

    void deleteBy(String id);
}
