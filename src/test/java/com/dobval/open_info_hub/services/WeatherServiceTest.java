package com.dobval.open_info_hub.services;

import com.dobval.open_info_hub.models.WeatherForecast;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WeatherServiceTest {

    @Autowired
    private WeatherService weatherService;

    @Test
    void testFetchForecast() {
        WeatherForecast forecast = weatherService.fetchForecast(52.52, 13.41); // Berlin coords
        assertNotNull(forecast);
        assertNotNull(forecast.getDaily());
        assertFalse(forecast.getDaily().getTemperature_2m_max().isEmpty());
    }
}
