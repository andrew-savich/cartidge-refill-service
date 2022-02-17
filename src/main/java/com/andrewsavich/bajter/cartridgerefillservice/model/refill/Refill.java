package com.andrewsavich.bajter.cartridgerefillservice.model.refill;

import com.andrewsavich.bajter.cartridgerefillservice.model.cartridge.Cartridge;
import com.andrewsavich.bajter.cartridgerefillservice.model.employee.Employee;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
@Table(name = "refills")
public class Refill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    @Column(name = "refill_date")
    private Date refillDate;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "cartridge_id", referencedColumnName = "id")
    private Cartridge cartridge;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

    @Column(name = "actual_grams")
    private Short actualGrams;

    @Column(name = "changed_drum")
    private Boolean changedDrum;

    @Column(name = "changed_pcr")
    private Boolean changedPcr;

    @Column(name = "changed_magnet")
    private Boolean changedMagnet;

    @Column(name = "changed_rakel")
    private Boolean changedRakel;

    @Column(name = "changed_doser_blade")
    private Boolean changedDoserBlade;

    @Column(name = "changed_chip")
    private Boolean changedChip;

    @Column(name = "changed_firmware")
    private Boolean changedFirmware;

    @Column(name = "comment")
    private String comment;

    @Column(name = "is_issued_act")
    private Boolean isIssuedAct;

}
