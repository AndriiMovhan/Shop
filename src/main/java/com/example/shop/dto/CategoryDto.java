package com.example.shop.dto;

import com.example.shop.model.Good;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {

    private Integer id;
    private String name;
    private Collection<Good> goods;
}
