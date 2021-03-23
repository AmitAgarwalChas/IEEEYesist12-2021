package com.ieeeyesist12_2021.view.AboutTeam;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ieeeyesist12_2021.R;
import com.ieeeyesist12_2021.adapters.AboutTeamRecyclerAdapter;
import com.ieeeyesist12_2021.databinding.FragmentSterringCommitteeBinding;
import com.ieeeyesist12_2021.model.Professional;

import java.util.ArrayList;
import java.util.List;

public class SterringCommitteeFragment extends Fragment implements AboutTeamRecyclerAdapter.OnProfessionalListener {

    public SterringCommitteeFragment() {
        // Required empty public constructor
    }

    private FragmentSterringCommitteeBinding binding;
    private List<Professional> professionalList;
    private AboutTeamRecyclerAdapter adapter;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        populateList();
        adapter = new AboutTeamRecyclerAdapter(requireContext(), professionalList, this);
        binding.sterringRv.setAdapter(adapter);
    }

    private void populateList() {
        professionalList = new ArrayList<>();
        professionalList.add(new Professional(getString(R.string.general_chair), R.drawable.ic_female, "General Chair",
                getString(R.string.random_text), "linkedin"));
        professionalList.add(new Professional(getString(R.string.secretary), R.drawable.ic_female, "Secretary",
                getString(R.string.random_text), "linkedin"));

        professionalList.add(new Professional(getString(R.string.maker_fair_co_chair_1), R.drawable.ic_male, getString(R.string.co_chair_maker_fair),
                getString(R.string.random_text), "linkedin"));
        professionalList.add(new Professional(getString(R.string.maker_fair_co_chair_2), R.drawable.ic_male, getString(R.string.co_chair_maker_fair),
                getString(R.string.random_text), "linkedin"));

        professionalList.add(new Professional(getString(R.string.junior_einstein_co_chair_1), R.drawable.ic_male, getString(R.string.co_chair_junior_einstein),
                getString(R.string.random_text), "linkedin"));
        professionalList.add(new Professional(getString(R.string.junior_einstein_co_chair_2), R.drawable.ic_female, getString(R.string.co_chair_junior_einstein),
                getString(R.string.random_text), "linkedin"));

        professionalList.add(new Professional(getString(R.string.we_power_co_chair_1), R.drawable.ic_female, getString(R.string.co_chair_we_power),
                getString(R.string.random_text), "linkedin"));
        professionalList.add(new Professional(getString(R.string.we_power_co_chair_2), R.drawable.ic_male, getString(R.string.co_chair_we_power),
                getString(R.string.random_text), "linkedin"));

        professionalList.add(new Professional(getString(R.string.special_track_co_chair_1), R.drawable.ic_female, getString(R.string.co_chair_special_track),
                getString(R.string.random_text), "linkedin"));
        professionalList.add(new Professional(getString(R.string.special_track_co_chair_2), R.drawable.ic_female, getString(R.string.co_chair_special_track),
                getString(R.string.random_text), "linkedin"));

        professionalList.add(new Professional(getString(R.string.innovation_challenge_co_chair_1), R.drawable.ic_male, getString(R.string.co_chair_innovation_challenge),
                getString(R.string.random_text), "linkedin"));
        professionalList.add(new Professional(getString(R.string.innovation_challenge_co_chair_2), R.drawable.ic_female, getString(R.string.co_chair_innovation_challenge),
                getString(R.string.random_text), "linkedin"));

        professionalList.add(new Professional(getString(R.string.promotion_and_publicity_co_chair_1), R.drawable.ic_female, getString(R.string.co_chair_pro_pub),
                getString(R.string.random_text), "linkedin"));
        professionalList.add(new Professional(getString(R.string.promotion_and_publicity_co_chair_2), R.drawable.ic_female, getString(R.string.co_chair_pro_pub),
                getString(R.string.random_text), "linkedin"));

        professionalList.add(new Professional(getString(R.string.website_chair_1), R.drawable.ic_male, getString(R.string.co_chair_website),
                getString(R.string.random_text), "linkedin"));
        professionalList.add(new Professional(getString(R.string.website_co_chair_2), R.drawable.ic_male, getString(R.string.co_chair_website),
                getString(R.string.random_text), "linkedin"));

        professionalList.add(new Professional(getString(R.string.content_development_chair_1), R.drawable.ic_female, getString(R.string.co_chair_content_dev),
                getString(R.string.random_text), "linkedin"));
        professionalList.add(new Professional(getString(R.string.content_development_chair_2), R.drawable.ic_female, getString(R.string.co_chair_content_dev),
                getString(R.string.random_text), "linkedin"));

        professionalList.add(new Professional(getString(R.string.section_collaboration_chair_1), R.drawable.ic_male, getString(R.string.co_chair_section_collab),
                getString(R.string.random_text), "linkedin"));
        professionalList.add(new Professional(getString(R.string.section_collaboration_chair_2), R.drawable.ic_male, getString(R.string.co_chair_section_collab),
                getString(R.string.random_text), "linkedin"));


        professionalList.add(new Professional(getString(R.string.partnerships_co_chair), R.drawable.ic_female, getString(R.string.co_chair_partnership),
                getString(R.string.random_text), "linkedin"));

        professionalList.add(new Professional(getString(R.string.career_fair_chair), R.drawable.ic_male, getString(R.string.chair_career_fair),
                getString(R.string.random_text), "linkedin"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentSterringCommitteeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onProfessionalClick(Professional pro) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("selectedProfessional", pro);
        Navigation.findNavController(requireView()).navigate(R.id.action_aboutTeamFragment_to_professionalInfoFragment, bundle);
    }
}