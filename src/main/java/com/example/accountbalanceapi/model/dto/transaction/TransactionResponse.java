package com.example.accountbalanceapi.model.dto.transaction;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Ответ с информацией о транзакции")
public class TransactionResponse {

    @Schema(description = "Уникальный идентификатор транзакции", example = "123e4567-e89b-12d3-a456-426614174000")
    private UUID id;

    @Schema(description = "Тип транзакции", example = "WITHDRAW")
    private String type;

    @Schema(description = "Сумма транзакции", example = "50.75")
    private double amount;

    @Schema(description = "Валюта транзакции", example = "EUR")
    private String currency;

    @Schema(description = "Время исполнения транзакции", example = "2025-10-28T13:45:00")
    private LocalDateTime timestamp;
}