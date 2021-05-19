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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.ieee.ieee_yesist.R;
import com.ieee.ieee_yesist.adapters.TrackDetailsAdapter;
import com.ieee.ieee_yesist.adapters.YesistHomeAdapter;
import com.ieee.ieee_yesist.databinding.ContentScrollingBinding;
import com.ieee.ieee_yesist.databinding.FragmentTrackDetailsBinding;
import com.ieee.ieee_yesist.model.YesistHome;

import java.util.ArrayList;
import java.util.List;

public class TrackDetailsFragment extends Fragment {

    ImageView imgTrack;
    TextView btnRegister,btnPilotRegister,trackInfo,rules_det,abstract_det;
    CardView rules_cv, abstract_cv;
    ImageButton arrow_rules,arrow_abs;
    private FragmentTrackDetailsBinding binding;
    RecyclerView key_dates_rv, rules_rv;
    TrackDetailsAdapter trackKeyAdapter,trackDetailsAdapter;
    List<YesistHome> datesList,rulesList;

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
        /*
        rules_cv=view.rulesCardview;
        abstract_cv=view.abstractCardview;
        rules_det=view.rulesTrackDet;
        abstract_det=view.abstractSelDet;
        arrow_rules=view.arrowDown;
        arrow_abs=view.arrowD;
        */

        key_dates_rv = view.tracksKeyDatesRv;
        rules_rv=view.tracksRulesRv;

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
            callPilot("https://ieeeyesist12.org/ic-pilot-registration/");

            //datesList.clear();
            datesList = new ArrayList<>();
            datesList.add(new YesistHome(R.string.dates_pilot,R.string.innov_dates_pilot));
            datesList.add(new YesistHome(R.string.direct_entry,R.string.innov_direct_entry));
            datesList.add(new YesistHome(R.string.reg_fee,R.string.innov_reg_fee));
            datesList.add(new YesistHome(R.string.awards,R.string.innov_awards));
            setTracksKeyRecycler(datesList);

            //rulesList.clear();
            rulesList = new ArrayList<>();
            rulesList.add(new YesistHome(R.string.rules_tracks,R.string.innov_rules));
            rulesList.add(new YesistHome(R.string.abs_sel_proc,R.string.innov_abstract));
            setTracksRulesRecycler(rulesList);
        }
        else if(track.equals("Maker Fair")){
            btnRegister.setVisibility(View.VISIBLE);
            trackInfo.setText(R.string.maker_fair);
            //datesList.clear();
            datesList = new ArrayList<>();
            datesList.add(new YesistHome(R.string.imp_dates,R.string.maker_dates_pilot));
            datesList.add(new YesistHome(R.string.reg_fee,R.string.maker_reg_fee));
            datesList.add(new YesistHome(R.string.awards,R.string.maker_awards));
            setTracksKeyRecycler(datesList);

            //rulesList.clear();
            rulesList = new ArrayList<>();
            rulesList.add(new YesistHome(R.string.rules_tracks,R.string.maker_rules));
            rulesList.add(new YesistHome(R.string.abs_sel_proc,R.string.maker_abstract));
            setTracksRulesRecycler(rulesList);
            }
        else if(track.equals("Junior Einstein")){
            trackInfo.setText(R.string.einstein);
            btnRegister.setVisibility(View.VISIBLE);
            callPilot("https://ieeeyesist12.org/je-pilot-registration/");

            datesList = new ArrayList<>();
            datesList.add(new YesistHome(R.string.dates_pilot,R.string.einstein_dates_pilot));
            datesList.add(new YesistHome(R.string.direct_entry,R.string.einstein_direct_entry));
            datesList.add(new YesistHome(R.string.reg_fee,R.string.einstein_reg_fee));
            datesList.add(new YesistHome(R.string.awards,R.string.einstein_awards));
            setTracksKeyRecycler(datesList);

            //rulesList.clear();
            rulesList = new ArrayList<>();
            rulesList.add(new YesistHome(R.string.rules_tracks,R.string.einstein_rules));
            rulesList.add(new YesistHome(R.string.abs_sel_proc,R.string.einstein_abstract));
            setTracksRulesRecycler(rulesList);
        }
        else if(track.equals("WePOWER")){
            btnRegister.setVisibility(View.VISIBLE);
            trackInfo.setText(R.string.wepower);
            //cardviewExpand(R.string.wepower_abstract,R.string.wepower_rules);
            //datesList.clear();
            datesList = new ArrayList<>();
            datesList.add(new YesistHome(R.string.imp_dates,R.string.wepower_dates_pilot));
            datesList.add(new YesistHome(R.string.reg_fee,R.string.wepower_reg_fee));
            datesList.add(new YesistHome(R.string.awards,R.string.wepower_awards));
            setTracksKeyRecycler(datesList);

            //rulesList.clear();
            rulesList = new ArrayList<>();
            rulesList.add(new YesistHome(R.string.rules_tracks,R.string.wepower_rules));
            rulesList.add(new YesistHome(R.string.abs_sel_proc,R.string.wepower_abstract));
            setTracksRulesRecycler(rulesList);
        }
        else if(track.equals("Special Track")){
            btnRegister.setVisibility(View.VISIBLE);
            //expandable card view
            trackInfo.setText(R.string.special);
            //cardviewExpand(R.string.special_abstract,R.string.special_rules);
            //datesList.clear();
            datesList = new ArrayList<>();
            datesList.add(new YesistHome(R.string.imp_dates,R.string.special_dates_pilot));
            datesList.add(new YesistHome(R.string.reg_fee,R.string.special_reg_fee));
            datesList.add(new YesistHome(R.string.awards,R.string.special_awards));
            setTracksKeyRecycler(datesList);

            //rulesList.clear();
            rulesList = new ArrayList<>();
            rulesList.add(new YesistHome(R.string.rules_tracks,R.string.special_rules));
            rulesList.add(new YesistHome(R.string.abs_sel_proc,R.string.special_abstract));
            setTracksRulesRecycler(rulesList);
            }

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
        return binding.getRoot();
    }

    private void callPilot(String pilotUrl) {
        btnPilotRegister.setVisibility(View.VISIBLE);
        btnPilotRegister.setOnClickListener(v -> {
            String url = pilotUrl;
            Uri uri = Uri.parse(url);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });
    }

    private void setTracksRulesRecycler(List<YesistHome> rulesList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,false);
        rules_rv.setLayoutManager(layoutManager);
        rules_rv.setHasFixedSize(true);
        rules_rv.setNestedScrollingEnabled(false);
        trackDetailsAdapter = new TrackDetailsAdapter(rulesList, requireContext());
        rules_rv.setAdapter(trackDetailsAdapter);
    }

    private void setTracksKeyRecycler(List<YesistHome> datesList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,false);
        key_dates_rv.setLayoutManager(layoutManager);
        key_dates_rv.setHasFixedSize(true);
        key_dates_rv.setNestedScrollingEnabled(false);
        trackKeyAdapter = new TrackDetailsAdapter(datesList, requireContext());
        key_dates_rv.setAdapter(trackKeyAdapter);
    }

/*
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
    }*/
}