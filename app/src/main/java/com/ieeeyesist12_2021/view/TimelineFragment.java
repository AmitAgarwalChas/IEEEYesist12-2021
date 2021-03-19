package com.ieeeyesist12_2021.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ieeeyesist12_2021.R;
import com.ieeeyesist12_2021.adapters.TimelineAdapter;
import com.ieeeyesist12_2021.databinding.FragmentTimelineBinding;
import com.ieeeyesist12_2021.model.Event;
import com.ieeeyesist12_2021.model.Professional;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TimelineFragment extends Fragment implements TimelineAdapter.EventClickListener {

    public TimelineFragment() {
        // Required empty public constructor
    }

    private FragmentTimelineBinding binding;
    private List<Event> eventList;
    private TimelineAdapter timelineAdapter;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        eventList = new ArrayList<>();
        try {
            populateList();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        timelineAdapter = new TimelineAdapter(eventList, this);
        binding.timelineRv.setAdapter(timelineAdapter);
    }

    private void populateList() throws ParseException {
        String inputString = "11-01-2021 10:00 AM";
        Date date = new SimpleDateFormat("dd-MM-yyyy HH:mm aa").parse(inputString);

        eventList.add(new Event("Introductory Meeting", getString(R.string.random_text),
                "Speaker1", "Volunteer", "eventurl",
                R.drawable.ic_male, date, date));

        inputString = "19-03-2021 05:00 AM";
        date = new SimpleDateFormat("dd-MM-yyyy HH:mm aa").parse(inputString);
        eventList.add(new Event("WePower Meeting", getString(R.string.random_text),
                "Speaker1", "Volunteer", "eventurl",
                R.drawable.ic_male, new Date(), date));

        inputString = "19-03-2021 05:00 AM";
        Date endDate = new SimpleDateFormat("dd-MM-yyyy HH:mm aa").parse(inputString);
        eventList.add(new Event("MakerFair Meeting", getString(R.string.random_text),
                "Speaker1", "Volunteer", "eventurl",
                R.drawable.ic_male, date, endDate));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentTimelineBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onEventClick(Professional pro) {

    }
}