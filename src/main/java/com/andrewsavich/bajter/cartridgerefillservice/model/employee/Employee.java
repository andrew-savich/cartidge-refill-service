package com.andrewsavich.bajter.cartridgerefillservice.model.employee;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "employees")
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 5, max = 30)
    @Pattern(regexp = "^[a-z0-9_-]*$")
    @Column(name = "login")
    private String login;

    @NotNull
    @Size(min = 5, max = 30)
    @Pattern(regexp = "^[a-zA-Z0-9]*$")
    @Column(name = "password")
    private String password;

    @NotNull
    @Size(min = 2, max = 30)
    @Pattern(regexp = "^[а-яА-Яa-zA-Z]*$")
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Size(min = 2, max = 30)
    @Pattern(regexp = "^[а-яА-Яa-zA-Z]*$")
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    @Column(name = "position")
    private Position position;

}
