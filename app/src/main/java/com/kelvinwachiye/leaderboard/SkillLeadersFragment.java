package com.kelvinwachiye.leaderboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.util.List;

public class SkillLeadersFragment extends Fragment {
    private LeadersViewModel mLeadersViewModel;
    private TextView mTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_skill_leaders, container, false);
        mTextView = view.findViewById(R.id.tv_skill);
        mLeadersViewModel = new ViewModelProvider(this).get(LeadersViewModel.class);
        mLeadersViewModel.getSkillLeaders().observe(getViewLifecycleOwner(), new
                Observer<List<SkillIQ>>() {
                    @Override
                    public void onChanged(List<SkillIQ> skillIQS) {
                        for (SkillIQ skills : skillIQS) {
                            String content = "";
                            content += "NAME: " + skills.getName() + "\n";
                            content += "SCORE: " + skills.getScore() + "\n";
                            content += "COUNTRY: " + skills.getCountry() + "\n";
                            content += "Badge: " + skills.getBadgeUrl() + "\n";

                            mTextView.append(content);
                        }
                    }
                });
        return view;
    }
}