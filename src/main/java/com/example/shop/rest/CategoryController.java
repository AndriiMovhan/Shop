package com.example.shop.rest;

import com.example.shop.dto.CategoryDto;
import com.example.shop.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDto>> getAll() {
        return ResponseEntity.ok(categoryService.findAll());
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<List<CategoryDto>> getById(@PathVariable String id) {
        return ResponseEntity.ok(categoryService.findById(id));
    }

    @PostMapping("/categories")
    public ResponseEntity<CategoryDto> save(@RequestBody CategoryDto goodDto) {
        return ResponseEntity.ok(categoryService.save(goodDto));
    }

    @PutMapping("/categories")
    public ResponseEntity<CategoryDto> update(@RequestBody CategoryDto goodDto) {
        return ResponseEntity.ok(categoryService.update(goodDto));
    }

    @DeleteMapping("/categories/{id}")
    public void deleteById(@PathVariable String id) {
        categoryService.deleteBy(id);
    }
}
