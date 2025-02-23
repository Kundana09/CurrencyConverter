package com.example.CurrencyConverter.service;

import com.example.CurrencyConverter.model.exchangeRatesResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class currencyService {

    @Value("${exchange.api.url}")
    private String apiUrl;

    @Value("${exchange.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public exchangeRatesResponse getExchangeRates(String base) {
        String url = apiUrl + base + "?apikey=" + apiKey;
        return restTemplate.getForObject(url, exchangeRatesResponse.class);
    }

    public double convertCurrency(String from, String to, double amount) {
        exchangeRatesResponse rates = getExchangeRates(from);
        if (rates == null || !rates.getRates().containsKey(to)) {
            throw new IllegalArgumentException("Invalid currency code or unavailable rates.");
        }
        return amount * rates.getRates().get(to);
    }
}
