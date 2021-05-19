package com.ieee.ieee_yesist.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.ieee.ieee_yesist.R;
import com.ieee.ieee_yesist.adapters.YesistHomeAdapter;
import com.ieee.ieee_yesist.model.YesistHome;

import java.util.ArrayList;
import java.util.List;

import im.crisp.client.ChatActivity;
import im.crisp.client.Crisp;

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

        Crisp.configure(getActivity().getApplicationContext(), "35d59f9c-e6df-416d-9364-5356d91fc5df");
        FloatingActionButton fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent crispIntent = new Intent(getActivity(), ChatActivity.class);
                startActivity(crispIntent);
            }
        });


        yesistHomeList = new ArrayList<>();
        yesistHomeList.add(new YesistHome(R.string.knowledge_title,R.string.knowledge));
        yesistHomeList.add(new YesistHome(R.string.prof_connect_title,R.string.prof_connect));
        yesistHomeList.add(new YesistHome(R.string.arena_title,R.string.arena));
        yesistHomeList.add(new YesistHome(R.string.time_title,R.string.time));
        yesistHomeList.add(new YesistHome(R.string.recognised_title,R.string.recognised));
        yesistHomeList.add(new YesistHome(R.string.presence_title,R.string.presence));
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