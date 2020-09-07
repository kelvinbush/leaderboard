package com.kelvinwachiye.leaderboard.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.kelvinwachiye.leaderboard.apiutils.GadsApi;
import com.kelvinwachiye.leaderboard.apiutils.GoogleFormsApi;
import com.kelvinwachiye.leaderboard.apiutils.RetroClass;
import com.kelvinwachiye.leaderboard.models.LearnerHours;
import com.kelvinwachiye.leaderboard.models.SkillIQ;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LeadersRepository {
    private static LeadersRepository instance;
    private GadsApi mGadsApi = RetroClass.getGadsApiService();
    private GoogleFormsApi mGoogleFormsApi = RetroClass.getGoogleApiService();
    private MutableLiveData<List<LearnerHours>> mLearnerHoursMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<List<SkillIQ>> mSkillLeadersMutableLiveData = new MutableLiveData<>();

    public static LeadersRepository getInstance() {
        if (instance == null) {
            instance = new LeadersRepository();
        }
        return instance;
    }

    private void getLearningLeaders() {
        Call<List<LearnerHours>> call = mGadsApi.getLearnerHours();
        call.enqueue(new Callback<List<LearnerHours>>() {
            @Override
            public void onResponse(Call<List<LearnerHours>> call, Response<List<LearnerHours>> response) {
                mLearnerHoursMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<LearnerHours>> call, Throwable t) {
            }
        });
    }

    private void getSkillIqLeaders() {
        Call<List<SkillIQ>> call = mGadsApi.getSkillIq();
        call.enqueue(new Callback<List<SkillIQ>>() {
            @Override
            public void onResponse(Call<List<SkillIQ>> call, Response<List<SkillIQ>> response) {
                mSkillLeadersMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<SkillIQ>> call, Throwable t) {
            }
        });
    }

    public LiveData<List<LearnerHours>> getLearnerLeaders() {
        getLearningLeaders();
        if (mLearnerHoursMutableLiveData == null) {
            mLearnerHoursMutableLiveData = new MutableLiveData<>();
        }
        return mLearnerHoursMutableLiveData;
    }

    public LiveData<List<SkillIQ>> getSkillLeaders() {
        getSkillIqLeaders();
        if (mSkillLeadersMutableLiveData == null) {
            mSkillLeadersMutableLiveData = new MutableLiveData<>();
        }
        return mSkillLeadersMutableLiveData;
    }
}
