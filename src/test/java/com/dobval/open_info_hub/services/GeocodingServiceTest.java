package com.dobval.open_info_hub.services;

import com.dobval.open_info_hub.models.GeocodingCoordinates;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GeocodingServiceTest {

    @Autowired
    private GeocodingService geocodingService;

    @Test
    void testGeocodeBerlin() {
        GeocodingCoordinates coords = geocodingService.geocode("Berlin");

        assertNotNull(coords, "Coordinates should not be null");
        assertTrue(coords.getLatitude() > 40 && coords.getLatitude() < 60, "Latitude looks off");
        assertTrue(coords.getLongitude() > 0 && coords.getLongitude() < 20, "Longitude looks off");
    }

    @Test
    void testInvalidCity() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            geocodingService.geocode("NarniaCityThatDoesNotExist");
        });

        String message = exception.getMessage();
        assertTrue(message != null && message.contains("Geocoding failed"), "Error message should mention geocoding failure");
    }
}
