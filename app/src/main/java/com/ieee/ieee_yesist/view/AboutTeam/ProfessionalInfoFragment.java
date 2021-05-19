package com.ieee.ieee_yesist.view.AboutTeam;

import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

import com.ieee.ieee_yesist.R;
import com.ieee.ieee_yesist.databinding.FragmentProfessionalInfoBinding;
import com.ieee.ieee_yesist.model.Professional;

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
        binding.professionalDesc.setMovementMethod(new ScrollingMovementMethod());
        binding.professionalRole.setText(professional.getRole());
        binding.professionalPic.setImageResource(professional.getImageUrl());
        binding.backButton.setOnClickListener( v -> {
            Navigation.findNavController(requireActivity(), R.id.fragNavHost).popBackStack();
        });
        binding.linkedInButton.setOnClickListener( v-> {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(professional.getLinkedinUrl())));
        });
//        binding.professionalDesc.setMovementMethod(new ScrollingMovementMethod());
//        ViewTreeObserver observer = binding.professionalDesc.getViewTreeObserver();
//        observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
//            @Override
//            public void onGlobalLayout() {
//                int lineHeight = binding.professionalDesc.getLineHeight();
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
//                    Rect bounds = new Rect();
//                    binding.professionalDesc.getLineBounds(0, bounds);
//                    lineHeight = bounds.bottom - bounds.top;
//                }
//                int maxLines = (int) binding.professionalDesc.getHeight() / lineHeight;
//                binding.professionalDesc.setMaxLines(maxLines);
//                binding.professionalDesc.getViewTreeObserver().removeGlobalOnLayoutListener(
//                        this);
//            }
//        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentProfessionalInfoBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}