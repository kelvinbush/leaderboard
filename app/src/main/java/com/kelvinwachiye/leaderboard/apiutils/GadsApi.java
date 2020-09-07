package com.kelvinwachiye.leaderboard.apiutils;

import com.kelvinwachiye.leaderboard.models.LearnerHours;
import com.kelvinwachiye.leaderboard.models.SkillIQ;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GadsApi {
    @GET("hours")
    Call<List<LearnerHours>> getLearnerHours();

    @GET("skilliq")
    Call<List<SkillIQ>> getSkillIq();
}
