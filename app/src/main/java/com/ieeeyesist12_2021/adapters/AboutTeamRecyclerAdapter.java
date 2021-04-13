package com.ieeeyesist12_2021.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.ieeeyesist12_2021.R;
import com.ieeeyesist12_2021.model.Professional;
import java.util.List;

public class AboutTeamRecyclerAdapter extends RecyclerView.Adapter<AboutTeamRecyclerAdapter.ViewHolder> {

    private Context context;
    private List<Professional> professionalList;
    private OnProfessionalListener onProfessionalListener;

    public AboutTeamRecyclerAdapter(Context context, List<Professional> professionalList, OnProfessionalListener onProfessionalListener) {
        this.context = context;
        this.professionalList = professionalList;
        this.onProfessionalListener = onProfessionalListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_sterring, parent, false);
        return new AboutTeamRecyclerAdapter.ViewHolder(view, onProfessionalListener);
    }

    @Override
    public void onBindViewHolder(@NonNull AboutTeamRecyclerAdapter.ViewHolder holder, int position) {
        holder.proImage.setImageResource(professionalList.get(position).getImageUrl());
        holder.proName.setText(professionalList.get(position).getName());
        holder.proRole.setText(professionalList.get(position).getRole());
    }

    @Override
    public int getItemCount() {
        return professionalList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView proImage;
        TextView proName;
        TextView proRole;
        OnProfessionalListener onProfessionalListener;

        public ViewHolder(@NonNull View itemView, OnProfessionalListener onProfessionalListener) {
            super(itemView);
            proImage = itemView.findViewById(R.id.professional_image);
            proName = itemView.findViewById(R.id.professional_name);
            proRole = itemView.findViewById(R.id.professional_role);
            this.onProfessionalListener = onProfessionalListener;
            proImage.setOnClickListener( v -> {
                    onProfessionalListener.onProfessionalClick(professionalList.get(getAdapterPosition()));
            });
        }
    }

    public interface OnProfessionalListener{
        void onProfessionalClick(Professional pro);
    }

}
