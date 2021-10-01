package com.andrewsavich.bajter.cartridgerefillservice.model.cartridge;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String title;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Groupe grope;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private Type type;

    @Enumerated(value = EnumType.STRING)
    private Color color;

    private String description;
}
