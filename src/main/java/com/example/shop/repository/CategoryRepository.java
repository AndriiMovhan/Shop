package com.example.shop.repository;

import com.example.shop.model.Category;
import com.example.shop.model.Good;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
