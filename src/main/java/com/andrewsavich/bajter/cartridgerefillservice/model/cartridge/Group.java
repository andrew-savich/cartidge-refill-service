package com.andrewsavich.bajter.cartridgerefillservice.model.cartridge;

import com.andrewsavich.bajter.cartridgerefillservice.model.client.Client;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String title;

    private String description;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "group", cascade = CascadeType.MERGE)
    private List<Model> models;

    public void update(Group changedGroup){
        this.setTitle(changedGroup.getTitle());
        this.setDescription(changedGroup.getDescription());
    }
}