package com.example.electricitybillingsystem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UnPaidBills {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double unpaidBill;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date date;

    @PrePersist
    private void onCreate(){
        date = new Date();
    }

    @ManyToOne(optional = false)
    @JsonBackReference
    private Property property;
}
