package com.ieee.ieee_yesist.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ieee.ieee_yesist.R;
import com.ieee.ieee_yesist.model.TrackList;

import java.util.List;

public class TrackListAdapter extends RecyclerView.Adapter<TrackListAdapter.TrackListViewHolder> {

    Context context;
    List<TrackList> trackList;
    private OnTrackListener mOnTrackListener;

    public TrackListAdapter(Context context, List<TrackList> trackList, OnTrackListener onTrackListener) {
        this.context = context;
        this.trackList = trackList;
        this.mOnTrackListener = onTrackListener;
    }

    @NonNull
    @Override
    public TrackListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.track_item, parent, false);
        return new TrackListViewHolder(view,mOnTrackListener);
    }

    @Override
    public void onBindViewHolder(@NonNull TrackListViewHolder holder, int position) {
        holder.trackImage.setImageResource(trackList.get(position).getImageUrl());
        holder.trackName.setText(trackList.get(position).getTrackName());
    }

    @Override
    public int getItemCount() {
        return trackList.size();
    }

    public static final class TrackListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView trackImage;
        TextView trackName;
        OnTrackListener onTrackListener;

        public TrackListViewHolder(@NonNull View itemView, OnTrackListener onTrackListener) {
            super(itemView);
            trackImage = itemView.findViewById(R.id.imageTrack);
            trackName = itemView.findViewById(R.id.trackName);
            this.onTrackListener = onTrackListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onTrackListener.onTrackClick(getAdapterPosition());
        }
    }

    public interface OnTrackListener{
        void onTrackClick(int position);
    }

}