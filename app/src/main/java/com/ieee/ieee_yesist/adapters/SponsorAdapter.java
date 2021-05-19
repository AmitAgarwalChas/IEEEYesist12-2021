package com.ieee.ieee_yesist.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;
import com.bumptech.glide.Glide;
import com.ieee.ieee_yesist.R;
import com.ieee.ieee_yesist.model.Sponsor;
import java.util.List;

public class SponsorAdapter extends RecyclerView.Adapter<SponsorAdapter.ViewHolder> {

    private Context context;
    private final List<Sponsor> sponsorList;

    public SponsorAdapter(List<Sponsor> sponsorList) {
        this.sponsorList = sponsorList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_sponsor, parent, false);
        return new SponsorAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SponsorAdapter.ViewHolder holder, int position) {
        CircularProgressDrawable cpd = new CircularProgressDrawable(context);
        cpd.setStrokeWidth(5f);
        cpd.setCenterRadius(30f);
        cpd.setColorSchemeColors(R.color.colorPrimary);
        cpd.start();
        Glide.with(context)
             .load(sponsorList.get(position).getImgUrl())
             .placeholder(cpd)
             .into(holder.sponsorImg);

        holder.sponsorImg.setImageBitmap(null);
        holder.sponsorImg.setOnClickListener(v -> {
            context.startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse(sponsorList.get(position).getWebUrl())));
        });
    }

    @Override
    public int getItemCount() {
        return sponsorList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView sponsorImg;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            sponsorImg = itemView.findViewById(R.id.sponsor_img);
        }
    }

}
