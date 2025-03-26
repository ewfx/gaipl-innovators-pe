package com.petclinic.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "vets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String firstName;
    private String lastName;
}
