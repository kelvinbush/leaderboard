package com.kelvinwachiye.leaderboard;

public class LearnerHours {
    private String name;
    private String hours;
    private String country;
    private String badgeUrl;

    public LearnerHours(String name, String hours, String country, String badgeUrl) {
        this.name = name;
        this.hours = hours;
        this.country = country;
        this.badgeUrl = badgeUrl;
    }

    public String getName() {
        return name;
    }

    public String getHours() {
        return hours;
    }

    public String getCountry() {
        return country;
    }

    public String getBadgeUrl() {
        return badgeUrl;
    }
}
