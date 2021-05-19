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

public class FaqAdapter extends RecyclerView.Adapter<FaqAdapter.FaqViewHolder> {

    Context context;
    List<TrackList> trackList;
    private OnFaqListener mOnFaqListener;

    public FaqAdapter(Context context, List<TrackList> trackList, OnFaqListener mOnFaqListener) {
        this.context = context;
        this.trackList = trackList;
        this.mOnFaqListener = mOnFaqListener;
    }

    @NonNull
    @Override
    public FaqViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.track_faq_main_item, parent, false);
        return new FaqViewHolder(view,mOnFaqListener);
    }

    @Override
    public void onBindViewHolder(@NonNull FaqAdapter.FaqViewHolder holder, int position) {
        holder.trackImage.setImageResource(trackList.get(position).getImageUrl());
        holder.trackName.setText(trackList.get(position).getTrackName());
    }

    @Override
    public int getItemCount() {
        return trackList.size();
    }


    public static final class FaqViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView trackImage;
        TextView trackName;
        FaqAdapter.OnFaqListener onFaqListener;

        public FaqViewHolder(@NonNull View itemView, FaqAdapter.OnFaqListener onFaqListener) {
            super(itemView);
            trackImage = itemView.findViewById(R.id.faq_image);
            trackName = itemView.findViewById(R.id.faq_title);
            this.onFaqListener = onFaqListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onFaqListener.onFaqClick(getAdapterPosition());
        }
    }
    public interface OnFaqListener{
        void onFaqClick(int position);
    }
}
