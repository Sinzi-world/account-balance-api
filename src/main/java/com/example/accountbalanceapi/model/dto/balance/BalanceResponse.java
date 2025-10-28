package com.example.accountbalanceapi.model.dto.balance;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Информация о балансе аккаунта")
public class BalanceResponse {

    @Schema(description = "Уникальный идентификатор баланса", example = "321e4567-e89b-12d3-a456-426614174999")
    private UUID id;

    @Schema(description = "Имя баланса (уникальное имя счёта)", example = "main-account")
    private String name;

    @Schema(description = "Текущий баланс в USD", example = "2350.00")
    private double balanceUsd;
}
