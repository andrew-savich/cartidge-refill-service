package com.andrewsavich.bajter.cartridgerefillservice.model.cartridge;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;


@Data
@Entity
@Table(name = "models")
public class Model implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 30)
    @Column(name = "title")
    private String title;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "group_title", referencedColumnName="title")
    private Group group;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    @Column(name = "type")
    private Type type;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "color")
    private Color color;

    @Column(name = "default_grams")
    @Min(value = 0)
    @Max(value = 1000)
    private Short defaultGrams;

    @Column(name = "description")
    private String description;
}
