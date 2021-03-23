package com.ieeeyesist12_2021.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ieeeyesist12_2021.R;
import com.ieeeyesist12_2021.adapters.TrackListAdapter;
import com.ieeeyesist12_2021.adapters.YesistHomeAdapter;
import com.ieeeyesist12_2021.model.TrackList;
import com.ieeeyesist12_2021.model.YesistHome;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    RecyclerView yesistRecyler;
    YesistHomeAdapter yesistHomeAdapter;
    List<YesistHome> yesistHomeList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        yesistRecyler=view.findViewById(R.id.yesist_recycler);
        yesistHomeList = new ArrayList<>();
        yesistHomeList.add(new YesistHome("Knowledgeable Resources",R.string.knowledge));
        yesistHomeList.add(new YesistHome("Professional Connect",R.string.knowledge));
        yesistHomeList.add(new YesistHome("Great Arena",R.string.knowledge));
        yesistHomeList.add(new YesistHome("Quality time",R.string.knowledge));
        yesistHomeList.add(new YesistHome("Get Recognized",R.string.knowledge));
        yesistHomeList.add(new YesistHome("Global Presence",R.string.knowledge));
        setYesistRecycler(yesistHomeList);
        return view;
    }
    private void setYesistRecycler(List<YesistHome> yesistHomeList){
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,false);
            yesistRecyler.setLayoutManager(layoutManager);
            yesistRecyler.setHasFixedSize(true);
            yesistRecyler.setNestedScrollingEnabled(false);
            yesistHomeAdapter = new YesistHomeAdapter(requireContext(),yesistHomeList);
            yesistRecyler.setAdapter(yesistHomeAdapter);
    }
}