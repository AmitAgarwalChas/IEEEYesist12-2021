package com.ieee.ieee_yesist.view;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ieee.ieee_yesist.R;
import com.ieee.ieee_yesist.adapters.SponsorAdapter;
import com.ieee.ieee_yesist.databinding.FragmentSponsorsBinding;
import com.ieee.ieee_yesist.model.Sponsor;
import java.util.ArrayList;
import java.util.List;

public class SponsorsFragment extends Fragment {

    private static List<Sponsor> sponsorList;
    private FragmentSponsorsBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSponsorsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        populateList();
        SponsorAdapter adapter = new SponsorAdapter(sponsorList);
        binding.sponsorsRv.setAdapter(adapter);
        binding.backButton.setOnClickListener( v -> {
            Navigation.findNavController(requireActivity(), R.id.fragNavHost).popBackStack();
            BottomNavigationView bottomNavigationView = requireActivity().findViewById(R.id.bottomNavigationView);
            if(bottomNavigationView.getVisibility() == View.GONE)
                bottomNavigationView.setVisibility(View.VISIBLE);
        });

    }

    private void populateList() {
        sponsorList = new ArrayList<>();
        sponsorList.add(new Sponsor("https://ieeeyesist12.org/wp-content/uploads/2021/03/IEEE.png",
                "https://www.computer.org/"));
        sponsorList.add(new Sponsor("https://ieeeyesist12.org/wp-content/uploads/2021/03/IEEE.png",
                "https://www.computer.org/"));
        sponsorList.add(new Sponsor("https://ieeeyesist12.org/wp-content/uploads/2021/03/IEEE.png",
                "https://www.computer.org/"));
        sponsorList.add(new Sponsor("https://ieeeyesist12.org/wp-content/uploads/2021/03/IEEE.png",
                "https://www.computer.org/"));
        sponsorList.add(new Sponsor("https://ieeeyesist12.org/wp-content/uploads/2021/03/IEEE.png",
                "https://www.computer.org/"));
        sponsorList.add(new Sponsor("https://ieeeyesist12.org/wp-content/uploads/2021/03/IEEE.png",
                "https://www.computer.org/"));
    }
}