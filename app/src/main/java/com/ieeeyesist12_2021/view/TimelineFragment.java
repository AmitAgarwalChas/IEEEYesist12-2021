package com.ieeeyesist12_2021.view;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TimelineFragment extends Fragment implements TimelineAdapter.EventClickListener {

    public TimelineFragment() {
        // Required empty public constructor
    }

    private FragmentTimelineBinding binding;
    private List<Event> eventList;
    private List<Event> displayList;
    private TimelineAdapter timelineAdapter;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        eventList = new ArrayList<>();
        displayList = new ArrayList<>();
        try {
            populateList();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        binding.dateLayout.setOnClickListener(v -> {
            if(binding.calendar.getVisibility() == View.VISIBLE) {
                binding.calendar.setVisibility(View.GONE);
                binding.calendarArrow.setImageResource(R.drawable.ic__arrow_down);
            }else {
                binding.calendar.setVisibility(View.VISIBLE);
                binding.calendarArrow.setImageResource(R.drawable.ic_arrow_up);
            }
        });

        timelineAdapter = new TimelineAdapter(this);
        binding.timelineRv.setAdapter(timelineAdapter);
        setUpCalendar();
        Date currentDate = new Date();
        populateDisplayList(null, false);
    }

    private void populateDisplayList(CalendarDay date, boolean dateSelected) {
        displayList.clear();
        CalendarDay selectedDay = binding.calendar.getSelectedDate();
        if(dateSelected) {
            String sday = String.valueOf(selectedDay.getDay());
            for (int i = 0; i < eventList.size(); i++) {
                Event event = eventList.get(i);
                Date d = event.getDate();
                SimpleDateFormat sdf = new SimpleDateFormat("dd");
                String day = sdf.format(d);
                if (sday.equalsIgnoreCase(day)) {
                    displayList.add(event);
                }
            }
        }else {
            if (date != null) {
                Month m = Month.values()[date.getMonth() - 1];
                for (int i = 0; i < eventList.size(); i++) {
                    Event event = eventList.get(i);
                    Date d = event.getDate();
                    SimpleDateFormat sdf = new SimpleDateFormat("MMMM");
                    String month = sdf.format(d);
                    if (m.toString().equalsIgnoreCase(month)) {
                        displayList.add(event);
                    }
                }
            } else {
                Date currentDate = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("MMMM");
                String currentMonth = sdf.format(currentDate);
                for (int i = 0; i < eventList.size(); i++) {
                    Event event = eventList.get(i);
                    Date d = event.getDate();
                    String month = sdf.format(d);
                    if (currentMonth.equalsIgnoreCase(month)) {
                        displayList.add(event);
                    }
                }
            }
        }
        timelineAdapter.submitList(displayList);
    }

    private void setUpCalendar() {
        binding.calendar.setOnMonthChangedListener((widget, date) -> {
            Month m = Month.values()[date.getMonth()-1];
            String month = m.toString();
            binding.tvMonth.setText(month);
            populateDisplayList(date, false);
        });

        binding.calendar.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
                populateDisplayList(date, true);
            }
        });
    }


    private void populateList() throws ParseException {
        String inputStringStart = "11-01-2021 10:00 AM";
        String inputStringEnd = "11-01-2021 11:00 AM";
        Date date = new SimpleDateFormat("dd-MM-yyyy HH:mm aa").parse(inputStringStart);
        Date endDate = new SimpleDateFormat("dd-MM-yyyy HH:mm aa").parse(inputStringEnd);
        
        eventList.add(new Event("Introductory Meeting", getString(R.string.random_text),
                "Speaker1", "Volunteer", "eventurl",
                R.drawable.ic_male, date, endDate));

        inputStringEnd = "22-03-2021 06:00 PM";
        endDate = new SimpleDateFormat("dd-MM-yyyy HH:mm aa").parse(inputStringEnd);
        eventList.add(new Event("WePower Meeting", getString(R.string.random_text),
                "Speaker1", "Volunteer", "eventurl",
                R.drawable.ic_male, new Date(), endDate));

        inputStringStart = "27-03-2021 05:00 PM";
        inputStringEnd = "27-03-2021 07:00 PM";
        date = new SimpleDateFormat("dd-MM-yyyy HH:mm aa").parse(inputStringStart);
        endDate = new SimpleDateFormat("dd-MM-yyyy HH:mm aa").parse(inputStringEnd);
        eventList.add(new Event("MakerFair Meeting", getString(R.string.random_text),
                "Speaker1", "Volunteer", "eventurl",
                R.drawable.ic_male, date, endDate));


        inputStringStart = "25-04-2021 02:00 AM";
        inputStringEnd = "25-04-2021 03:00 PM";
        date = new SimpleDateFormat("dd-MM-yyyy HH:mm aa").parse(inputStringStart);
        endDate = new SimpleDateFormat("dd-MM-yyyy HH:mm aa").parse(inputStringEnd);
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