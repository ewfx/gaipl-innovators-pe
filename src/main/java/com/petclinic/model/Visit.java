package com.petclinic.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "visits")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private String description;

    @ManyToOne
    @JoinColumn(name = "pet_id", nullable = false)
    private Pet pet;
}
