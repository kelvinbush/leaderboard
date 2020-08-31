package com.kelvinwachiye.leaderboard;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class LaunchActivity extends AppCompatActivity {
    private static final String TAG = "LaunchActivity";
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = findViewById(R.id.view_pager);
        setUpViewPager(mViewPager);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(mViewPager);
        Log.d(TAG, "onCreate: called");

    }

    private void setUpViewPager(ViewPager viewPager) {
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new LearningLeadersFragment(), getString(R.string.learning_leaders));
        adapter.addFragment(new SkillLeadersFragment(), getString(R.string.skill_leaders));
        viewPager.setAdapter(adapter);
    }

    public void submit(View view) {
        Intent intent = new Intent(this, SubmissionActivity.class);
        startActivity(intent);
    }
}