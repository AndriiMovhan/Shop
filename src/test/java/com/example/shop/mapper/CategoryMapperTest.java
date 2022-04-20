//package com.example.shop.mapper;
//
//import com.example.shop.dto.CategoryDto;
//import com.example.shop.dto.GoodDto;
//import com.example.shop.mapper.impl.CategoryMapperImpl;
//import com.example.shop.mapper.impl.GoodMapperImpl;
//import com.example.shop.model.Category;
//import com.example.shop.model.Good;
//import org.junit.Test;
//import org.mockito.Mock;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import java.util.ArrayList;
//
//import static org.junit.Assert.*;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class CategoryMapperTest {
//
//    @MockBean
//    private CategoryMapper categoryMapper = new CategoryMapperImpl();
//    @MockBean
//    private CategoryDto categoryDto = new CategoryDto();
//    @MockBean
//    private Category category = new Category();
//
//    @Test
//    public void fromEntityToDto(){
//        category.setId(1);
//        category.setName("name");
//        category.setGoods(new ArrayList<>());
//        categoryDto = categoryMapper.toDto(category);
//        assertEquals(category.getId(), categoryDto.getId());
//        assertEquals(category.getName(), categoryDto.getName());
//        assertEquals(category.getGoods(), categoryDto.getGoods());
//    }
//
//    @Test
//    public void fromDtoToEntity(){
//        categoryDto.setId(1);
//        categoryDto.setName("name");
//        categoryDto.setGoods(new ArrayList<>());
//        category = categoryMapper.toEntity(categoryDto);
//        assertEquals(category.getId(), categoryDto.getId());
//        assertEquals(category.getName(), categoryDto.getName());
//        assertEquals(category.getGoods(), categoryDto.getGoods());
//    }
//}
