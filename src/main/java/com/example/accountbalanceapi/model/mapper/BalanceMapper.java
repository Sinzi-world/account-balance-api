package com.example.accountbalanceapi.model.mapper;

import com.example.accountbalanceapi.model.dto.balance.BalanceRequest;
import com.example.accountbalanceapi.model.dto.balance.BalanceResponse;
import com.example.accountbalanceapi.model.entity.Balance;
import org.springframework.stereotype.Component;

@Component
public class BalanceMapper {

    public Balance toEntity(BalanceRequest request) {
        if (request == null) return null;

        return Balance.builder()
                .name(request.getName())
                .balanceUsd(0.0)
                .build();
    }

    public BalanceResponse toResponse(Balance balance) {
        if (balance == null) return null;

        return BalanceResponse.builder()
                .id(balance.getId())
                .name(balance.getName())
                .balanceUsd(balance.getBalanceUsd())
                .build();
    }
}
