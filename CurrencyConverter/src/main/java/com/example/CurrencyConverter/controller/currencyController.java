package com.example.CurrencyConverter.controller;

import com.example.CurrencyConverter.model.exchangeRatesResponse;
import com.example.CurrencyConverter.service.currencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class currencyController {

    private final currencyService currencyService;

    @Autowired  // Injecting the service via constructor
    public currencyController(currencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/rates")
    public exchangeRatesResponse getRates(@RequestParam(defaultValue = "USD") String base) {
        return currencyService.getExchangeRates(base);
    }

    @PostMapping("/convert")
    public Map<String, Object> convertCurrency(@RequestBody Map<String, Object> request) {
        String from = (String) request.get("from");
        String to = (String) request.get("to");
        double amount = (Double) request.get("amount");

        double convertedAmount = currencyService.convertCurrency(from, to, amount);

        return Map.of(
                "from", from,
                "to", to,
                "amount", amount,
                "convertedAmount", convertedAmount
        );
    }
}
