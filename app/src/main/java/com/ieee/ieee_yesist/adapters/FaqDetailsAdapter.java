package com.ieee.ieee_yesist.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;

import com.ieee.ieee_yesist.R;
import com.ieee.ieee_yesist.model.YesistHome;

import java.util.List;

public class FaqDetailsAdapter extends RecyclerView.Adapter<FaqDetailsAdapter.FaqDetailsViewHolder> {

    List<YesistHome> yesistHomeList;
    Context context;

    public FaqDetailsAdapter(List<YesistHome> yesistHomeList, Context context) {
        this.yesistHomeList = yesistHomeList;
        this.context = context;
    }

    @NonNull
    @Override
    public FaqDetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.faq_det_rv_item, parent, false);
        return new FaqDetailsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FaqDetailsAdapter.FaqDetailsViewHolder holder, int position) {

        holder.ques.setText(yesistHomeList.get(position).getQuesName());
        //holder.reason.setText(yesistHomeList.get(position).getQuesReason());

        holder.arrow_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.reason.getVisibility()==View.VISIBLE){
                    TransitionManager.beginDelayedTransition(holder.faq_cv,
                            new AutoTransition());
                    holder.reason.setVisibility(View.GONE);
                    holder.faq_ll.setBackgroundColor(ContextCompat.getColor(context,R.color.white));
                    holder.arrow_down.setImageResource(R.drawable.ic__arrow_down);
                }
                else {
                    TransitionManager.beginDelayedTransition(holder.faq_cv,
                            new AutoTransition());
                    holder.reason.setText(yesistHomeList.get(position).getQuesReason());
                    holder.faq_ll.setBackgroundColor(ContextCompat.getColor(context,R.color.track_item_bg));
                    holder.reason.setVisibility(View.VISIBLE);
                    holder.arrow_down.setImageResource(R.drawable.ic_arrow_up);
                }
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.reason.getVisibility()==View.VISIBLE){
                    TransitionManager.beginDelayedTransition(holder.faq_cv,
                            new AutoTransition());
                    holder.reason.setVisibility(View.GONE);
                    holder.faq_ll.setBackgroundColor(ContextCompat.getColor(context,R.color.white));
                    holder.arrow_down.setImageResource(R.drawable.ic__arrow_down);
                }
                else {
                    TransitionManager.beginDelayedTransition(holder.faq_cv,
                            new AutoTransition());
                    holder.reason.setText(yesistHomeList.get(position).getQuesReason());
                    holder.faq_ll.setBackgroundColor(ContextCompat.getColor(context,R.color.track_item_bg));
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

    public static final class FaqDetailsViewHolder extends RecyclerView.ViewHolder {

        TextView ques,reason;
        ImageButton arrow_down;
        CardView faq_cv;
        LinearLayout faq_ll;

        public FaqDetailsViewHolder(@NonNull View itemView) {
            super(itemView);
            ques=itemView.findViewById(R.id.faq_ques);
            reason=itemView.findViewById(R.id.faq_track_det);
            arrow_down=itemView.findViewById(R.id.arrow_down);
            faq_cv = itemView.findViewById(R.id.faq_cardview);
            faq_ll = itemView.findViewById(R.id.faq_linear_layout);
        }
    }
}
