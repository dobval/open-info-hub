package com.dobval.open_info_hub.services;

import com.dobval.open_info_hub.entities.AggregatedInfo;
import com.dobval.open_info_hub.models.GitHubProfile;
import com.dobval.open_info_hub.repositories.AggregatedInfoRepository;

import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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
        GitHubProfile profile = gitHubService.fetchProfile(username);
        String weather = weatherService.fetchForecast(city).toString(); // make sure this is a string
        double exchangeRate = currencyService.fetchEurToUsdRate();

        AggregatedInfo info = new AggregatedInfo();
        info.setUsername(username);
        info.setGithubRepos(profile.getPublic_repos());
        info.setGithubFollowers(profile.getFollowers());
        info.setCity(city);
        info.setWeather(weather);
        info.setEurToUsdRate(exchangeRate);
        info.setFetchedAt(LocalDateTime.now());

        return aggregatedInfoRepository.save(info); // <- persist
    }
    
}
