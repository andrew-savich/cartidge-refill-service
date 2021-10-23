package com.andrewsavich.bajter.cartridgerefillservice.model.cartridge;

import com.andrewsavich.bajter.cartridgerefillservice.model.client.Client;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
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
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    @Column(name = "added_date")
    private Date addedDate;

    @NotNull
    @Column(name = "unique_identify", unique = true)
    private String uniqIdentify;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "model_id", referencedColumnName="id")
    private Model model;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "client_id", referencedColumnName="id")
    private Client client;

}
