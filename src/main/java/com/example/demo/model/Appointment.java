package com.example.demo.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Appointment")
@NoArgsConstructor
@Data
public class Appointment {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "PetSitter_id")
    private PetSitter sitter;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @Column
    @NonNull
    private LocalDate startDate;

    @Column
    @NonNull
    private LocalDate endDate;

    @Column
    @NonNull
    private int price;

    @Column
    @NonNull
    private String comment;

    @Column
    @NonNull
    private int review;

}
