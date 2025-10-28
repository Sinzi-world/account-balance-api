package com.example.accountbalanceapi.model.dto.balance;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Запрос на создание нового баланса")
public class BalanceRequest {

    @Schema(description = "Имя баланса (уникальное)", example = "user123-wallet", required = true)
    private String name;
}
