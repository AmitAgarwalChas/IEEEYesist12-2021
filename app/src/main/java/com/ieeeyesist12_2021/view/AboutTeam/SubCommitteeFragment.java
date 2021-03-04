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
import com.ieeeyesist12_2021.adapters.AboutTeamRecyclerAdapter;
import com.ieeeyesist12_2021.databinding.FragmentSubCommitteeBinding;
import com.ieeeyesist12_2021.model.Professional;
import java.util.ArrayList;
import java.util.List;

public class SubCommitteeFragment extends Fragment implements AboutTeamRecyclerAdapter.OnProfessionalListener  {

    public SubCommitteeFragment() {
        // Required empty public constructor
    }

    private FragmentSubCommitteeBinding binding;
    private List<Professional> androidList, webList;
    private AboutTeamRecyclerAdapter androidAdapter, webAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSubCommitteeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        webList=new ArrayList<>();
        androidList=new ArrayList<>();
        populateList();
        binding.androidTeamRv.setNestedScrollingEnabled(false);
        binding.webTeamRv.setNestedScrollingEnabled(false);
        androidAdapter = new AboutTeamRecyclerAdapter(requireContext(), androidList, this);
        binding.androidTeamRv.setAdapter(androidAdapter);
        webAdapter = new AboutTeamRecyclerAdapter(requireContext(), webList, this);
        binding.webTeamRv.setAdapter(webAdapter);
    }

    private void populateList() {
        androidList.clear();
        androidList.add(new Professional(getString(R.string.amit_agarwal), R.drawable.profile_img, getString(R.string.volunteer),
                getString(R.string.random_text), "linkedin"));
        androidList.add(new Professional(getString(R.string.mokshda_gangrade), R.drawable.gal, getString(R.string.volunteer),
                getString(R.string.random_text), "linkedin"));
        androidList.add(new Professional(getString(R.string.samriddhi), R.drawable.gal, getString(R.string.volunteer),
                getString(R.string.random_text), "linkedin"));
        androidList.add(new Professional(getString(R.string.sunjol_paul), R.drawable.profile_img, getString(R.string.volunteer),
                getString(R.string.random_text), "linkedin"));
        androidList.add(new Professional(getString(R.string.rupam_laha), R.drawable.profile_img, getString(R.string.volunteer),
                getString(R.string.random_text), "linkedin"));
        androidList.add(new Professional(getString(R.string.aayushi), R.drawable.gal, getString(R.string.volunteer),
                getString(R.string.random_text), "linkedin"));

        webList.clear();
        webList.add(new Professional(getString(R.string.gal_gadot), R.drawable.gal, getString(R.string.volunteer),
                getString(R.string.random_text), "linkedin"));
        webList.add(new Professional(getString(R.string.nolan), R.drawable.profile_img, getString(R.string.volunteer),
                getString(R.string.random_text), "linkedin"));
        webList.add(new Professional(getString(R.string.gal_gadot), R.drawable.gal, getString(R.string.volunteer),
                getString(R.string.random_text), "linkedin"));
        webList.add(new Professional(getString(R.string.nolan), R.drawable.profile_img, getString(R.string.volunteer),
                getString(R.string.random_text), "linkedin"));
        webList.add(new Professional(getString(R.string.gal_gadot), R.drawable.gal, getString(R.string.volunteer),
                getString(R.string.random_text), "linkedin"));
        webList.add(new Professional(getString(R.string.nolan), R.drawable.profile_img, getString(R.string.volunteer),
                getString(R.string.random_text), "linkedin"));
        webList.add(new Professional(getString(R.string.nolan), R.drawable.profile_img, getString(R.string.volunteer),
                getString(R.string.random_text), "linkedin"));
    }

    @Override
    public void onProfessionalClick(Professional pro) {
        /*Bundle bundle = new Bundle();
        bundle.putParcelable("selectedProfessional", pro);
        Navigation.findNavController(requireView()).navigate(R.id.action_aboutTeamFragment_to_professionalInfoFragment, bundle);*/
    }
}