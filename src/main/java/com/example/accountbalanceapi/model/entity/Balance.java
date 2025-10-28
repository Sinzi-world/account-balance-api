package com.example.accountbalanceapi.model.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "balances")
public class Balance {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(unique = true, nullable = false)
    private String name;

    private double balanceUsd = 0.0;

    @OneToMany(mappedBy = "balance", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaction> transactions;
}
