package com.kelvinwachiye.leaderboard;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroClass {
    private static final String GADS_BASE_URL = "https://gadsapi.herokuapp.com/api/";

    private static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder().baseUrl(GADS_BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
    }

    public static GadsApi getApiService() {
        return getRetrofitInstance().create(GadsApi.class);
    }
}
