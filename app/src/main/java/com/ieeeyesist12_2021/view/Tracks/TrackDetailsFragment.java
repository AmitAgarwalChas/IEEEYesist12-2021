package com.ieeeyesist12_2021.view.Tracks;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.ieeeyesist12_2021.R;

public class TrackDetailsFragment extends Fragment {

    ImageView imgBack,imgTrack;
    TextView btnRegister,btnPilotRegister,trackName,trackInfo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_track_details, container, false);
        imgBack=view.findViewById(R.id.imageBack);
        btnRegister=view.findViewById(R.id.btnRegister);
        btnPilotRegister=view.findViewById(R.id.btnPilotRegister);
        imgTrack=view.findViewById(R.id.imageTrack);
        trackName=view.findViewById(R.id.trackName);
        trackInfo=view.findViewById(R.id.trackInfo);
        trackInfo.setMovementMethod(new ScrollingMovementMethod());

        Bundle bundle = this.getArguments();
        assert bundle != null;
        String track = bundle.getString("trackName");
        int imgUrl = bundle.getInt("trackImage");

        trackName.setText(track);
        imgTrack.setImageResource(imgUrl);

        imgBack.setOnClickListener(v -> {
            Fragment trackinfo = new TracksFragment();
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragNavHost,trackinfo);
            transaction.addToBackStack(null);
            transaction.commit();
        });
        btnRegister.setOnClickListener(v -> {
            String url = "https://www.ieeecsvit.com/";
            Uri uri = Uri.parse(url);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });
        btnPilotRegister.setOnClickListener(v -> {
            String url = "https://www.ieeecsvit.com/";
            Uri uri = Uri.parse(url);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });
        return view;
    }
}