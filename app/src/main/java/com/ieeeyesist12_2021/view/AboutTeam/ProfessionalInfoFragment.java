package com.ieeeyesist12_2021.view.AboutTeam;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ieeeyesist12_2021.R;
import com.ieeeyesist12_2021.databinding.FragmentProfessionalInfoBinding;
import com.ieeeyesist12_2021.model.Professional;

public class ProfessionalInfoFragment extends Fragment {

    public ProfessionalInfoFragment() {
        // Required empty public constructor
    }

    private FragmentProfessionalInfoBinding binding;
    private Professional professional;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        professional = requireArguments().getParcelable("selectedProfessional");
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.professionalName.setText(professional.getName());
        binding.professionalDesc.setText(professional.getBio());
        binding.professionalRole.setText(professional.getRole());
        binding.professionalPic.setImageResource(professional.getImageUrl());
        binding.backButton.setOnClickListener( v -> {
            Navigation.findNavController(view).popBackStack();
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentProfessionalInfoBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}