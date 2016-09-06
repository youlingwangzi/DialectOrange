package com.fycz.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fycz.dialectorange.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotQuestionFragment extends Fragment {


    public HotQuestionFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static HotQuestionFragment newInstance(String param1, String param2) {
        HotQuestionFragment fragment = new HotQuestionFragment();
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hot_question, container, false);
    }

}
