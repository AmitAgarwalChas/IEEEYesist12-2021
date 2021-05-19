package com.ieee.ieee_yesist.view.Faqs;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.ieee.ieee_yesist.R;
import com.ieee.ieee_yesist.adapters.FaqDetailsAdapter;
import com.ieee.ieee_yesist.adapters.TrackDetailsAdapter;
import com.ieee.ieee_yesist.model.YesistHome;

import java.util.ArrayList;
import java.util.List;

public class FaqsDetailFragment extends Fragment {

    RecyclerView faq_det_rv;
    FaqDetailsAdapter faqDetailsAdapter;
    List<YesistHome> faqList;
    ImageButton back;

    public FaqsDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_faqs_detail, container, false);

        faq_det_rv = view.findViewById(R.id.track_details_faq_rv);
        back=view.findViewById(R.id.back_button);

        Bundle bundle = this.getArguments();
        assert bundle != null;
        String trackName = bundle.getString("trackName");

        if(trackName.equals("Innovation Challenge")){
            faqList = new ArrayList<>();
            faqList.add(new YesistHome(R.string.innov_ques1,R.string.innov_ans1));
            faqList.add(new YesistHome(R.string.innov_ques2,R.string.innov_ans2));
            faqList.add(new YesistHome(R.string.innov_ques3,R.string.innov_ans3));
            faqList.add(new YesistHome(R.string.innov_ques4,R.string.innov_ans4));

            setFaqRecycler(faqList);
        }
        else if(trackName.equals("Maker Fair")){
            faqList = new ArrayList<>();
            faqList.add(new YesistHome(R.string.maker_ques1,R.string.maker_ans1));
            faqList.add(new YesistHome(R.string.maker_ques2,R.string.maker_ans2));

            setFaqRecycler(faqList);

        }
        else if(trackName.equals("Junior Einstein")){
            faqList = new ArrayList<>();
            faqList.add(new YesistHome(R.string.je_ques1,R.string.je_ans1));
            faqList.add(new YesistHome(R.string.je_ques2,R.string.je_ans2));
            faqList.add(new YesistHome(R.string.je_ques3,R.string.je_ans3));
            faqList.add(new YesistHome(R.string.je_ques4,R.string.je_ans4));
            faqList.add(new YesistHome(R.string.je_ques5,R.string.je_ans5));
            faqList.add(new YesistHome(R.string.je_ques6,R.string.je_ans6));

            setFaqRecycler(faqList);

        }
        else if(trackName.equals("WePOWER")){
            faqList = new ArrayList<>();
            faqList.add(new YesistHome(R.string.wepower_ques1,R.string.wepower_ans1));
            faqList.add(new YesistHome(R.string.wepower_ques2,R.string.wepower_ans2));
            faqList.add(new YesistHome(R.string.wepower_ques3,R.string.wepower_ans3));

            setFaqRecycler(faqList);

        }
        else if(trackName.equals("Special Track")){
            faqList = new ArrayList<>();
            faqList.add(new YesistHome(R.string.st_ques1,R.string.st_ans1));
            faqList.add(new YesistHome(R.string.st_ques2,R.string.st_ans2));
            faqList.add(new YesistHome(R.string.st_ques3,R.string.st_ans3));
            faqList.add(new YesistHome(R.string.st_ques4,R.string.st_ans4));
            faqList.add(new YesistHome(R.string.st_ques5,R.string.st_ans5));
            faqList.add(new YesistHome(R.string.st_ques6,R.string.st_ans6));

            setFaqRecycler(faqList);

        }

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(requireView()).navigate(R.id.action_faqDetailsFragment_to_faqFragment);
            }
        });

        return view;
    }

    private void setFaqRecycler(List<YesistHome> faqList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,false);
        faq_det_rv.setLayoutManager(layoutManager);
        faq_det_rv.setHasFixedSize(true);
        faqDetailsAdapter = new FaqDetailsAdapter(faqList, requireContext());
        faq_det_rv.setAdapter(faqDetailsAdapter);
    }
}