package com.example.Rent_a_car.DTO;


import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestReviewDto {

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
}
