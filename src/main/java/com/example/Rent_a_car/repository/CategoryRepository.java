package com.example.Rent_a_car.repository;

import com.example.Rent_a_car.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    Optional<Category> findByName(String categoryName);
}
