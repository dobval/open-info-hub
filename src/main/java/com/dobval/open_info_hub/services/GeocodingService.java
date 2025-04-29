package com.dobval.open_info_hub.services;

import java.net.URI;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.dobval.open_info_hub.models.GeocodingApiResult;
import com.dobval.open_info_hub.models.GeocodingCoordinates;

@Service
public class GeocodingService {
    private final RestTemplate rest = new RestTemplate();
    private final String NOMINATIM_URL = "https://nominatim.openstreetmap.org/search";

    public GeocodingCoordinates geocode(String city) {
        URI uri = UriComponentsBuilder
            .fromUriString(NOMINATIM_URL)
            .queryParam("q", city)
            .queryParam("format", "json")
            .queryParam("limit", 1)
            .build().toUri();

        GeocodingApiResult[] response = rest.getForObject(uri, GeocodingApiResult[].class);

        if (response == null || response.length == 0) {
            throw new RuntimeException("Geocoding failed for city: " + city);
        }

        double lat = Double.parseDouble(response[0].getLat());
        double lon = Double.parseDouble(response[0].getLon());

        return new GeocodingCoordinates(lat, lon);
    }

}
