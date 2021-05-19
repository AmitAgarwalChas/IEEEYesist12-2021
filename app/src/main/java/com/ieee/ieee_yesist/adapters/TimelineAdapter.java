package com.ieee.ieee_yesist.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import com.ieee.ieee_yesist.R;
import com.ieee.ieee_yesist.model.Event;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class TimelineAdapter extends RecyclerView.Adapter<TimelineAdapter.ViewHolder> {

    private List<Event> eventList;
    private EventClickListener listener;
    private Context context;

    public TimelineAdapter(EventClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.timeline_item, parent, false);
        return new TimelineAdapter.ViewHolder(view, listener);
    }

    public void submitList(List<Event> eventList) {
        this.eventList = eventList;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull TimelineAdapter.ViewHolder holder, int position) {
        holder.eventName.setText(eventList.get(position).getEventName());
        SimpleDateFormat sdf = new SimpleDateFormat("dd");
        String date = sdf.format(eventList.get(position).getDate());
        holder.date.setText(date);
        sdf = new SimpleDateFormat("EE");
        String day = sdf.format(eventList.get(position).getDate());
        holder.day.setText(day);
        sdf = new SimpleDateFormat("hh:mm a");
        String startTime = sdf.format(eventList.get(position).getDate());
        holder.startTime.setText(startTime);

        Date d = Calendar.getInstance().getTime();
        Date eventDate = eventList.get(position).getDate();
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        int curDay = cal.get(Calendar.DATE);
        cal.setTime(eventDate);
        int eventDay = cal.get(Calendar.DATE);
        long diff = eventDate.getTime() - d.getTime();
        long diffDays = (diff / (1000 * 60 * 60 * 24)) % 365;
        String timeLeft = "";
        if(diffDays == 0) {
            if(curDay == eventDay) {
                holder.date.setTextColor(Color.parseColor("#2BB884"));
                holder.day.setTextColor(Color.parseColor("#2BB884"));
            }else {
                holder.date.setTextColor(Color.parseColor("#676969"));
                holder.day.setTextColor(Color.parseColor("#676969"));
            }
            long diffMinutes = (diff / (1000 * 60)) % 60;
            long diffHours = (diff / (1000 * 60 * 60)) % 24;
            timeLeft = diffHours + "h " + diffMinutes + "min";
            holder.status.setText(timeLeft);
        }else {
            holder.date.setTextColor(Color.parseColor("#676969"));
            holder.day.setTextColor(Color.parseColor("#676969"));
        }

        if(eventList.get(position).getEndDate().before(d)) {
            holder.startTime.setTextColor(Color.parseColor("#01579B"));
            holder.join.setVisibility(View.VISIBLE);
            holder.status.setBackgroundResource(R.drawable.ic_completed_tv);
            holder.join.setVisibility(View.VISIBLE);
            holder.status.setText("Completed");
            holder.join.setText("Watch");
            holder.join.setBackgroundColor(Color.parseColor("#01579B"));
            holder.join.setOnClickListener( v ->
                    context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(eventList.get(position).getEventUrl())))
            );
        }else if(d.before(eventList.get(position).getDate())) {
            holder.startTime.setTextColor(Color.parseColor("#0091EA"));
            holder.join.setVisibility(View.VISIBLE);
            holder.join.setText("Register");
            holder.join.setBackgroundColor(Color.parseColor("#01579B"));
            holder.join.setOnClickListener( v ->
                    context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(eventList.get(position).getRegisterUrl())))
            );
            holder.status.setBackgroundResource(R.drawable.ic_upcoming_tv);
            holder.status.setText("Upcoming");
            if(diffDays == 0) {
                holder.status.setText(timeLeft);
            }
        }else {
            holder.startTime.setTextColor(Color.parseColor("#EA0000"));
            holder.join.setVisibility(View.VISIBLE);
            holder.join.setText("Join");
            holder.join.setBackgroundColor(Color.parseColor("#EA0000"));
            holder.join.setOnClickListener( v ->
                    context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(eventList.get(position).getEventUrl())))
            );
            holder.status.setBackgroundResource(R.drawable.ic_live_tv);
            holder.status.setText("Live");
            holder.status.setTextColor(Color.parseColor("#EA0000"));
        }

    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView day, date, startTime, eventName, status;
        MaterialButton join;
        Button about;
        EventClickListener eventClickListener;

        public ViewHolder(@NonNull View itemView, EventClickListener eventClickListener) {
            super(itemView);
            date = itemView.findViewById(R.id.date);
            day = itemView.findViewById(R.id.day);
            startTime = itemView.findViewById(R.id.start_time);
            status = itemView.findViewById(R.id.status);
            eventName = itemView.findViewById(R.id.event_title);
            join = itemView.findViewById(R.id.join);
            about = itemView.findViewById(R.id.about_event);
            this.eventClickListener = eventClickListener;
            about.setOnClickListener( v ->
                eventClickListener.onEventClick(eventList.get(getAdapterPosition()))
            );
        }

    }

    public interface EventClickListener {
        void onEventClick(Event event);
    }
}
