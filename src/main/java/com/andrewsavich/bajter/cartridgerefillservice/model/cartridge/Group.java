package com.andrewsavich.bajter.cartridgerefillservice.model.cartridge;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 30)
    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "group", cascade = CascadeType.MERGE)
    private List<Model> models;

    public void update(Group changedGroup){
        this.setTitle(changedGroup.getTitle());
        this.setDescription(changedGroup.getDescription());
    }
}