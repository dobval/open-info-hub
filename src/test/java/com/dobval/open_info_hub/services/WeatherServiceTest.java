package com.dobval.open_info_hub.services;

import com.dobval.open_info_hub.models.WeatherDailyForecast;
import com.dobval.open_info_hub.models.WeatherForecast;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@SpringBootTest
class WeatherServiceTest {

    @Autowired
    private WeatherService weatherService;

    @Test
    void testFetchForecast() {
        List<WeatherDailyForecast> forecast = weatherService.fetchForecast("Berlin");
        assertNotNull(forecast);
        assertEquals(7, forecast.size());
        assertNotNull(forecast.stream());
    }
}
