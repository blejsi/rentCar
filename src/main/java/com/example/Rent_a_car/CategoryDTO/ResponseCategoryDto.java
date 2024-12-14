package com.example.Rent_a_car.CategoryDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseCategoryDto {

    private Long id;
    private String name;
    private int paxCapacity;
}
