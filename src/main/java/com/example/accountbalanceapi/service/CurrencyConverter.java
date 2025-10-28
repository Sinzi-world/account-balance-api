package com.example.accountbalanceapi.service;


import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class CurrencyConverter {

    private static final Map<String, Double> ratesToUsd = Map.of(
            "USD", 1.0,
            "EUR", 1.1,
            "BYN", 0.4,
            "RUB", 0.013
    );

    public double convertToUsd(double amount, String currency) {
        Double rate = ratesToUsd.get(currency.toUpperCase());
        if (rate == null) throw new IllegalArgumentException("Unknown currency: " + currency);
        return amount * rate;
    }
}
