package com.ieeeyesist12_2021.view.AboutTeam;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;

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
        populateList();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(requireContext(),2);
        binding.androidTeamRv.setLayoutManager(gridLayoutManager);
        GridLayoutManager layoutManager = new GridLayoutManager(requireContext(),2);
        binding.webTeamRv.setLayoutManager(layoutManager);
        binding.androidTeamRv.setNestedScrollingEnabled(false);
        binding.webTeamRv.setNestedScrollingEnabled(false);
        androidAdapter = new AboutTeamRecyclerAdapter(requireContext(), androidList, this);
        binding.androidTeamRv.setAdapter(androidAdapter);
        webAdapter = new AboutTeamRecyclerAdapter(requireContext(), webList, this);
        binding.webTeamRv.setAdapter(webAdapter);
    }

    private void populateList() {
        androidList = new ArrayList<>();
        androidList.add(new Professional(getString(R.string.gal_gadot), R.drawable.gal, getString(R.string.volunteer),
                getString(R.string.random_text), "linkedin"));
        androidList.add(new Professional(getString(R.string.nolan), R.drawable.profile_img, getString(R.string.volunteer),
                getString(R.string.random_text), "linkedin"));
        androidList.add(new Professional(getString(R.string.gal_gadot), R.drawable.gal, getString(R.string.volunteer),
                getString(R.string.random_text), "linkedin"));
        androidList.add(new Professional(getString(R.string.nolan), R.drawable.profile_img, getString(R.string.volunteer),
                getString(R.string.random_text), "linkedin"));
        androidList.add(new Professional(getString(R.string.nolan), R.drawable.profile_img, getString(R.string.volunteer),
                getString(R.string.random_text), "linkedin"));
        androidList.add(new Professional(getString(R.string.gal_gadot), R.drawable.gal, getString(R.string.volunteer),
                getString(R.string.random_text), "linkedin"));
        androidList.add(new Professional(getString(R.string.gal_gadot), R.drawable.gal, getString(R.string.volunteer),
                getString(R.string.random_text), "linkedin"));

        webList = new ArrayList<>();
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
    public void onProfessionalClick(int position) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("selectedAndroidProfessional", androidList.get(position));
        bundle.putParcelable("selectedWebProfessional", webList.get(position));
        Navigation.findNavController(requireView()).navigate(R.id.action_aboutTeamFragment_to_professionalInfoFragment, bundle);
    }
}