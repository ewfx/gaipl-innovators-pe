package com.petclinic.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "pets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private Date birthDate;
    private String type;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private Owner owner;
}
