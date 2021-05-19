package com.ieee.ieee_yesist.view.AboutTeam;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ieee.ieee_yesist.R;
import com.ieee.ieee_yesist.adapters.AboutTeamRecyclerAdapter;
import com.ieee.ieee_yesist.databinding.FragmentSubCommitteeBinding;
import com.ieee.ieee_yesist.model.Professional;
import java.util.ArrayList;
import java.util.List;

public class SubCommitteeFragment extends Fragment implements AboutTeamRecyclerAdapter.OnProfessionalListener  {

    public SubCommitteeFragment() {
        // Required empty public constructor
    }

    private FragmentSubCommitteeBinding binding;
    private List<Professional> androidList;
    private AboutTeamRecyclerAdapter androidAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSubCommitteeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        androidList=new ArrayList<>();
        populateList();
        binding.androidTeamRv.setNestedScrollingEnabled(false);
        androidAdapter = new AboutTeamRecyclerAdapter(requireContext(), androidList, this);
        binding.androidTeamRv.setAdapter(androidAdapter);
    }

    private void populateList() {
        androidList.clear();
        androidList.add(new Professional(getString(R.string.amit_agarwal), R.drawable.amit_app, "App Team",
                getString(R.string.amit_bio), "https://www.linkedin.com/in/amit-agarwal-b7a88a1a1/"));
        androidList.add(new Professional(getString(R.string.mokshda_gangrade), R.drawable.mokshda_app, "App Team",
                getString(R.string.mokshda_bio), "https://www.linkedin.com/in/mokshda-gangrade-753b281b3/"));
        androidList.add(new Professional(getString(R.string.samriddhi), R.drawable.samriddhi_app, "App Team",
                getString(R.string.samriddhi_bio), "https://www.linkedin.com/in/samriddhi-agarwal-3520851b8/"));
        //androidList.add(new Professional(getString(R.string.sunjol_paul), R.drawable.ic_male, "App Team",
        //        getString(R.string.random_text), "linkedin"));
        androidList.add(new Professional(getString(R.string.rupam_laha), R.drawable.rupam_app, "App Team",
                getString(R.string.rupam_bio), "https://www.linkedin.com/in/rupam-laha-517795168"));
        androidList.add(new Professional(getString(R.string.aayushi), R.drawable.aayushi_app, "App Team",
                getString(R.string.aayushi_bio), "https://www.linkedin.com/in/aayushi-tated-898805193/"));

        androidList.add(new Professional(getString(R.string.adithya_name), R.drawable.adithya_myra, getString(R.string.adithya_role),
                getString(R.string.adithya_bio), "https://www.linkedin.com/in/adithya-marayil-666613171"));
        androidList.add(new Professional(getString(R.string.Venkatraman_name), R.drawable.venkat_ravi, getString(R.string.Venkatraman_role),
                getString(R.string.Venkatraman_bio), "https://www.linkedin.com/in/venkatramanravi/"));
        androidList.add(new Professional(getString(R.string.Nandhita_name), R.drawable.nandhitha, getString(R.string.Nandhita_role),
                getString(R.string.Nandhita_bio), "https://www.linkedin.com/in/nandhitha-kalyanasundaram-2787521aa"));
        androidList.add(new Professional(getString(R.string.priya_name), R.drawable.priya_darshini, getString(R.string.priya_role),
                getString(R.string.priya_bio), "https://www.linkedin.com/in/priyadharshini-sashikumar-b38356137"));
        androidList.add(new Professional(getString(R.string.heshan_name), R.drawable.heshan_malla, getString(R.string.heshan_role),
                getString(R.string.heshan_bio), "https://www.linkedin.com/in/heshan-nayanajith-586aa0152/"));
        androidList.add(new Professional(getString(R.string.parvathi_name), R.drawable.parvathi_j, getString(R.string.parvathi_role),
                getString(R.string.parvathi_bio), "https://www.linkedin.com/in/parvathijnair/"));
        androidList.add(new Professional(getString(R.string.manoj_name), R.drawable.manoj_kumar, getString(R.string.manoj_role),
                getString(R.string.manoj_bio), "https://www.linkedin.com/in/manoj-kumar-donthurala-55a320192"));
        androidList.add(new Professional(getString(R.string.Saniya_name), R.drawable.saniya, getString(R.string.Saniya_role),
                getString(R.string.Saniya_bio), "https://www.linkedin.com/mwlite/in/saniya-janu-97296a1a1"));
        androidList.add(new Professional(getString(R.string.teenu_name), R.drawable.teenu_prashanth, getString(R.string.teenu_role),
                getString(R.string.teenu_bio), "https://www.linkedin.com/in/teenu-prasanth-s-4b183415b"));
        androidList.add(new Professional(getString(R.string.heyram_name), R.drawable.heyram, getString(R.string.heyram_role),
                getString(R.string.heyram_bio), "https://www.linkedin.com/in/heyram-eee/"));
        androidList.add(new Professional(getString(R.string.akshaya_name), R.drawable.akshaya, getString(R.string.akshaya_role),
                getString(R.string.akshaya_bio), "https://www.linkedin.com/in/cybergirl-io"));
        androidList.add(new Professional(getString(R.string.kawshik_name), R.drawable.kawshik, getString(R.string.kawshik_role),
                getString(R.string.kawshik_bio), "https://www.linkedin.com/in/kawshikbanerjee2024/"));
        androidList.add(new Professional(getString(R.string.vamsi_name), R.drawable.venkata, getString(R.string.vamsi_role),
                getString(R.string.vamsi_bio), "https://www.linkedin.com/in/venkata-vamsi-p-8321061a5"));
        androidList.add(new Professional(getString(R.string.anjali_name), R.drawable.anjali_masur, getString(R.string.anjali_role),
                getString(R.string.anjali_bio), "https://www.linkedin.com/in/anjali-masur-04788319b"));
        androidList.add(new Professional(getString(R.string.said_name), R.drawable.said, getString(R.string.said_role),
                getString(R.string.said_bio), "https://www.linkedin.com/in/said-abolhassan-razavi-73443a157"));
        androidList.add(new Professional(getString(R.string.muza_name), R.drawable.muzamil, getString(R.string.muza_role),
                getString(R.string.muza_bio), "www.linkedin.com/in/iammm"));
        androidList.add(new Professional(getString(R.string.mithresh_name), R.drawable.mithresh, getString(R.string.mithresh_role),
                getString(R.string.mithresh_bio), "https://www.linkedin.com/in/mithresh-gunaseelan-484291194/"));
        androidList.add(new Professional(getString(R.string.alex_name), R.drawable.alex, getString(R.string.alex_role),
                getString(R.string.alex_bio), "https://www.linkedin.com/in/alex-daniel-pizarro-chozo-21a616143/"));
        androidList.add(new Professional(getString(R.string.varsha_name), R.drawable.varsha, getString(R.string.varsha_role),
                getString(R.string.varsha_bio), "https://www.linkedin.com/in/varsha-n-j-5180a5192"));
        androidList.add(new Professional(getString(R.string.xio_name), R.drawable.xio, getString(R.string.xio_role),
                getString(R.string.xio_bio), "https://www.linkedin.com/in/xiomara-andrea-garcia-torrejon-33765620b"));
        androidList.add(new Professional(getString(R.string.luis_name), R.drawable.luis, getString(R.string.luis_role),
                getString(R.string.luis_bio), "www.linkedin.com/in/piero-velásquez-rojas-13165620b"));
        androidList.add(new Professional(getString(R.string.hipo_name), R.drawable.hipo, getString(R.string.hipo_role),
                getString(R.string.hipo_bio), "https://www.linkedin.com/feed/?trk=onboarding-landing"));
        androidList.add(new Professional(getString(R.string.tejasvi_name), R.drawable.tejasvi, getString(R.string.tejasvi_role),
                getString(R.string.tejasvi_bio), "https://bit.ly/Tejasvi_LinkedIn"));
        androidList.add(new Professional(getString(R.string.ganesh_name), R.drawable.ganesh, getString(R.string.ganesh_role),
                getString(R.string.ganesh_bio), "https://www.linkedin.com/in/ganeshuthiravasagam/"));
        androidList.add(new Professional(getString(R.string.neavil_name), R.drawable.neavil, getString(R.string.neavil_role),
                getString(R.string.neavil_bio), "https://in.linkedin.com/in/neavil-porus-a-832304189&ved=2ahUKEwj8keuhoajwAhUAyzgGHdRbAn8QFjAAegQIBBAC&usg=AOvVaw3Y5qjIYwTnpJAdemqbDnyl"));
        androidList.add(new Professional(getString(R.string.athar_name), R.drawable.athar, getString(R.string.athar_role),
                getString(R.string.athar_bio), "https://www.linkedin.com/in/chaudryathar"));
        androidList.add(new Professional(getString(R.string.muzaffer_name), R.drawable.muzaffer, getString(R.string.muzaffer_role),
                getString(R.string.muzaffer_bio), "https://www.linkedin.com/in/muzaffersevili/"));
        androidList.add(new Professional(getString(R.string.shamlima_name), R.drawable.shamlima, getString(R.string.shamlima_role),
                getString(R.string.shamlima_bio), "https://www.linkedin.com/in/shamlima-deb-trena-3487991ab/"));
        androidList.add(new Professional(getString(R.string.aparna_name), R.drawable.aparna, getString(R.string.aparna_role),
                getString(R.string.aparna_bio), "https://www.linkedin.com/in/aparna-ganesh-63ba98171"));
        androidList.add(new Professional(getString(R.string.kishore_name), R.drawable.kishore, getString(R.string.kishore_role),
                getString(R.string.kishore_bio), "https://www.linkedin.com/in/kishore-kumar-lakshmanan-2a542b1a2"));
        androidList.add(new Professional(getString(R.string.sonali_name), R.drawable.sonali, getString(R.string.sonali_role),
                getString(R.string.sonali_bio), "https://www.linkedin.com/in/sonali-reddy-sankepally-402877192"));
        androidList.add(new Professional(getString(R.string.dinithi_name), R.drawable.dinithi, getString(R.string.dinithi_role),
                getString(R.string.dinithi_bio), "www.linkedin.com/in/dinithi-senarath-312313209"));
        androidList.add(new Professional(getString(R.string.stephen_name), R.drawable.stephen, getString(R.string.stephen_role),
                getString(R.string.stephen_bio), "linkedin.com/in/stephenokwiri"));

    }

    @Override
    public void onProfessionalClick(Professional pro) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("selectedProfessional", pro);
        Navigation.findNavController(requireView()).navigate(R.id.action_aboutTeamFragment_to_professionalInfoFragment, bundle);
    }
}