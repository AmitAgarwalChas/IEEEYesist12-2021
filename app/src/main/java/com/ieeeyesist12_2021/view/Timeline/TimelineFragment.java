package com.ieeeyesist12_2021.view.Timeline;

import android.graphics.Color;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MotionEvent;
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

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

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

        Calendar cal = Calendar.getInstance();
        String timezone = cal.getTimeZone().getDisplayName();
        binding.timezone.setText("Timezone : " + timezone);

        binding.calendarLayout.setOnClickListener(v -> {
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
                String m = new DateFormatSymbols().getMonths()[date.getMonth() - 1];
                for (int i = 0; i < eventList.size(); i++) {
                    Event event = eventList.get(i);
                    Date d = event.getDate();
                    SimpleDateFormat sdf = new SimpleDateFormat("MMMM");
                    String month = sdf.format(d);
                    if (m.equalsIgnoreCase(month)) {
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

        binding.timelineRv.addOnItemTouchListener(new RecyclerView.SimpleOnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                if(binding.calendar.getVisibility() == View.VISIBLE)
                    return true;
                return false;
            }
        });

        binding.calendar.setOnMonthChangedListener((widget, date) -> {
            String month = new DateFormatSymbols().getMonths()[date.getMonth()-1];
            binding.tvMonth.setText(month);
            populateDisplayList(date, false);
        });

        binding.calendar.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
                binding.calendar.setVisibility(View.GONE);
                binding.calendarArrow.setImageResource(R.drawable.ic__arrow_down);
                populateDisplayList(date, true);
            }
        });

        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int cDay = cal.get(Calendar.DATE);
        ArrayList<CalendarDay> currentList = new ArrayList<>();
        ArrayList<CalendarDay> upcomingList = new ArrayList<>();
        ArrayList<CalendarDay> completedList = new ArrayList<>();
        for (int i = 0; i < eventList.size(); i++) {
            Event event = eventList.get(i);
            Date d = event.getDate();
            cal.setTime(d);
            int eDay = cal.get(Calendar.DATE);
            int eMonth = cal.get(Calendar.MONTH);
            int eYear = cal.get(Calendar.YEAR);
            if(d.before(date) && eDay < cDay) {
                completedList.add(CalendarDay.from(eYear, eMonth+1, eDay));
            }else if(d.after(date) && eDay > cDay) {
                upcomingList.add(CalendarDay.from(eYear, eMonth+1, eDay));
            }else {
                currentList.add(CalendarDay.from(eYear, eMonth+1, eDay));
            }
        }
        if(currentList.size() > 0) {
            binding.calendar.addDecorator(new EventDecorator(Color.parseColor("#2bb884"), currentList));
        }
        if(completedList.size() > 0) {
            binding.calendar.addDecorator(new EventDecorator(Color.parseColor("#01579B"), completedList));
        }
        if(upcomingList.size() > 0) {
            binding.calendar.addDecorator(new EventDecorator(Color.parseColor("#0091EA"), upcomingList));
        }

    }


    private void populateList() throws ParseException {

        String inputStringStart = "11-02-2021 10:00 AM";
        String inputStringEnd = "11-02-2021 11:00 AM";
        Date date = new SimpleDateFormat("dd-MM-yyyy hh:mm a").parse(inputStringStart);
        Date endDate = new SimpleDateFormat("dd-MM-yyyy hh:mm a").parse(inputStringEnd);
        
        eventList.add(new Event("Introductory Meeting", getString(R.string.random_text),
                "Speaker1", "Volunteer", "eventurl",
                R.drawable.ic_male, date, endDate));

        inputStringStart = "22-03-2021 08:00 PM";
        inputStringEnd = "22-03-2021 09:30 PM";
        date = new SimpleDateFormat("dd-MM-yyyy hh:mm a").parse(inputStringStart);
        endDate = new SimpleDateFormat("dd-MM-yyyy hh:mm a").parse(inputStringEnd);
        eventList.add(new Event("WePower Meeting", getString(R.string.random_text),
                "Speaker1", "Volunteer", "eventurl",
                R.drawable.ic_male, date, endDate));

        inputStringStart = "26-03-2021 04:00 AM";
        inputStringEnd = "26-03-2021 05:00 AM";
        date = new SimpleDateFormat("dd-MM-yyyy hh:mm a").parse(inputStringStart);
        endDate = new SimpleDateFormat("dd-MM-yyyy hh:mm a").parse(inputStringEnd);
        eventList.add(new Event("WePower Meeting", getString(R.string.random_text),
                "Speaker1", "Volunteer", "eventurl",
                R.drawable.ic_male, date, endDate));

        inputStringStart = "27-03-2021 05:00 PM";
        inputStringEnd = "27-03-2021 07:00 PM";
        date = new SimpleDateFormat("dd-MM-yyyy hh:mm a").parse(inputStringStart);
        endDate = new SimpleDateFormat("dd-MM-yyyy hh:mm a").parse(inputStringEnd);
        eventList.add(new Event("MakerFair Meeting", getString(R.string.random_text),
                "Speaker1", "Volunteer", "eventurl",
                R.drawable.ic_male, date, endDate));


        inputStringStart = "25-04-2021 02:00 AM";
        inputStringEnd = "25-04-2021 03:00 PM";
        date = new SimpleDateFormat("dd-MM-yyyy hh:mm a").parse(inputStringStart);
        endDate = new SimpleDateFormat("dd-MM-yyyy hh:mm a").parse(inputStringEnd);
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