package com.dobval.open_info_hub.models;

import lombok.Data;

@Data
public class GitHubProfile {
	private String login;
    private int public_repos;
    private int followers;
    private String avatar_url;

    public GitHubProfile() {}

    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public int getPublic_repos() { return public_repos; }
    public void setPublic_repos(int public_repos) { this.public_repos = public_repos; }

    public int getFollowers() { return followers; }
    public void setFollowers(int followers) { this.followers = followers; }

    public String getAvatar_url() { return avatar_url; }
    public void setAvatar_url(String avatar_url) { this.avatar_url = avatar_url; }

    @Override
    public String toString() {
        return "GitHubProfile{" +
                "login='" + login + '\'' +
                ", public_repos=" + public_repos +
                ", followers=" + followers +
                ", avatar_url='" + avatar_url + '\'' +
                '}';
    }

}
