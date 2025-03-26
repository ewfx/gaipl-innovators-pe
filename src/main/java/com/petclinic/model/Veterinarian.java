package com.petclinic.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "veterinarians")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Veterinarian {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")  // Map firstName -> first_name
    private String firstName;

    @Column(name = "last_name")  // Map lastName -> last_name
    private String lastName;

    @Column(name = "specialty")  // Already matches, no change needed
    private String specialty;
}
