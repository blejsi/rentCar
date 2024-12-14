package com.example.Rent_a_car.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "ROLES")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column (name = "NAME", unique = true,nullable = false)
    private String roleName;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;


}
