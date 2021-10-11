package com.andrewsavich.bajter.cartridgerefillservice.model.cartridge;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class CartridgeGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String title;

    private String description;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "cartridgeGroup", cascade = CascadeType.MERGE)
    private List<Model> models;

    public void update(CartridgeGroup changedCartridgeGroup){
        this.setTitle(changedCartridgeGroup.getTitle());
        this.setDescription(changedCartridgeGroup.getDescription());
    }
}