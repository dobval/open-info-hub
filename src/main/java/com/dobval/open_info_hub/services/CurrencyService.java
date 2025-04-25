package com.dobval.open_info_hub.services;

import com.dobval.open_info_hub.models.CurrencyRate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class CurrencyService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String API_URL = "https://open.er-api.com/v6/latest/EUR";

    public double fetchEurToUsdRate() {
        try {
        	CurrencyRate currencyRate = restTemplate.getForObject(API_URL, CurrencyRate.class);
	        if (currencyRate != null && currencyRate.getUsd() > 0) {
	            return currencyRate.getUsd();
	        } else {
	            throw new RuntimeException("Exchange rate should be greater than 0"); //TODO: fix FOREX retrieval
	        }
        }
	    catch (RestClientException e) {
	    	throw new RuntimeException("Currency API (er-api) error", e);
	    }
    }
}
