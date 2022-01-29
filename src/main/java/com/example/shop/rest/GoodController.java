package com.example.shop.rest;

import com.example.shop.dto.GoodDto;
import com.example.shop.model.Good;
import com.example.shop.service.GoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GoodController {

    private final GoodService goodService;

    @GetMapping("/goods")
    public ResponseEntity<List<GoodDto>> getAll() {
        return ResponseEntity.ok(goodService.findAll());
    }

    @GetMapping("/goods/{id}")
    public ResponseEntity<List<GoodDto>> getById(@PathVariable String id) {
        return ResponseEntity.ok(goodService.findById(id));
    }

    @PostMapping("/goods")
    public ResponseEntity<GoodDto> save(@RequestBody GoodDto goodDto) {
        return ResponseEntity.ok(goodService.save(goodDto));
    }

    @PutMapping("/goods")
    public ResponseEntity<GoodDto> update(@RequestBody GoodDto goodDto) {
        return ResponseEntity.ok(goodService.update(goodDto));
    }

    @DeleteMapping("/goods/{id}")
    public void deleteById(@PathVariable String id) {
        goodService.deleteBy(id);
    }




}
