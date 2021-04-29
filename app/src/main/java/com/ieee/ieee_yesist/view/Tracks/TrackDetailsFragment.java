package com.ieee.ieee_yesist.view.Tracks;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;

import com.ieee.ieee_yesist.R;

public class TrackDetailsFragment extends Fragment {

    ImageView imgBack,imgTrack;
    TextView btnRegister,btnPilotRegister,trackName,trackInfo,rules_det,abstract_det;
    CardView rules_cv, abstract_cv;
    ImageButton arrow_rules,arrow_abs;

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
        rules_cv=view.findViewById(R.id.rules_cardview);
        abstract_cv=view.findViewById(R.id.abstract_cardview);
        rules_det=view.findViewById(R.id.rules_track_det);
        abstract_det=view.findViewById(R.id.abstract_sel_det);
        arrow_rules=view.findViewById(R.id.arrow_down);
        arrow_abs=view.findViewById(R.id.arrow_d);

        Bundle bundle = this.getArguments();
        assert bundle != null;
        String track = bundle.getString("trackName");
        int imgUrl = bundle.getInt("trackImage");

        trackName.setText(track);
        imgTrack.setImageResource(imgUrl);


        if(track.equals("Innovation Challenge")){
            trackInfo.setText(R.string.innovation);
            cardviewExpand(R.string.innov_abstract,R.string.innov_rules);}
        else if(track.equals("Maker Fair")){
            btnRegister.setVisibility(View.VISIBLE);
            trackInfo.setText(R.string.maker_fair);
            cardviewExpand(R.string.maker_abstract,R.string.maker_rules);}
        else if(track.equals("Junior Einstein")){
            trackInfo.setText(R.string.einstein);
            cardviewExpand(R.string.einstein_abstract,R.string.einstein_rules);}
        else if(track.equals("WePOWER")){
            btnRegister.setVisibility(View.VISIBLE);
            trackInfo.setText(R.string.wepower);
            cardviewExpand(R.string.wepower_abstract,R.string.wepower_rules);}
        else if(track.equals("Special Track")){
            btnRegister.setVisibility(View.VISIBLE);
            //expandable card view
            trackInfo.setText(R.string.special);
            cardviewExpand(R.string.special_abstract,R.string.special_rules);}

        /*imgBack.setOnClickListener(v -> {
            Fragment trackinfo = new TracksFragment();
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragNavHost,trackinfo);
            transaction.addToBackStack(null);
            transaction.commit();
        });*/
        imgBack.setOnClickListener( v ->  {
            Navigation.findNavController(requireView()).navigateUp();
        });
        btnRegister.setOnClickListener(v -> {
            String url = "https://portal.ieeeyesist12.org/";
            Uri uri = Uri.parse(url);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });
        btnPilotRegister.setOnClickListener(v -> {
            String url = "https://portal.ieeeyesist12.org/";
            Uri uri = Uri.parse(url);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });
        return view;
    }


    private void cardviewExpand(Integer abs, Integer rules) {
        abstract_cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(abstract_det.getVisibility()==View.VISIBLE){
                    TransitionManager.beginDelayedTransition(abstract_cv,
                            new AutoTransition());
                    abstract_det.setVisibility(View.GONE);
                    arrow_abs.setImageResource(R.drawable.ic__arrow_down);
                }
                else {
                    TransitionManager.beginDelayedTransition(abstract_cv,
                            new AutoTransition());
                    abstract_det.setText(abs);
                    abstract_det.setVisibility(View.VISIBLE);
                    arrow_abs.setImageResource(R.drawable.ic_arrow_up);
                }
            }
        });
        rules_cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rules_det.getVisibility()==View.VISIBLE){
                    TransitionManager.beginDelayedTransition(rules_cv,
                            new AutoTransition());
                    rules_det.setVisibility(View.GONE);
                    arrow_rules.setImageResource(R.drawable.ic__arrow_down);
                }
                else {
                    TransitionManager.beginDelayedTransition(rules_cv,
                            new AutoTransition());
                    rules_det.setText(rules);
                    rules_det.setVisibility(View.VISIBLE);
                    arrow_rules.setImageResource(R.drawable.ic_arrow_up);
                }
            }
        });
        arrow_abs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(abstract_det.getVisibility()==View.VISIBLE){
                    TransitionManager.beginDelayedTransition(abstract_cv,
                            new AutoTransition());
                    abstract_det.setVisibility(View.GONE);
                    arrow_abs.setImageResource(R.drawable.ic__arrow_down);
                }
                else {
                    TransitionManager.beginDelayedTransition(abstract_cv,
                            new AutoTransition());
                    abstract_det.setText(abs);
                    abstract_det.setVisibility(View.VISIBLE);
                    arrow_abs.setImageResource(R.drawable.ic_arrow_up);
                }
            }
        });
        arrow_rules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rules_det.getVisibility()==View.VISIBLE){
                    TransitionManager.beginDelayedTransition(rules_cv,
                            new AutoTransition());
                    rules_det.setVisibility(View.GONE);
                    arrow_rules.setImageResource(R.drawable.ic__arrow_down);
                }
                else {
                    TransitionManager.beginDelayedTransition(rules_cv,
                            new AutoTransition());
                    rules_det.setText(rules);
                    rules_det.setVisibility(View.VISIBLE);
                    arrow_rules.setImageResource(R.drawable.ic_arrow_up);
                }
            }
        });
    }
}