package com.xunman.smartbutler;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.xunman.smartbutler.fragment.FourFragment;
import com.xunman.smartbutler.fragment.MainFragment;
import com.xunman.smartbutler.fragment.SecondFragment;
import com.xunman.smartbutler.fragment.ThirdFragment;
import com.xunman.smartbutler.ui.SettingActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //TabLayout
    private TabLayout mTabLayout;
    //ViewPager
    private ViewPager mViewPager;
    //Titlee
    private List<String> mTitle;
    //Fragment
    private List<Fragment> mFragment;
    //悬浮窗
    private FloatingActionButton fab_setting;
    private static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //去掉actionBar的阴影
        getSupportActionBar().setElevation(0);
        intitData();
        intiView();
        //测试bugly
//        CrashReport.testJavaCrash();
    }

    //初始化控件View
    private void intiView() {
        fab_setting = (FloatingActionButton) findViewById(R.id.fab_setting);
        fab_setting.setOnClickListener(this);
        fab_setting.setVisibility(View.GONE);

        mTabLayout = (TabLayout) findViewById(R.id.mTableLayout);
        mViewPager = (ViewPager) findViewById(R.id.mViewpager);

        //ViewPager预加载多少项
        mViewPager.setOffscreenPageLimit(mFragment.size());
        //ViewPager滑动监听
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            //正在滑动时候的监听
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            //page切换的监听就是page被选中的监听
            @Override
            public void onPageSelected(int position) {

                if (position == 0) {
                    fab_setting.setVisibility(View.GONE);
                } else {
                    fab_setting.setVisibility(View.VISIBLE);
                }
            }

            // 滑动切换的监听
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //设置ViewPager的适配器
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            //选中的item
            @Override
            public Fragment getItem(int position) {
                return mFragment.get(position);
            }

            //返回item的个数
            @Override
            public int getCount() {
                return mFragment.size();
            }

            //设置标题
            @Override
            public CharSequence getPageTitle(int position) {
                return mTitle.get(position);
            }
        });

        //给Tablayout最后给绑定ViewPager
        mTabLayout.setupWithViewPager(mViewPager);
    }


    //初始化数据
    private void intitData() {
        mTitle = new ArrayList<>();
        mTitle.add("服务管家");
        mTitle.add("微信精选");
        mTitle.add("美女社区");
        mTitle.add("个人中心");

        mFragment = new ArrayList<>();
        mFragment.add(new MainFragment());
        mFragment.add(new SecondFragment());
        mFragment.add(new ThirdFragment());
        mFragment.add(new FourFragment());
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fab_setting:
                startActivity(new Intent(this, SettingActivity.class));
                break;
        }
    }
}
