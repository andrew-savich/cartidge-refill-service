package com.andrewsavich.bajter.cartridgerefillservice.model.cartridge;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "models")
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 30)
    @Column(name = "title")
    private String title;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id", referencedColumnName="id")
    private Group group;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    @Column(name = "type")
    private Type type;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "color")
    private Color color;

    @Column(name = "default_grams")
    @Size(min = 0, max = 1000)
    private Short defaultGrams;

    @Column(name = "description")
    private String description;
}
