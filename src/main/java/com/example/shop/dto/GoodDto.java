package com.example.shop.dto;

import com.example.shop.model.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GoodDto {

    private Integer id;
    private String name;
    private Integer price;
    private Category category;
}
