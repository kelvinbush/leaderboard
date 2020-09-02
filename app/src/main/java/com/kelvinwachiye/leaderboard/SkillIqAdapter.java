package com.kelvinwachiye.leaderboard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class SkillIqAdapter extends RecyclerView.Adapter<SkillIqAdapter.SkillIqHolder> {
    private List<SkillIQ> mSkillIQS = new ArrayList<>();

    @NonNull
    @Override
    public SkillIqHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SkillIqHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.skilliq_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SkillIqHolder holder, int position) {
        SkillIQ skillIQ = mSkillIQS.get(position);
        holder.nameTV.setText(skillIQ.getName());
        holder.score.setText(skillIQ.getScore());
        holder.country.setText(skillIQ.getCountry());
        Picasso.get().load(skillIQ.getBadgeUrl())
                .into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return mSkillIQS.size();
    }

    public void setSkillIQS(List<SkillIQ> skillIQS) {
        this.mSkillIQS = skillIQS;
        notifyDataSetChanged();
    }

    class SkillIqHolder extends RecyclerView.ViewHolder {
        private TextView nameTV;
        private TextView score;
        private TextView country;
        private ImageView mImageView;

        public SkillIqHolder(@NonNull View itemView) {
            super(itemView);
            nameTV = itemView.findViewById(R.id.tvName);
            score = itemView.findViewById(R.id.tvScore);
            country = itemView.findViewById(R.id.tvCountry);
            mImageView = itemView.findViewById(R.id.skillIqBadge);
        }
    }
}