//package com.example.shop.service;
//
//import com.example.shop.dto.CategoryDto;
//import com.example.shop.mapper.CategoryMapper;
//import com.example.shop.mapper.impl.CategoryMapperImpl;
//import com.example.shop.model.Category;
//import com.example.shop.model.Category.CategoryBuilder;
//import com.example.shop.model.Good;
//import com.example.shop.repository.CategoryRepository;
//import com.example.shop.service.serviceImpl.CategoryServiceImpl;
//import org.hibernate.LazyInitializationException;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static java.util.stream.Collectors.toList;
//import static org.junit.Assert.*;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
//public class CategoryServiceImplTest {
//
//    @MockBean
//    private CategoryRepository categoryRepository;
//
//    @MockBean
//    private CategoryMapper categoryMapper;
//
//    @Autowired
//    private CategoryService categoryService;
//
//    @Test//(expected = LazyInitializationException.class)
//    public void findAll() {
//        Category category = new Category(1, "name", null);
//        assertEquals(category, categoryRepository.findById(1));
//    }
//
//    @Test
//    public void findById() {
//        Category category = new Category(1, "name", new ArrayList<Good>());
//
//        categoryRepository.save(category);
//        List<CategoryDto> category1 = categoryRepository.findAll().stream().map(categoryMapper::toDto).collect(toList());
//
//        assertEquals(category.getId(), categoryMapper.toEntity(category1.get(0)).getId());
//        assertEquals(category.getName(), categoryMapper.toEntity(category1.get(0)).getName());
//        assertEquals(category.getGoods(), categoryMapper.toEntity(category1.get(0)).getGoods());
//    }
//
//    @Test
//    public void save() {
//        Category category = new Category(1, "name", new ArrayList<Good>());
//
//        categoryRepository.save(category);
//        List<CategoryDto> category1 = categoryRepository.findAll().stream().map(categoryMapper::toDto).collect(toList());
//
//        assertNotNull(category1.get(0));
//    }
//
//    @Test
//    public void update() {
//        Category category = new Category(1, "name", new ArrayList<Good>());
//
//        categoryRepository.save(category);
//        List<CategoryDto> category1 = categoryRepository.findAll().stream().map(categoryMapper::toDto).collect(toList());
//        category = new Category(1, "null", new ArrayList<>());
//        categoryRepository.save(category);
//        List<CategoryDto> category2 = categoryRepository.findAll().stream().map(categoryMapper::toDto).collect(toList());
//
//        assertNotEquals(categoryMapper.toEntity(category1.get(0)).getId(), categoryMapper.toEntity(category2.get(0)).getId());
//        assertNotEquals(categoryMapper.toEntity(category1.get(0)).getName(), categoryMapper.toEntity(category2.get(0)).getName());
//        assertNotEquals(categoryMapper.toEntity(category1.get(0)).getGoods(), categoryMapper.toEntity(category2.get(0)).getGoods());
//    }
//
//    @Test
//    public void deleteBy() {
//        Category category = new Category(1, "name", new ArrayList<Good>());
//
//        categoryRepository.save(category);
//        categoryRepository.deleteById(1);
//        List<CategoryDto> category1 = categoryRepository.findAll().stream().map(categoryMapper::toDto).collect(toList());
//
//        assertTrue(category1.size() < 1);
//    }
//}