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
import com.kelvinwachiye.leaderboard.adapters.SkillIqAdapter;
import com.kelvinwachiye.leaderboard.models.SkillIQ;
import com.kelvinwachiye.leaderboard.viewmodel.LeadersViewModel;

import java.util.List;

public class SkillLeadersFragment extends Fragment {
    private LeadersViewModel mLeadersViewModel;
    private TextView mTextView;
    private SkillIqAdapter mAdapter;
    private RecyclerView mRecyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_skill_leaders, container, false);
        mTextView = view.findViewById(R.id.tvSError);
        mTextView.setVisibility(View.INVISIBLE);

        mRecyclerView = view.findViewById(R.id.rvSkills);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));
        mRecyclerView.setHasFixedSize(true);

        mAdapter = new SkillIqAdapter();
        mRecyclerView.setAdapter(mAdapter);

        init();
        return view;
    }

    private void init() {
        if (isNetworkAvailable()) {
            mLeadersViewModel = new ViewModelProvider(this).get(LeadersViewModel.class);
            mLeadersViewModel.getSkillLeaders().observe(getViewLifecycleOwner(), new
                    Observer<List<SkillIQ>>() {
                        @Override
                        public void onChanged(List<SkillIQ> skillIQS) {
                            mAdapter.setSkillIQS(skillIQS);
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