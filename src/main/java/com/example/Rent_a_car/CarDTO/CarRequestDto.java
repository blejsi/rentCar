package com.example.Rent_a_car.CarDTO;

import com.example.Rent_a_car.model.Category;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarRequestDto {

    private String brand;
    private String model;
    private String bodyType;
    private String colour;
    private Double mileage;
    private Integer year;
    private Double amount;


    private String CategoryName;
    private int categoryPaxCapacity;

}
