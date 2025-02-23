package com.example.CurrencyConverter.service;

import com.example.CurrencyConverter.model.exchangeRatesResponse;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import java.util.Map;

class CurrencyServiceTest {

    private final currencyService currencyService = Mockito.mock(currencyService.class);

    @Test
    void testConvertCurrency() {
        exchangeRatesResponse mockResponse = new exchangeRatesResponse();
        mockResponse.setBase_code("USD");
        mockResponse.setRates(Map.of("EUR", 0.94));

        when(currencyService.getExchangeRates("USD")).thenReturn(mockResponse);

        double convertedAmount = currencyService.convertCurrency("USD", "EUR", 100);
        assertEquals(94.0, convertedAmount, 0.01);
    }

    @Test
    void testInvalidCurrencyCode() {
        when(currencyService.getExchangeRates("XYZ")).thenThrow(new IllegalArgumentException("Invalid currency code"));

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            currencyService.convertCurrency("XYZ", "EUR", 100);
        });

        assertEquals("Invalid currency code", exception.getMessage());
    }
}
