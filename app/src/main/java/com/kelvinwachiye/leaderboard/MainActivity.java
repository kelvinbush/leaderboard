//package com.kelvinwachiye.leaderboard;
//
//import android.os.Bundle;
//import android.widget.TextView;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import java.util.List;
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//public class MainActivity extends AppCompatActivity {
//    private TextView textViewResult;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        textViewResult = findViewById(R.id.tvResult);
//
////        getLearnerHours();
////        submit();
//        getSkillIqLeaders();
//    }
//
////    private void submit() {
////        Call<Void> call = RetroClass.getGoogleApiService().createPost();
////        call.enqueue(new Callback<Void>() {
////            @Override
////            public void onResponse(Call<Void> call, Response<Void> response) {
////                textViewResult.setText("Code: " + response.code());
////            }
////
////            @Override
////            public void onFailure(Call<Void> call, Throwable t) {
////                textViewResult.setText(t.getMessage());
////            }
////        });
////    }
//
//    private void getSkillIqLeaders() {
//        Call<List<SkillIQ>> call = RetroClass.getGadsApiService().getSkillIq();
//        call.enqueue(new Callback<List<SkillIQ>>() {
//            @Override
//            public void onResponse(Call<List<SkillIQ>> call, Response<List<SkillIQ>> response) {
//                if (!response.isSuccessful()) {
//                    textViewResult.setText("Code: " + response.code());
//                    return;
//                }
//                List<SkillIQ> skillIQList = response.body();
//                assert skillIQList != null;
//                for (SkillIQ skillIQ : skillIQList) {
//                    String content = "";
//                    content += "NAME: " + skillIQ.getName() + "\n";
//                    content += "SCORE: " + skillIQ.getScore() + "\n";
//                    content += "COUNTRY: " + skillIQ.getCountry() + "\n";
//                    content += "Badge: " + skillIQ.getBadgeUrl() + "\n";
//
//                    textViewResult.append(content);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<SkillIQ>> call, Throwable t) {
//                textViewResult.setText(t.getMessage());
//            }
//        });
//    }
//
//    private void getLearnerHours() {
//        Call<List<LearnerHours>> call = RetroClass.getGadsApiService().getLearnerHours();
//        call.enqueue(new Callback<List<LearnerHours>>() {
//            @Override
//            public void onResponse(Call<List<LearnerHours>> call, Response<List<LearnerHours>> response) {
//                if (!response.isSuccessful()) {
//                    textViewResult.setText("Code: " + response.code());
//                    return;
//                }
//                List<LearnerHours> learnerHoursList = response.body();
//                assert learnerHoursList != null;
//                for (LearnerHours learnerHours : learnerHoursList) {
//                    String content = "";
//                    content += "NAME: " + learnerHours.getName() + "\n";
//                    content += "HOURS: " + learnerHours.getHours() + "\n";
//                    content += "COUNTRY: " + learnerHours.getCountry() + "\n";
//                    content += "Badge: " + learnerHours.getBadgeUrl() + "\n";
//
//                    textViewResult.append(content);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<LearnerHours>> call, Throwable t) {
//                textViewResult.setText(t.getMessage());
//
//            }
//        });
//    }
//}