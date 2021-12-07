package com.andrewsavich.bajter.cartridgerefillservice.model.cartridge;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "groups")
public class Group implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 30)
    @Column(name = "title", unique = true)
    private String title;

    @Column(name = "description")
    private String description;

   @JsonIgnore
   @OneToMany(fetch = FetchType.LAZY, mappedBy = "group", cascade = CascadeType.MERGE)
   private List<Model> models;

}