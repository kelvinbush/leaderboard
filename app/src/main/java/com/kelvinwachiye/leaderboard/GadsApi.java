package com.kelvinwachiye.leaderboard;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GadsApi {
    @GET("hours")
    Call<List<LearnerHours>> getLearnerHours();

    @GET("skilliq")
    Call<List<SkillIQ>> getSkillIq();
}
