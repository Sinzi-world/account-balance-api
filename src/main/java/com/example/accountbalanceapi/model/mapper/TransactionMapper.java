package com.example.accountbalanceapi.model.mapper;


import com.example.accountbalanceapi.model.entity.Transaction;
import com.example.accountbalanceapi.model.dto.transaction.TransactionRequest;
import com.example.accountbalanceapi.model.dto.transaction.TransactionResponse;
import com.example.accountbalanceapi.model.entity.TransactionType;
import org.springframework.stereotype.Component;


@Component
public class TransactionMapper {

    public Transaction toEntity(TransactionRequest request) {
        if (request == null) return null;

        return Transaction.builder()
                .type(TransactionType.valueOf(request.getType().toUpperCase()))
                .amount(request.getAmount())
                .currency(request.getCurrency())
                .build();
    }

    public TransactionResponse toResponse(Transaction transaction) {
        if (transaction == null) return null;

        return TransactionResponse.builder()
                .id(transaction.getId())
                .type(transaction.getType().name())
                .amount(transaction.getAmount())
                .currency(transaction.getCurrency())
                .timestamp(transaction.getTimestamp())
                .build();
    }
}
