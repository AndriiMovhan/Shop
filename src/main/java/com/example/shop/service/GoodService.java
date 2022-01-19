package com.example.shop.service;

import com.example.shop.dto.GoodDto;
import com.example.shop.model.Good;

import java.util.List;

public interface GoodService {

    List<GoodDto> findAll();

    List<GoodDto> findById(String id);

    Good save(Good good);

    Good update(Good id);

    void deleteBy(String id);
}
