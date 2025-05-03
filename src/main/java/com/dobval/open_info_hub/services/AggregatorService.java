package com.dobval.open_info_hub.services;

import com.dobval.open_info_hub.entities.AggregatedInfo;
import com.dobval.open_info_hub.models.GitHubProfile;
import com.dobval.open_info_hub.repositories.AggregatedInfoRepository;

import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;

@Service
public class AggregatorService {

    @Autowired
    private GitHubService gitHubService;

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private CurrencyService currencyService;

    @Autowired
    private AggregatedInfoRepository aggregatedInfoRepository;

    public AggregatedInfo aggregateInfo(String username, String city) {
        AggregatedInfo info = new AggregatedInfo();

        // check if user submitted empty input fields (should still show other info)
        info.setUsername(username != null ? username : "");
        info.setCity(city != null ? city : "");
        
        if (username != null && !username.trim().isEmpty()) {
        	GitHubProfile profile = gitHubService.fetchProfile(username);
        	info.setGithubRepos(profile.getPublic_repos());
            info.setGithubFollowers(profile.getFollowers());
        }
        else {
        	info.setGithubRepos(-1);
            info.setGithubFollowers(-1);
        }
        
        if (city != null && !city.trim().isEmpty()) {
            info.setDailyForecasts(weatherService.fetchForecast(city));
        } 
        else {
            info.setDailyForecasts(Collections.emptyList());
        }
        
        double exchangeRate = currencyService.fetchEurToUsdRate();

        info.setEurToUsdRate(exchangeRate);
        info.setFetchedAt(LocalDateTime.now());

        return aggregatedInfoRepository.save(info); // persist
    }
    
}
