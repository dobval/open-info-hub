package com.dobval.open_info_hub.services;

import com.dobval.open_info_hub.entities.AggregatedInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

//Can be run instead of unit testing the services independently (github, currency, weather, geocoding)

@SpringBootTest
class AggregatorServiceTest { 
	
    @Autowired
    private AggregatorService aggregatorService;

    @Test
    void testAggregateInfo() {
        AggregatedInfo info = aggregatorService.aggregateInfo("octocat", "Berlin");

        assertNotNull(info, "AggregatedInfo should not be null");
        assertEquals("octocat", info.getUsername(), "Username should match input");
        assertEquals("Berlin", info.getCity(), "City should match input");
        assertTrue(info.getGithubRepos() >= 0, "GitHub repo count should be non-negative");
        assertTrue(info.getGithubFollowers() >= 0, "GitHub follower count should be non-negative");
        assertTrue(info.getEurToUsdRate() > 0, "Exchange rate should be greater than 0");
        assertNotNull(info.getWeather(), "Weather should not be null");
        assertNotNull(info.getFetchedAt(), "FetchedAt should be set");
    }
}
