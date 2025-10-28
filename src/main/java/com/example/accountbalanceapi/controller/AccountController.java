package com.example.accountbalanceapi.controller;


import com.example.accountbalanceapi.model.dto.balance.BalanceRequest;
import com.example.accountbalanceapi.model.dto.balance.BalanceResponse;
import com.example.accountbalanceapi.model.dto.transaction.TransactionRequest;
import com.example.accountbalanceapi.model.dto.transaction.TransactionResponse;
import com.example.accountbalanceapi.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/balances")
@RequiredArgsConstructor
@Tag(name = "Account Balance API", description = "Управление балансами и транзакциями")
public class AccountController {

    private final AccountService accountService;

    @Operation(summary = "Создать новый баланс",
            description = "Создаёт баланс с уникальным именем. Стартовое значение всегда 0 USD")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BalanceResponse createBalance(@RequestBody BalanceRequest request) {
        return accountService.createBalance(request);
    }

    @Operation(summary = "Получить состояние баланса",
            description = "Возвращает текущее состояние баланса по UUID")
    @GetMapping(value = "/{balanceId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public BalanceResponse getBalance(
            @Parameter(description = "UUID баланса", example = "321e4567-e89b-12d3-a456-426614174999")
            @PathVariable UUID balanceId) {
        return accountService.getBalance(balanceId);
    }

    @Operation(summary = "Получить список транзакций баланса",
            description = "Возвращает все транзакции указанного баланса")
    @GetMapping(value = "/{balanceId}/transactions", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TransactionResponse> getTransactions(
            @Parameter(description = "UUID баланса", example = "321e4567-e89b-12d3-a456-426614174999")
            @PathVariable UUID balanceId) {
        return accountService.getTransactions(balanceId);
    }

    @Operation(summary = "Создать транзакцию",
            description = "Создаёт транзакцию (депозит или снятие) и обновляет баланс")
    @PostMapping(value = "/{balanceId}/transactions", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public TransactionResponse createTransaction(
            @Parameter(description = "UUID баланса", example = "321e4567-e89b-12d3-a456-426614174999")
            @PathVariable UUID balanceId,
            @RequestBody TransactionRequest request) {
        return accountService.createTransaction(balanceId, request);
    }
}
