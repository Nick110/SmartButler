package com.example.smartbutler;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.smartbutler.fragment.GirlFragment;
import com.example.smartbutler.fragment.UserFragment;
import com.example.smartbutler.fragment.WechatFragment;
import com.example.smartbutler.ui.SettingActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //TabLayout
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private List<String> mTitle;
    private List<Fragment> mFragment;
    //悬浮窗
    private FloatingActionButton fab_setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //去掉阴影
        getSupportActionBar().setElevation(0);
        initData();
        initView();
    }

    //初始化数据
    private void initData() {
        mTitle = new ArrayList<>();
        mTitle.add("微信精选");
        mTitle.add("美女如云");
        mTitle.add("个人中心");

        mFragment = new ArrayList<>();
        mFragment.add(new WechatFragment());
        mFragment.add(new GirlFragment());
        mFragment.add(new UserFragment());
    }

    //初始化View
    private void initView() {
        fab_setting = (FloatingActionButton)findViewById(R.id.fab_setting);
        fab_setting.setOnClickListener(this);
        //设置隐藏
//        fab_setting.setVisibility(View.GONE);
        mTabLayout = (TabLayout) findViewById(R.id.mTabLayout);
        mViewPager = (ViewPager) findViewById(R.id.mViewPager);
        //预加载
        mViewPager.setOffscreenPageLimit(mFragment.size());

        //mViewPager滑动监听
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }


            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        //设置适配器
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            //选中的item
            @Override
            public Fragment getItem(int position) {
                return mFragment.get(position);
            }

            @Override
            public int getCount() {
                return mFragment.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return mTitle.get(position);
            }
        });

        //绑定
        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab_setting:
                startActivity(new Intent(this, SettingActivity.class));
                break;
        }
    }
}
