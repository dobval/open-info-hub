package com.dobval.open_info_hub.models;

import lombok.Data;

@Data
public class GitHubProfile {
	private String login;
    private int public_repos;
    private int followers;
    private String avatar_url;
}
