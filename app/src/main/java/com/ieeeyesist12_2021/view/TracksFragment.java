package com.ieeeyesist12_2021.view;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ieeeyesist12_2021.R;
import com.ieeeyesist12_2021.adapters.TrackListAdapter;
import com.ieeeyesist12_2021.model.TrackList;

import java.util.ArrayList;
import java.util.List;

public class TracksFragment extends Fragment implements TrackListAdapter.OnTrackListener {
    RecyclerView trackRecycler;
    TrackListAdapter trackListAdapter;
    List<TrackList> trackList;
    ImageView imgProfile;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tracks, container, false);
        trackRecycler=view.findViewById(R.id.tracks_recycler);
        trackList = new ArrayList<>();
        trackList.add(new TrackList("Volleyball",R.drawable.volleball));
        trackList.add(new TrackList("Cricket",R.drawable.cricket));
        trackList.add(new TrackList("Basketball",R.drawable.basketball));
        trackList.add(new TrackList("Table Tennis",R.drawable.table_tennis));
        trackList.add(new TrackList("Football",R.drawable.football));

        setTrackRecycler(trackList);

        imgProfile = view.findViewById(R.id.imageProfile);
        imgProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment profileFragment = new ProfileFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragNavHost,profileFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        return view;
    }
    private void setTrackRecycler(List<TrackList> trackList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,false);
        trackRecycler.setLayoutManager(layoutManager);
        trackListAdapter = new TrackListAdapter(getContext(),trackList,this);
        trackRecycler.setAdapter(trackListAdapter);

    }

    @Override
    public void onTrackClick(int position) {
        Log.d("name","onTrackClick: clicked.");
        Bundle bundle = new Bundle();
        bundle.putString("trackName",trackList.get(position).getTrackName());
        bundle.putInt("trackImage",trackList.get(position).getImageUrl());
        Fragment trackDetailsFragment = new TrackDetailsFragment();
        trackDetailsFragment.setArguments(bundle);
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragNavHost,trackDetailsFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}