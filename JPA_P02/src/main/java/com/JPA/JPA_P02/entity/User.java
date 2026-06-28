package com.JPA.JPA_P02.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length= 30)
    private String username;
    @Column(nullable = false,length= 70)
    private String password;
    @Column(nullable = false)
    private String role;
}
