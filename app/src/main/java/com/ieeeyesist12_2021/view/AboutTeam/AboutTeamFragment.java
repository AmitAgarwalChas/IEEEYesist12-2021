package com.ieeeyesist12_2021.view.AboutTeam;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayoutMediator;
import com.ieeeyesist12_2021.R;
import com.ieeeyesist12_2021.adapters.AboutTeamViewPagerAdapter;
import com.ieeeyesist12_2021.databinding.FragmentAboutTeamBinding;

import java.util.ArrayList;

public class AboutTeamFragment extends Fragment {

    public AboutTeamFragment() {
        // Required empty public constructor
    }

    private FragmentAboutTeamBinding binding;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.profile.setOnClickListener( v ->
                Navigation.findNavController(requireView()).navigate(R.id.action_aboutTeamFragment_to_profileFragment));
        AboutTeamViewPagerAdapter vpAdapter = new AboutTeamViewPagerAdapter(requireActivity());
        vpAdapter.addFragment(new SterringCommitteeFragment());
        vpAdapter.addFragment(new SubCommitteeFragment());
        binding.aboutTeamVp.setAdapter(vpAdapter);
        ArrayList<String> titles = new ArrayList<>();
        titles.add("Sterring Committee");
        titles.add("Sub Committee");
        new TabLayoutMediator(binding.tabLayout, binding.aboutTeamVp,
                ((tab, position) -> tab.setText(titles.get(position)))).attach();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAboutTeamBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}