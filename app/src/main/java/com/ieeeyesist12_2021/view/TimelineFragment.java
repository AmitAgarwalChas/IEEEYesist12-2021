package com.ieeeyesist12_2021.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
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
    public void onEventClick(Event event) {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext(), R.style.bottomSheetDialogTheme);
        View bottomSheetView = LayoutInflater.from(requireContext())
                .inflate(R.layout.bottom_sheet, bottomSheetDialog.findViewById(R.id.constraint_layout));

        TextView eventName = bottomSheetView.findViewById(R.id.event_name);
        TextView speakerName = bottomSheetView.findViewById(R.id.speaker_name);
        TextView qual = bottomSheetView.findViewById(R.id.speaker_qualification);
        TextView about = bottomSheetView.findViewById(R.id.about_content);
        TextView eventDate = bottomSheetView.findViewById(R.id.event_date);
        TextView eventTime = bottomSheetView.findViewById(R.id.event_time);
        ImageView speakerImage = bottomSheetView.findViewById(R.id.speaker_image);

        eventName.setText(event.getEventName());
        speakerName.setText(event.getSpeakerName());
        qual.setText(event.getSpeakerQualification());
        about.setText(event.getAboutEvent());
        speakerImage.setImageResource(event.getImageurl());

        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        String date = sdf.format(event.getDate());
        eventDate.setText(date);

        sdf = new SimpleDateFormat("hh:mm");
        String time = sdf.format(event.getDate());
        time += " - ";
        sdf = new SimpleDateFormat("hh:mm aa");
        time += sdf.format(event.getEndDate());
        eventTime.setText(time);

        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }
}