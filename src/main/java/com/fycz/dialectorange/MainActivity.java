package com.fycz.dialectorange;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;

import com.fycz.fragment.HomePage;
import com.fycz.entity.*;
import com.fycz.fragment.XunweiFragment;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity {
    private Context mContext = this;
    private ArrayList<Fragment> mFragments = new ArrayList<>();

    private String[] mTitles = {"首页", "寻味", "" , "后花园", "我的"};
    private int[] mIconUnselectIds = {
            R.mipmap.tab_home_unselect1, R.mipmap.tab_speech_unselect1,
            R.mipmap.orange_nocolor,
            R.mipmap.tab_contact_unselect1, R.mipmap.tab_more_unselect1};
    private int[] mIconSelectIds = {
            R.mipmap.tab_home_select1, R.mipmap.tab_speech_select1,
            R.mipmap.orange,
            R.mipmap.tab_contact_select1, R.mipmap.tab_more_select1};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private CommonTabLayout mTabLayout_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }

        mFragments.add(HomePage.newInstance("",""));
        mFragments.add(XunweiFragment.newInstance("",""));
        mFragments.add(HomePage.newInstance("",""));
        mFragments.add(HomePage.newInstance("",""));
        mFragments.add(HomePage.newInstance("",""));

        mTabLayout_1 = (CommonTabLayout) findViewById(R.id.tl_1);
        mTabLayout_1.setTabData(mTabEntities, this,R.id.fl_change, mFragments);
    }
}
