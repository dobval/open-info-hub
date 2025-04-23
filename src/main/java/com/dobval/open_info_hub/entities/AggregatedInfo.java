package com.dobval.open_info_hub.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class AggregatedInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private int githubRepos;
    private int githubFollowers;
    private String city;
    private String weather;
    private double eurToUsdRate;
    private LocalDateTime fetchedAt;
}

