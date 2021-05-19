package com.ieee.ieee_yesist.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ieee.ieee_yesist.R;
import com.ieee.ieee_yesist.model.Speaker;

import java.util.List;

public class SpeakerAdapter extends RecyclerView.Adapter<SpeakerAdapter.ViewHolder> {

    private List<Speaker> speakerList;

    public SpeakerAdapter(List<Speaker> speakerList) {
        this.speakerList = speakerList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_speaker, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.speakerImage.setImageResource(speakerList.get(position).getSpeakerImage());
        holder.speakerName.setText(speakerList.get(position).getSpeakerName());
        holder.speakerQualification.setText(speakerList.get(position).getSpeakerDesignation());
    }

    @Override
    public int getItemCount() {
        return speakerList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView speakerImage;
        TextView speakerName, speakerQualification;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            speakerImage = itemView.findViewById(R.id.speaker_image);
            speakerName = itemView.findViewById(R.id.speaker_name);
            speakerQualification = itemView.findViewById(R.id.speaker_qualification);
        }
    }

}
