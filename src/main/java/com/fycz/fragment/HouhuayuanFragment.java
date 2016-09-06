package com.fycz.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.flyco.tablayout.SlidingTabLayout;
import com.fycz.dialectorange.MainActivity;
import com.fycz.dialectorange.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link HouhuayuanFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HouhuayuanFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private final String[] mTitles = {
            "最新问题", "热门", "投票"
    };
    private MyPagerAdapter mAdapter;

    public HouhuayuanFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HouhuayuanFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HouhuayuanFragment newInstance(String param1, String param2) {
        HouhuayuanFragment fragment = new HouhuayuanFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_houhuayuan, container, false);

        mFragments.add(NewestQuestionFragment.newInstance("",""));
        mFragments.add(HotQuestionFragment.newInstance("",""));
        mFragments.add(VoteFragment.newInstance("",""));
        ViewPager viewPager = (ViewPager)view.findViewById(R.id.viewpager);
        mAdapter = new MyPagerAdapter(getFragmentManager());
        viewPager.setAdapter(mAdapter);


        /** indicator圆角色块 */
        SlidingTabLayout tabLayout_9 = (SlidingTabLayout)view.findViewById(R.id.tl_9);

        tabLayout_9.setViewPager(viewPager);

        return view;
    }



    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }
    }



/*    @Override
    public void onResume(){
        super.onResume();
        MainActivity mainActivity = (MainActivity)getActivity();
        mainActivity.mainTextView.setText("后花园");
    }*/

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
