package com.andrewsavich.bajter.cartridgerefillservice.model.cartridge;

import com.andrewsavich.bajter.cartridgerefillservice.model.client.Client;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "cartridges")
@Data
public class Cartridge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "unique_identify", unique = true)
    private String uniqueIdentify;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "model_title", referencedColumnName="title")
    private Model model;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "client_name", referencedColumnName="name")
    private Client client;

    @NotNull
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    @Column(name = "added_date")
    private Date addedDate;

    @Column(name = "description")
    private String description;

}
