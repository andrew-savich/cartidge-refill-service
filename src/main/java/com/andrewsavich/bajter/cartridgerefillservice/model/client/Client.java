package com.andrewsavich.bajter.cartridgerefillservice.model.client;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 3)
    @Pattern(regexp = "^[а-яА-Яa-zA-Z]*$")
    private String name;

    private String contact;

    @Max(400)
    private String description;
}
