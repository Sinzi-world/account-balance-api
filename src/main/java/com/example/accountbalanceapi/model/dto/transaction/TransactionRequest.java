package com.example.accountbalanceapi.model.dto.transaction;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Запрос на создание транзакции (депозит или снятие средств)")
public class TransactionRequest {

    @Schema(description = "Тип транзакции", example = "DEPOSIT", requiredMode = Schema.RequiredMode.REQUIRED)
    private String type;

    @Schema(description = "Сумма операции в валюте транзакции", example = "100.50", requiredMode = Schema.RequiredMode.REQUIRED)
    private double amount;

    @Schema(description = "Валюта транзакции", example = "USD", requiredMode = Schema.RequiredMode.REQUIRED)
    private String currency;
}

