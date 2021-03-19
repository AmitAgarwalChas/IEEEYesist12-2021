package com.ieeeyesist12_2021.adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.ieeeyesist12_2021.R;
import com.ieeeyesist12_2021.model.Event;
import com.ieeeyesist12_2021.model.Professional;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class TimelineAdapter extends RecyclerView.Adapter<TimelineAdapter.ViewHolder> {

    private List<Event> eventList;
    private EventClickListener listener;

    public TimelineAdapter(List<Event> eventList, EventClickListener listener) {
        this.eventList = eventList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.timeline_item, parent, false);
        return new TimelineAdapter.ViewHolder(view, listener);
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
        sdf = new SimpleDateFormat("HH.mm aa");
        String startTime = sdf.format(eventList.get(position).getDate());
        holder.startTime.setText(startTime);
        Date d = Calendar.getInstance().getTime();

        if(eventList.get(position).getEndDate().before(d)) {
            holder.join.setText("Watch");
            holder.join.setBackgroundColor(Color.parseColor("#01579B"));
        }else if(d.before(eventList.get(position).getDate())) {
            holder.startTime.setTextColor(Color.parseColor("#0091EA"));
            holder.join.setVisibility(View.GONE);
            holder.status.setText("Upcoming");
        }else {
            holder.startTime.setTextColor(Color.parseColor("#EA0000"));
            holder.status.setText("Live");
            holder.status.setBackgroundResource(R.color.red);
            holder.status.setTextColor(Color.parseColor("#EA0000"));
        }

    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

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
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            eventClickListener.onEventClick(eventList.get(getAdapterPosition()));
        }
    }

    public interface EventClickListener {
        void onEventClick(Event event);
    }
}
