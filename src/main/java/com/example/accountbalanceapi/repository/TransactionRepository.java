package com.example.accountbalanceapi.repository;

import com.example.accountbalanceapi.model.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {

    List<Transaction> findByBalanceId(UUID balanceId);
}