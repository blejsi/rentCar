package com.example.Rent_a_car.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "CLIENTS")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "EMAIL", unique = true)
    private String email;

    @OneToOne
    @JoinColumn(name = "USER_ID")
    private User user; // Optional link to User account

//    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
//    private Set<Purchase> purchases; // Client's purchases

    @ManyToMany
    @JoinTable(
            name = "CLIENT_CAR",
            joinColumns = @JoinColumn(name = "CLIENT_ID"),
            inverseJoinColumns = @JoinColumn(name = "CAR_ID")
    )
    private Set<Car> favoriteTours;
}
