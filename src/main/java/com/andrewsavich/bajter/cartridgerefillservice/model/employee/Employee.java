package com.andrewsavich.bajter.cartridgerefillservice.model.employee;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;
    private String password;
    private String firstName;
    private String lastName;

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
