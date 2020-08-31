package com.kelvinwachiye.leaderboard;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SubmissionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submission);
    }

    public void submitProject(View view) {
        Toast.makeText(this, "hrjvkfbvfhkvbhk", Toast.LENGTH_SHORT).show();
    }

    public void backToMain(View view) {
        finish();
    }
}