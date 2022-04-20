package com.example.shop.mapper;

import com.example.shop.dto.GoodDto;
import com.example.shop.mapper.impl.GoodMapperImpl;
import com.example.shop.model.Category;
import com.example.shop.model.Good;
import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoodMapperTest {

    @MockBean
    private GoodMapper goodMapper = new GoodMapperImpl();
    @MockBean
    private GoodDto goodDto = new GoodDto();
    @MockBean
    private Good good = new Good();

    @Test
    public void fromEntityToDto(){
        good.setId(1);
        good.setName("name");
        good.setPrice(100);
        goodDto = goodMapper.toDto(good);
        assertEquals(good.getId(), goodDto.getId());
        assertEquals(good.getName(), goodDto.getName());
        assertEquals(good.getPrice(), goodDto.getPrice());
    }

    @Test
    public void fromDtoToEntity(){
        goodDto.setId(1);
        goodDto.setName("name");
        goodDto.setPrice(100);
        good = goodMapper.toEntity(goodDto);
        assertEquals(goodDto.getId(), good.getId());
        assertEquals(goodDto.getName(), good.getName());
        assertEquals(goodDto.getPrice(), good.getPrice());
    }
}
