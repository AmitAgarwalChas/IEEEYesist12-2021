package com.ieeeyesist12_2021.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;

import com.ieeeyesist12_2021.R;
import com.ieeeyesist12_2021.model.YesistHome;

import java.util.List;

public class YesistHomeAdapter extends RecyclerView.Adapter<YesistHomeAdapter.YesistHomeViewHolder> {

    Context context;
    List<YesistHome> yesistHomeList;

    public YesistHomeAdapter(Context context, List<YesistHome> yesistHomeList) {
        this.context = context;
        this.yesistHomeList = yesistHomeList;
    }

    @NonNull
    @Override
    public YesistHomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.yesist_join_item, parent, false);
        return new YesistHomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull YesistHomeViewHolder holder, int position) {
        holder.ques.setText(yesistHomeList.get(position).getQuesName());
        //holder.reason.setText(yesistHomeList.get(position).getQuesReason());

        holder.arrow_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.reason.getVisibility()==View.VISIBLE){
                    TransitionManager.beginDelayedTransition(holder.yesist_cv,
                            new AutoTransition());
                    holder.reason.setVisibility(View.GONE);
                    holder.arrow_down.setImageResource(R.drawable.ic__arrow_down);
                }
                else {
                    TransitionManager.beginDelayedTransition(holder.yesist_cv,
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
                    TransitionManager.beginDelayedTransition(holder.yesist_cv,
                            new AutoTransition());
                    holder.reason.setVisibility(View.GONE);
                    holder.arrow_down.setImageResource(R.drawable.ic__arrow_down);
                }
                else {
                    TransitionManager.beginDelayedTransition(holder.yesist_cv,
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

    public static final class YesistHomeViewHolder extends RecyclerView.ViewHolder {

        TextView ques,reason;
        ImageButton arrow_down;
        CardView yesist_cv;

        public YesistHomeViewHolder(@NonNull View itemView) {
            super(itemView);
            ques=itemView.findViewById(R.id.yesist_ques);
            reason=itemView.findViewById(R.id.yesist_ques_det);
            arrow_down=itemView.findViewById(R.id.arrow_down);
            yesist_cv=itemView.findViewById(R.id.yesist_cardview);
        }
    }
}
