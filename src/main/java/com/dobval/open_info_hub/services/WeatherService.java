package com.dobval.open_info_hub.services;

import com.dobval.open_info_hub.models.WeatherForecast;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.http.ResponseEntity;

@Service
public class WeatherService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String BASE_URL = "https://api.open-meteo.com/v1/forecast";
    private final GeocodingService geo;

    public WeatherService(GeocodingService geo) {
        this.geo = geo;
    }

    public WeatherForecast fetchForecast(String city) {
        var coords = geo.geocode(city);
        String url = UriComponentsBuilder.fromHttpUrl(BASE_URL)
            .queryParam("latitude", coords.getLatitude())
            .queryParam("longitude", coords.getLongitude())
            .queryParam("daily", "temperature_2m_max")
            .queryParam("timezone", "Europe/Berlin")
            .toUriString();
        try {
	        WeatherForecast response = restTemplate.getForObject(url, WeatherForecast.class);
	        return response;
        }
        catch (HttpClientErrorException e) {
            System.err.println("Weather API (open-meteo) returned error: " + e.getStatusCode() + " - " + e.getResponseBodyAsString());
            throw e;
        }
    }
}
