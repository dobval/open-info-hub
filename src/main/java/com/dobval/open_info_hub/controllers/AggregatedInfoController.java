package com.dobval.open_info_hub.controllers;

import com.dobval.open_info_hub.entities.AggregatedInfo;
import com.dobval.open_info_hub.repositories.AggregatedInfoRepository;
import com.dobval.open_info_hub.services.AggregatorService;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/info")
@Component
public class AggregatedInfoController {

    private final AggregatorService aggregatorService;
    private final AggregatedInfoRepository repository;

    public AggregatedInfoController(AggregatorService aggregatorService, AggregatedInfoRepository repository) {
        this.aggregatorService = aggregatorService;
        this.repository = repository;
    }

    @PostMapping
    public AggregatedInfo aggregate(@RequestParam String username, @RequestParam String city) {
        return aggregatorService.aggregateInfo(username, city);
    }

    @GetMapping
    public List<AggregatedInfo> getAll() {
        return repository.findAll();
    }
}
