package com.ieee.ieee_yesist.view.Tracks;

import android.content.Intent;
import android.graphics.text.LineBreaker;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.ieee.ieee_yesist.R;
import com.ieee.ieee_yesist.databinding.ContentScrollingBinding;
import com.ieee.ieee_yesist.databinding.FragmentTrackDetailsBinding;

public class TrackDetailsFragment extends Fragment {

    ImageView imgTrack;
    TextView btnRegister,btnPilotRegister,trackInfo,rules_det,abstract_det;
    CardView rules_cv, abstract_cv;
    ImageButton arrow_rules,arrow_abs;
    private FragmentTrackDetailsBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentTrackDetailsBinding.inflate(getLayoutInflater());
        ContentScrollingBinding view = binding.includedLayoutTracks;
        btnRegister = view.btnRegister;
        btnPilotRegister=view.btnPilotRegister;
        imgTrack=binding.imageTrack;
        trackInfo=view.trackInfo;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            trackInfo.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
        }
        rules_cv=view.rulesCardview;
        abstract_cv=view.abstractCardview;
        rules_det=view.rulesTrackDet;
        abstract_det=view.abstractSelDet;
        arrow_rules=view.arrowDown;
        arrow_abs=view.arrowD;

        Toolbar toolbar = binding.toolbar;
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ActionBar actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(ScrollingActivity.this,"Back pressed",Toast.LENGTH_SHORT).show();
                Navigation.findNavController(requireView()).navigateUp();
            }
        });

        Bundle bundle = this.getArguments();
        assert bundle != null;
        String track = bundle.getString("trackName");
        int imgUrl = bundle.getInt("trackImage");

        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(track);
        toolBarLayout.setExpandedTitleMarginBottom(40);
        toolBarLayout.setExpandedTitleMarginStart(60);
        toolBarLayout.setExpandedTitleTextAppearance(R.style.ExpandedAppBar);
        toolBarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppBar);



        //trackName.setText(track);
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
        /*imgBack.setOnClickListener( v ->  {
            Navigation.findNavController(requireView()).navigateUp();
        });*/
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
        return binding.getRoot();
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