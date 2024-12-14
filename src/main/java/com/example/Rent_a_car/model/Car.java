package com.example.Rent_a_car.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "cars")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    private String brand;
    private String model;
    private String bodyType;
    private String colour;
    private Double mileage;
    private Integer year;
    private Double amount;

     @ManyToOne(fetch = FetchType.EAGER,optional = false)
     @JoinColumn(name = "category_id", nullable = false)
     private Category category;





}
