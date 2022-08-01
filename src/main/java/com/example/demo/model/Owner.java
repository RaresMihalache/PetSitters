package com.example.demo.model;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Owner")
@NoArgsConstructor
@SuperBuilder
@Data
@PrimaryKeyJoinColumn
public class Owner extends User{

    /*@Id
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
    @Builder.Default
    private int balance = 0;

    /*@Column
    @NonNull
    private String role = "";*/

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @Builder.Default
    private List<Pet> pets = new ArrayList<>();

    /*public Owner(@NonNull String username, @NonNull String password, @NonNull String role) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.active = 1;
    }*/
}
