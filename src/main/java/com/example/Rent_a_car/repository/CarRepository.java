package com.example.Rent_a_car.repository;

import com.example.Rent_a_car.model.Car;

import com.example.Rent_a_car.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CarRepository extends JpaRepository<Car, Long> {
    Optional<Car> findByBrandAndModel(String brand,String model);


    Optional<Car> findByBrand(String brand);
}
