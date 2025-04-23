package com.dobval.open_info_hub.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.dobval.open_info_hub.models.GitHubProfile;

import org.springframework.http.ResponseEntity;

@Service
public class GitHubService {

	private final RestTemplate restTemplate;
	private final String BASE_URL = "https://api.github.com/users/";
	
	public GitHubService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
	
	public GitHubProfile fetchProfile(String username) {
		try {
		    ResponseEntity<GitHubProfile> response = restTemplate.getForEntity(BASE_URL + username, GitHubProfile.class);
		    if (response.getStatusCode().is2xxSuccessful()) {
		        return response.getBody();
		    } else {
		        throw new RuntimeException("GitHub API failed with status: " + response.getStatusCode());
		    }
		} 
		catch (RestClientException e) {
		    throw new RuntimeException("GitHub API error", e);
		}

	}
}
