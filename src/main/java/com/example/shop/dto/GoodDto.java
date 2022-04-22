package com.example.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GoodDto {

    private Integer id;
    private String name;
    private Integer price;
    private Collection<Integer> categoryIds;
}
