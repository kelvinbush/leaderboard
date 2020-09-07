package com.kelvinwachiye.leaderboard.ui;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
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

import com.kelvinwachiye.leaderboard.R;
import com.kelvinwachiye.leaderboard.adapters.LearnerAdapter;
import com.kelvinwachiye.leaderboard.models.LearnerHours;
import com.kelvinwachiye.leaderboard.viewmodel.LeadersViewModel;

import java.util.List;


public class LearningLeadersFragment extends Fragment {
    private LeadersViewModel mLeadersViewModel;
    private TextView mTextView;
    private LearnerAdapter mAdapter;
    private RecyclerView mRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_learning_leaders, container, false);

        mTextView = view.findViewById(R.id.tvError);
        mTextView.setVisibility(View.INVISIBLE);


        mRecyclerView = view.findViewById(R.id.rvLearners);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));
        mRecyclerView.setHasFixedSize(true);

        mAdapter = new LearnerAdapter();
        mRecyclerView.setAdapter(mAdapter);
        init();
        return view;
    }

    private void init() {
        if (isNetworkAvailable()) {
            mLeadersViewModel = new ViewModelProvider(this).get(LeadersViewModel.class);
            mLeadersViewModel.getLearningLeaders().observe(getViewLifecycleOwner(), new
                    Observer<List<LearnerHours>>() {
                        @Override
                        public void onChanged(List<LearnerHours> learnerHours) {
                            mAdapter.setLearnerHours(learnerHours);
                        }
                    });
        } else {
            mRecyclerView.setAlpha(0);
            mTextView.setVisibility(View.VISIBLE);
        }
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) requireActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}