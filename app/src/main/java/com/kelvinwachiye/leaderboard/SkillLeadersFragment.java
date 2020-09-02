package com.kelvinwachiye.leaderboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SkillLeadersFragment extends Fragment {
    private LeadersViewModel mLeadersViewModel;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_skill_leaders, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.rvSkills);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));
        recyclerView.setHasFixedSize(true);

        final SkillIqAdapter adapter = new SkillIqAdapter();
        recyclerView.setAdapter(adapter);

        mLeadersViewModel = new ViewModelProvider(this).get(LeadersViewModel.class);
        mLeadersViewModel.getSkillLeaders().observe(getViewLifecycleOwner(), new
                Observer<List<SkillIQ>>() {
                    @Override
                    public void onChanged(List<SkillIQ> skillIQS) {
                        adapter.setSkillIQS(skillIQS);
                    }
                });
        return view;
    }
}