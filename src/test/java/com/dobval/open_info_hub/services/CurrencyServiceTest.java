package com.dobval.open_info_hub.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CurrencyServiceTest {

    @Autowired
    private CurrencyService currencyService;

    @Test
    void testFetchEurToUsdRate() {
        double rate = currencyService.fetchEurToUsdRate();
        assertTrue(rate > 0, "Exchange rate should be greater than 0");
    }
}
