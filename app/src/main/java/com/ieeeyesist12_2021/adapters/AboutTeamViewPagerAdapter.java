package com.ieeeyesist12_2021.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class AboutTeamViewPagerAdapter extends FragmentStateAdapter {

    private ArrayList<Fragment> fragments;

    public AboutTeamViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        this.fragments = new ArrayList<>();
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragments.get(position);
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public void addFragment(Fragment fragment) {
        fragments.add(fragment);
    }

}
