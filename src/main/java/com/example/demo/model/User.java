package com.example.demo.model;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

// Used only when creating new Account

@Entity
@Data
@Table(name = "`User`")
@NoArgsConstructor
@SuperBuilder
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

   /* @Column(nullable = false)
    private String confirmPassword = "";*/

    @Column(nullable = false)
    private String role;

    @Column(nullable = false)
    @Builder.Default
    private Integer active = 1;

}
