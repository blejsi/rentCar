package com.example.Rent_a_car.CarDTO;

import com.example.Rent_a_car.model.Category;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarResponseDto {
    private Long id;
    private String brand;
    private String model;
    private String bodyType;
    private String colour;
    private Double mileage;
    private Integer year;
    private Double amount;


    private Long categoryId;
    private String CategoryName;
    private int categoryPaxCapacity;
}
