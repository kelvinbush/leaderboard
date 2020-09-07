package com.kelvinwachiye.leaderboard.models;

public class SkillIQ {
    private String name;
    private String score;
    private String country;
    private String badgeUrl;

    public SkillIQ(String name, String score, String country, String badgeUrl) {
        this.name = name;
        this.score = score;
        this.country = country;
        this.badgeUrl = badgeUrl;
    }

    public String getName() {
        return name;
    }

    public String getScore() {
        return score;
    }

    public String getCountry() {
        return country;
    }

    public String getBadgeUrl() {
        return badgeUrl;
    }
}
