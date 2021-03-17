package com.ieeeyesist12_2021.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ieeeyesist12_2021.databinding.FragmentTrendingBinding;

public class TrendingFragment extends Fragment {

    public TrendingFragment() {
        // Required empty public constructor
    }

    private FragmentTrendingBinding binding;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentTrendingBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}