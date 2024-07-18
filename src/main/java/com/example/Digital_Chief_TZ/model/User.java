package com.example.Digital_Chief_TZ.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Username should be not empty")
    private String username;

    @Email
    @NotEmpty(message = "Email should be not empty")
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;
}
