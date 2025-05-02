package com.dobval.open_info_hub.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

import com.dobval.open_info_hub.models.WeatherDailyForecast;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AggregatedInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private int githubRepos;
    private int githubFollowers;

    private String city;
    

    private double eurToUsdRate;

    private LocalDateTime fetchedAt;
    
    @Transient //ensures JPA doesn't try to persist it in the DB
    private List<WeatherDailyForecast> dailyForecasts;
}
