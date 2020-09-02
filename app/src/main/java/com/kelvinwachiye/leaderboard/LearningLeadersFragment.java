package com.kelvinwachiye.leaderboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class LearningLeadersFragment extends Fragment {
    private LeadersViewModel mLeadersViewModel;
    private TextView mTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_learning_leaders, container, false);

        mTextView = view.findViewById(R.id.tvError);
        mTextView.setVisibility(View.INVISIBLE);

        RecyclerView recyclerView = view.findViewById(R.id.rvLearners);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));
        recyclerView.setHasFixedSize(true);

        final LearnerAdapter adapter = new LearnerAdapter();
        recyclerView.setAdapter(adapter);

        mLeadersViewModel = new ViewModelProvider(this).get(LeadersViewModel.class);
        mLeadersViewModel.getLearningLeaders().observe(getViewLifecycleOwner(), new
                Observer<List<LearnerHours>>() {
                    @Override
                    public void onChanged(List<LearnerHours> learnerHours) {
                        adapter.setLearnerHours(learnerHours);
                    }
                });
        return view;
    }

}