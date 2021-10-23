package com.andrewsavich.bajter.cartridgerefillservice.model.client;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "clients")
@Data
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 30)
    @Column(name = "name")
    private String name;

    @Column(name = "contact")
    private String contact;

    @Column(name = "description")
    private String description;

}
