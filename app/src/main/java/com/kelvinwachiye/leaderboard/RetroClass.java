package com.kelvinwachiye.leaderboard;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroClass {
    private static final String GADS_BASE_URL = "https://gadsapi.herokuapp.com/api/";
    public static final String GOOGLE_FORMS_BASE_URL = "https://docs.google.com/forms/d/e/";

    private static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder().baseUrl(GADS_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
    }

    private static Retrofit getGoogleRetrofitInstance() {
        return new Retrofit.Builder().baseUrl(GOOGLE_FORMS_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
    }

    public static GadsApi getGadsApiService() {
        return getRetrofitInstance().create(GadsApi.class);
    }

    public static GoogleFormsApi getGoogleApiService() {
        return getGoogleRetrofitInstance().create(GoogleFormsApi.class);
    }
}
