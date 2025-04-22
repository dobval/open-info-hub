package com.dobval.open_info_hub.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dobval.open_info_hub.models.GitHubProfile;

@SpringBootTest
class GitHubServiceTest {

    @Autowired
    private GitHubService gitHubService;
    
    @Test
    void testFetchProfile() {
        GitHubProfile profile = gitHubService.fetchProfile("octocat");
        System.out.println("Profile: " + profile);
        assertNotNull(profile);
        assertEquals("octocat", profile.getLogin()); //TODO: Fix Lombok - getLogin() shows as undefined!
    }
}

