package com.ieeeyesist12_2021.view.Tracks;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
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
        trackList.add(new TrackList("Innovation Challenge",R.drawable.innovation));
        trackList.add(new TrackList("Maker Fair",R.drawable.maker_fair));
        trackList.add(new TrackList("Junior Einstein",R.drawable.jr_einstein));
        trackList.add(new TrackList("WePOWER",R.drawable.wepower));
        trackList.add(new TrackList("Special Track",R.drawable.special_tracks));

        setTrackRecycler(trackList);

        imgProfile = view.findViewById(R.id.imageProfile);
        imgProfile.setOnClickListener( v -> {
            Navigation.findNavController(requireView()).navigate(R.id.action_tracksFragment_to_profileFragment);
        });

        return view;
    }
    private void setTrackRecycler(List<TrackList> trackList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,false);
        trackRecycler.setLayoutManager(layoutManager);
        trackListAdapter = new TrackListAdapter(requireContext(),trackList,this);
        trackRecycler.setAdapter(trackListAdapter);

    }

    @Override
    public void onTrackClick(int position) {
        Log.d("name","onTrackClick: clicked.");
        Bundle bundle = new Bundle();
        bundle.putString("trackName",trackList.get(position).getTrackName());
        bundle.putInt("trackImage",trackList.get(position).getImageUrl());
        Navigation.findNavController(requireView()).navigate(R.id.action_tracksFragment_to_trackDetailsFragment,bundle);
    }
}