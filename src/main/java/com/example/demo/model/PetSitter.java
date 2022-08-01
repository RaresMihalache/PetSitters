package com.example.demo.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PetSitter")
@NoArgsConstructor
@SuperBuilder
@Data
@PrimaryKeyJoinColumn
public class PetSitter extends User {

   /* @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column
    @NonNull
    private String username;

    @Column
    @NonNull
    private String password;*/

    @Column(nullable = false)
    private int balance;

    @Column(nullable = false)
    private float rating;

    @Column(nullable = false)
    private int noReviews;

    @Column(nullable = false)
    @Builder.Default
    private String details = "";

    /*@Column
    @NonNull
    private String role = ""; // "ROLE_SITTER" OR "ROLE_ADMIN"*/

    @Column(nullable = false)
    @Builder.Default
    private Integer subscribed = 0; // 0 -> unsubscribed, 1 -> subscribed

    @OneToMany(mappedBy = "sitter", cascade = CascadeType.ALL)
    private List<Appointment> appointments;

   /* public PetSitter(@NonNull String username, @NonNull String password, @NonNull String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }*/
}
