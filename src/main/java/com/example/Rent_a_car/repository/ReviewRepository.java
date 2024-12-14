package com.example.Rent_a_car.repository;

import com.example.Rent_a_car.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReviewRepository extends JpaRepository<Review, Long> {
}
