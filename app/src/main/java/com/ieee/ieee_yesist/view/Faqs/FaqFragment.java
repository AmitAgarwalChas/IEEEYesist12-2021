package com.ieee.ieee_yesist.view.Faqs;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ieee.ieee_yesist.R;
import com.ieee.ieee_yesist.adapters.FaqAdapter;
import com.ieee.ieee_yesist.adapters.TrackListAdapter;
import com.ieee.ieee_yesist.model.TrackList;

import java.util.ArrayList;
import java.util.List;

public class FaqFragment extends Fragment implements FaqAdapter.OnFaqListener {

    RecyclerView trackRecycler;
    FaqAdapter faqAdapter;
    List<TrackList> trackList;
    ImageButton back;

    public FaqFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_faq, container, false);
        BottomNavigationView bottomNavigationView = getActivity().findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setVisibility(View.GONE);

        back=view.findViewById(R.id.back_button);

        back.setOnClickListener(v -> {
            Navigation.findNavController(requireView()).navigate(R.id.action_faqFragment_to_HomeFragment);
            bottomNavigationView.setVisibility(View.VISIBLE);
        });

        trackRecycler=view.findViewById(R.id.tracks_faq_rv);
        trackList = new ArrayList<>();
        trackList.add(new TrackList("Innovation Challenge",R.drawable.innovation));
        trackList.add(new TrackList("Maker Fair",R.drawable.maker_fair));
        trackList.add(new TrackList("Junior Einstein",R.drawable.jr_einstein));
        trackList.add(new TrackList("WePOWER",R.drawable.wepower));
        trackList.add(new TrackList("Special Track",R.drawable.special_track_new_bg));

        setTrackRecycler(trackList);


        return view;
    }

    private void setTrackRecycler(List<TrackList> trackList) {
        RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        trackRecycler.setLayoutManager(layoutManager);
        trackRecycler.setHasFixedSize(true);
        faqAdapter = new FaqAdapter(requireContext(),trackList,this);
        trackRecycler.setAdapter(faqAdapter);

    }

    @Override
    public void onFaqClick(int position) {
        Log.d("name","onTrackClick: clicked.");
        Bundle bundle = new Bundle();
        bundle.putString("trackName",trackList.get(position).getTrackName());
        //bundle.putInt("trackImage",trackList.get(position).getImageUrl());
        Navigation.findNavController(requireView()).navigate(R.id.action_faqFragment_to_faqDetailsFragment,bundle);

    }
}