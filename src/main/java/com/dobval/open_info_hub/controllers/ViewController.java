package com.dobval.open_info_hub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dobval.open_info_hub.entities.AggregatedInfo;
import com.dobval.open_info_hub.services.AggregatorService;

@Controller
public class ViewController { //handles rendering HTML (human-readable)

    private final AggregatorService aggregatorService;

    @Autowired
    public ViewController(AggregatorService aggregatorService) {
        this.aggregatorService = aggregatorService;
    }

    @GetMapping("/")
    public String showForm() {
        return "form";
    }

    @PostMapping("/aggregate")
    public String aggregate(@RequestParam String username,
                            @RequestParam String city,
                            Model model) {
        AggregatedInfo info = aggregatorService.aggregateInfo(username, city);
        model.addAttribute("info", info);
        return "result";
    }
}

