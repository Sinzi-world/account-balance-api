package com.example.accountbalanceapi.repository;

import com.example.accountbalanceapi.model.entity.Balance;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;

public interface BalanceRepository extends JpaRepository<Balance, UUID> {

    Optional<Balance> findBalanceByName(String name);
}
