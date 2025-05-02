package com.dobval.open_info_hub.services;

import com.dobval.open_info_hub.models.WeatherForecast;
import com.dobval.open_info_hub.models.WeatherForecast.Daily;
import com.dobval.open_info_hub.models.WeatherDailyForecast;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class WeatherService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String BASE_URL = "https://api.open-meteo.com/v1/forecast";
    private final GeocodingService geo;

    public WeatherService(GeocodingService geo) {
        this.geo = geo;
    }

    public List<WeatherDailyForecast> fetchForecast(String city) {
        var coords = geo.geocode(city);
        String url = UriComponentsBuilder.fromHttpUrl(BASE_URL)
            .queryParam("latitude", coords.getLatitude())
            .queryParam("longitude", coords.getLongitude())
            .queryParam("daily", "temperature_2m_max")
            .queryParam("timezone", "Europe/Berlin")
            .toUriString();
        
        try {
            WeatherForecast response = restTemplate.getForObject(url, WeatherForecast.class);
            if (response == null || response.getDaily() == null) {
                return Collections.emptyList();
            }

            Daily daily = response.getDaily();
            List<String> dates = daily.getTime();
            List<Double> temps = daily.getTemperature_2m_max();

            List<WeatherDailyForecast> result = new ArrayList<>();
            for (int i = 0; i < dates.size(); i++) {
                result.add(new WeatherDailyForecast(dates.get(i), temps.get(i)));
            }

            return result;
        } catch (HttpClientErrorException e) {
            System.err.println("Weather API (open-meteo) returned error: " + e.getStatusCode() + " - " + e.getResponseBodyAsString());
            return Collections.emptyList();
        }
    }
}
