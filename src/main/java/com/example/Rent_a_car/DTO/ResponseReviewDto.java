package com.example.Rent_a_car.DTO;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseReviewDto {
    private Long id;
    private String reviewerName;
    private String comment;
    private int rating;
    private LocalDateTime createdDate;

    private Long carId;
    private String brand;
    private String model;
    private String bodyType;
    private String colour;
    private Double mileage;
    private Integer year;
    private Double amount;

//    private String reviewerName;
//    private String comment;
//    private int rating;
//    private LocalDateTime createdDate;
//rivate String brand;
//    private String model;
//    private String bodyType;
//    private String colour;
//    private Double mileage;
//    private Integer year;
//    private Double amount;
}
