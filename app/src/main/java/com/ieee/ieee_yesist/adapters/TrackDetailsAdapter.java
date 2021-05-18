package com.ieee.ieee_yesist.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;

import com.ieee.ieee_yesist.R;
import com.ieee.ieee_yesist.model.YesistHome;

import java.util.List;

public class TrackDetailsAdapter extends RecyclerView.Adapter<TrackDetailsAdapter.TrackDetailsViewHolder> {
    List<YesistHome> yesistHomeList;
    Context context;

    public TrackDetailsAdapter(List<YesistHome> yesistHomeList, Context context) {
        this.yesistHomeList = yesistHomeList;
        this.context = context;
    }

    @NonNull
    @Override
    public TrackDetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.track_details_rv_item, parent, false);
        return new TrackDetailsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrackDetailsAdapter.TrackDetailsViewHolder holder, int position) {

        holder.ques.setText(yesistHomeList.get(position).getQuesName());
        //holder.reason.setText(yesistHomeList.get(position).getQuesReason());

        holder.arrow_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.reason.getVisibility()==View.VISIBLE){
                    TransitionManager.beginDelayedTransition(holder.rules_cv,
                            new AutoTransition());
                    holder.reason.setVisibility(View.GONE);
                    holder.arrow_down.setImageResource(R.drawable.ic__arrow_down);
                }
                else {
                    TransitionManager.beginDelayedTransition(holder.rules_cv,
                            new AutoTransition());
                    holder.reason.setText(yesistHomeList.get(position).getQuesReason());
                    holder.reason.setVisibility(View.VISIBLE);
                    holder.arrow_down.setImageResource(R.drawable.ic_arrow_up);
                }
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.reason.getVisibility()==View.VISIBLE){
                    TransitionManager.beginDelayedTransition(holder.rules_cv,
                            new AutoTransition());
                    holder.reason.setVisibility(View.GONE);
                    holder.arrow_down.setImageResource(R.drawable.ic__arrow_down);
                }
                else {
                    TransitionManager.beginDelayedTransition(holder.rules_cv,
                            new AutoTransition());
                    holder.reason.setText(yesistHomeList.get(position).getQuesReason());
                    holder.reason.setVisibility(View.VISIBLE);
                    holder.arrow_down.setImageResource(R.drawable.ic_arrow_up);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return yesistHomeList.size();
    }
    public static final class TrackDetailsViewHolder extends RecyclerView.ViewHolder {

        TextView ques,reason;
        ImageButton arrow_down;
        CardView rules_cv;

        public TrackDetailsViewHolder(@NonNull View itemView) {
            super(itemView);
            ques=itemView.findViewById(R.id.rules_track);
            reason=itemView.findViewById(R.id.rules_track_det);
            arrow_down=itemView.findViewById(R.id.arrow_down);
            rules_cv = itemView.findViewById(R.id.rules_cardview);
        }
    }
}
