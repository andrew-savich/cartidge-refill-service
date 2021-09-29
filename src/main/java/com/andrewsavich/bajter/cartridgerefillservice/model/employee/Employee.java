package com.andrewsavich.bajter.cartridgerefillservice.model.employee;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 5, max = 30)
    @Pattern(regexp = "^[a-z0-9_-]*$")
    private String login;

    @NotNull
    @Size(min = 5, max = 30)
    @Pattern(regexp = "^[a-zA-Z0-9]*$")
    private String password;

    @NotNull
    @Size(min = 2, max = 30)
    @Pattern(regexp = "^[а-яА-Яa-zA-Z]*$")
    private String firstName;

    @NotNull
    @Size(min = 2, max = 30)
    @Pattern(regexp = "^[а-яА-Яa-zA-Z]*$")
    private String lastName;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private Position position;

    public void updateFields(Employee employee){
        this.setLogin(employee.getLogin());
        this.setFirstName(employee.getFirstName());
        this.setLastName(employee.getLastName());
        this.setPassword(employee.getPassword());
        this.setPosition(employee.getPosition());
    }
}
