package com.example.shop.repository;

import com.example.shop.model.Category;
import com.example.shop.model.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
