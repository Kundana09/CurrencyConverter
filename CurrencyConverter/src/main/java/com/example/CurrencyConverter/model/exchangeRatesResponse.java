package com.example.CurrencyConverter.model;

import lombok.Data;
import java.util.Map;

@Data
public class exchangeRatesResponse {
    private String base_code;
    private Map<String, Double> rates;

    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }

    public Map<String, Double> getRates() { // Return the correct type
        return rates;
    }

    public void setBase_code(String base_code) {
        this.base_code = base_code;
    }
}
