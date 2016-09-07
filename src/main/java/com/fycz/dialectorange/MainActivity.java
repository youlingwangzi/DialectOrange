package com.fycz.dialectorange;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;

import com.flyco.tablayout.listener.OnTabSelectListener;
import com.fycz.fragment.HomePage;
import com.fycz.entity.*;
import com.fycz.fragment.HouhuayuanFragment;
import com.fycz.fragment.WodeFragment;
import com.fycz.fragment.XunweiFragment;
import com.fycz.fragment.YongqichengziFragment;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity{
    private Context mContext = this;
    private ArrayList<Fragment> mFragments = new ArrayList<>();

    private String[] mTitles = {"首页", "寻味", "" , "后花园", "我的"};
    private int[] mIconUnselectIds = {
            R.mipmap.tab_home_unselect2, R.mipmap.tab_speech_unselect2,
            R.mipmap.orange_nocolor,
            R.mipmap.tab_contact_unselect2, R.mipmap.tab_more_unselect2};
    private int[] mIconSelectIds = {
            R.mipmap.tab_home_select2, R.mipmap.tab_speech_select2,
            R.mipmap.orange,
            R.mipmap.tab_contact_select2, R.mipmap.tab_more_select2};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private CommonTabLayout mTabLayout_1;

    public TextView mainTextView;
    public ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }

        mainTextView=(TextView)findViewById(R.id.main_title_text);
        imageView=(ImageView)findViewById(R.id.wodetouxiang);

        mFragments.add(HomePage.newInstance("",""));
        mFragments.add(XunweiFragment.newInstance("",""));
        mFragments.add(YongqichengziFragment.newInstance("",""));
        mFragments.add(HouhuayuanFragment.newInstance("",""));
        mFragments.add(WodeFragment.newInstance("",""));

        mTabLayout_1 = (CommonTabLayout) findViewById(R.id.tl_1);
        mTabLayout_1.setTabData(mTabEntities, this,R.id.fl_change, mFragments);

        mTabLayout_1.setOnTabSelectListener(
                new OnTabSelectListener() {
                    @Override
                    public void onTabSelect(int position) {
                        imageView.setVisibility(View.VISIBLE);
                        switch (position){
                            case 0:mainTextView.setText("首页");break;
                            case 1:mainTextView.setText("寻味");break;
                            case 2:mainTextView.setText("勇气橙子");break;
                            case 3:mainTextView.setText("后花园");break;
                            case 4:mainTextView.setText("我的");
                                imageView.setVisibility(View.INVISIBLE);break;
                            default:mainTextView.setText("首页");
                        }
                    }

                    @Override
                    public void onTabReselect(int position) {
                        imageView.setVisibility(View.VISIBLE);
                            switch (position){
                                case 0:mainTextView.setText("首页");break;
                                case 1:mainTextView.setText("寻味");break;
                                case 2:mainTextView.setText("勇气橙子");break;
                                case 3:mainTextView.setText("后花园");break;
                                case 4:mainTextView.setText("我的");
                                    imageView.setVisibility(View.INVISIBLE);break;
                                default:mainTextView.setText("首页");
                            }
                    }
                }
        );
    }

    public void setMainTextView(String string){
        mainTextView.setText(string);
    }
}
