package com.ieee.ieee_yesist.view;

import android.graphics.text.LineBreaker;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.BulletSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ieee.ieee_yesist.R;
import com.ieee.ieee_yesist.databinding.FragmentAboutUsBinding;

public class AboutUsFragment extends Fragment {

    TextView aboutUs, ourMission, ourVision;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        FragmentAboutUsBinding binding = FragmentAboutUsBinding.inflate(inflater, container, false);
        binding.arrowBack.setOnClickListener( v -> {
            Navigation.findNavController(requireActivity(), R.id.fragNavHost).popBackStack();
            BottomNavigationView bottomNavigationView = requireActivity().findViewById(R.id.bottomNavigationView);
            if(bottomNavigationView.getVisibility() == View.GONE)
                bottomNavigationView.setVisibility(View.VISIBLE);
        });

        aboutUs = binding.aboutUs;
        ourMission = binding.ourMission;
        ourVision = binding.ourVision;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            aboutUs.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
            ourMission.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
            ourVision.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
        }
        return binding.getRoot();
    }
}
