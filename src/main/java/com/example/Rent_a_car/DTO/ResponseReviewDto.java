package com.example.Rent_a_car.DTO;



import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseReviewDto {
    private Long id;
    private String reviewerName;
    private String comment;
    private int rating;
    private LocalDateTime createdDate;
    private String carName;
}
