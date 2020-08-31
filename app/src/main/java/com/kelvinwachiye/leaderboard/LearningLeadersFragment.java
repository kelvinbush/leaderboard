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


public class LearningLeadersFragment extends Fragment {
    private LeadersViewModel mLeadersViewModel;
    private TextView mTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_learning_leaders, container, false);
        mTextView = view.findViewById(R.id.tvHours);
        mLeadersViewModel = new ViewModelProvider(this).get(LeadersViewModel.class);
        mLeadersViewModel.getLearningLeaders().observe(getViewLifecycleOwner(), new
                Observer<List<LearnerHours>>() {
                    @Override
                    public void onChanged(List<LearnerHours> learnerHours) {

                        for (LearnerHours mLearnerHours : learnerHours) {
                            String content = "";
                            content += "NAME: " + mLearnerHours.getName() + "\n";
                            content += "HOURS: " + mLearnerHours.getHours() + "\n";
                            content += "COUNTRY: " + mLearnerHours.getCountry() + "\n";
                            content += "Badge: " + mLearnerHours.getBadgeUrl() + "\n";
                            mTextView.append(content);
                        }
                    }
                });
        return view;
    }
}