package com.example.accountbalanceapi.service;

import com.example.accountbalanceapi.model.mapper.BalanceMapper;
import com.example.accountbalanceapi.model.mapper.TransactionMapper;
import com.example.accountbalanceapi.model.dto.balance.BalanceRequest;
import com.example.accountbalanceapi.model.dto.balance.BalanceResponse;
import com.example.accountbalanceapi.model.dto.transaction.TransactionRequest;
import com.example.accountbalanceapi.model.dto.transaction.TransactionResponse;
import com.example.accountbalanceapi.model.entity.Balance;
import com.example.accountbalanceapi.model.entity.Transaction;
import com.example.accountbalanceapi.model.entity.TransactionType;
import com.example.accountbalanceapi.repository.BalanceRepository;
import com.example.accountbalanceapi.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class AccountService {

    private final BalanceRepository balanceRepository;
    private final TransactionRepository transactionRepository;
    private final BalanceMapper balanceMapper;
    private final TransactionMapper transactionMapper;
    private final CurrencyConverter currencyConverter;

    public BalanceResponse createBalance(BalanceRequest request) {
        Balance balance = balanceMapper.toEntity(request);
        balance = balanceRepository.save(balance);
        return balanceMapper.toResponse(balance);
    }

    public BalanceResponse getBalance(UUID balanceId) {
        Balance balance = balanceRepository.findById(balanceId)
                .orElseThrow(() -> new RuntimeException("Balance not found"));
        return balanceMapper.toResponse(balance);
    }

    public List<TransactionResponse> getTransactions(UUID balanceId) {
        return transactionRepository.findByBalanceId(balanceId)
                .stream()
                .map(transactionMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Transactional
    public TransactionResponse createTransaction(UUID balanceId, TransactionRequest request) {
        Balance balance = balanceRepository.findById(balanceId)
                .orElseThrow(() -> new RuntimeException("Balance not found"));

        Transaction transaction = transactionMapper.toEntity(request);
        transaction.setTimestamp(LocalDateTime.now());
        transaction.setBalance(balance);

        double amountUsd = currencyConverter.convertToUsd(transaction.getAmount(), transaction.getCurrency());

        if (transaction.getType() == TransactionType.DEPOSIT) {
            balance.setBalanceUsd(balance.getBalanceUsd() + amountUsd);
        } else if (transaction.getType() == TransactionType.WITHDRAW) {
            double newBalance = balance.getBalanceUsd() - amountUsd;
            if (newBalance < 0) {
                throw new RuntimeException("Insufficient funds");
            }
            balance.setBalanceUsd(newBalance);
        }

        balance.getTransactions().add(transaction);

        balanceRepository.save(balance);

        return transactionMapper.toResponse(transaction);
    }
}

