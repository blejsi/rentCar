package com.example.Rent_a_car.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.management.relation.Role;
import java.util.Set;

@Entity
@Table(name="USER")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User  {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "USER_ROLE",
            joinColumns =@JoinColumn(name="USER_ID"),
            inverseJoinColumns = @JoinColumn(name ="ROLE_ID")
    )
    private Set<Role> setRoles;

}
