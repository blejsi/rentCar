package com.example.Rent_a_car.repository;

import com.example.Rent_a_car.model.Car;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}