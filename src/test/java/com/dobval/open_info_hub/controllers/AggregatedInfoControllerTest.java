package com.dobval.open_info_hub.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class AggregatedInfoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testAggregateAndGetInfo() throws Exception {
        // Test POST (aggregation)
    	mockMvc.perform(post("/api/info")
                .param("username", "octocat")
                .param("city", "Berlin"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("octocat"))
                .andExpect(jsonPath("$.city").value("Berlin"));

        // Test GET (all records)
        mockMvc.perform(get("/api/info"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }
}
