package com.example.Rent_a_car.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "review")
@Builder
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reviewerName;

    private String comment;

    private int rating;
    private LocalDateTime createdDate;


    @ManyToOne(fetch = FetchType.EAGER ,optional = false)
    @JoinColumn(name = "car_id",nullable = false)
    private Car car;
}
