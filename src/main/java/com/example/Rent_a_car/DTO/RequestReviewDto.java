package com.example.Rent_a_car.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestReviewDto {
    private String reviewerName;
    private String comment;
    private int rating;
    private LocalDateTime createdDate;
}
