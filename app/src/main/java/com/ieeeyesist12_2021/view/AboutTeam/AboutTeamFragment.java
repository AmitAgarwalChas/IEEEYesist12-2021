package com.ieeeyesist12_2021.view.AboutTeam;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.ieeeyesist12_2021.R;
import com.ieeeyesist12_2021.adapters.AboutTeamViewPagerAdapter;
import com.ieeeyesist12_2021.databinding.FragmentAboutTeamBinding;

import java.util.ArrayList;
import java.util.List;

public class AboutTeamFragment extends Fragment {

    public AboutTeamFragment() {
        // Required empty public constructor
    }

    private FragmentAboutTeamBinding binding;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        List<Fragment> fragmentList=new ArrayList<>();
        fragmentList.add(new SterringCommitteeFragment());
        fragmentList.add(new SubCommitteeFragment());
        AboutTeamViewPagerAdapter vpAdapter = new AboutTeamViewPagerAdapter(getChildFragmentManager(), getLifecycle(),fragmentList);
        binding.aboutTeamVp.setAdapter(vpAdapter);
        ArrayList<String> titles = new ArrayList<>();
        titles.add("Sterring Committee");
        titles.add("Sub Committee");
        new TabLayoutMediator(binding.tabLayout, binding.aboutTeamVp,
                ((tab, position) -> {
                    tab.setText(titles.get(position));
                })).attach();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAboutTeamBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}