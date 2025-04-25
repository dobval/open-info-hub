package com.dobval.open_info_hub.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyRate {
    private Map<String, Double> rates;

    public double getUsd() {
        if (rates == null || !rates.containsKey("USD")) {
            throw new RuntimeException("USD rate not found in response");
        }
        return rates.get("USD");
    }
}
