package com.dong.develop.ui.activity;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.dong.develop.R;
import com.dong.develop.adapter.MainAdapter;
import com.dong.develop.base.BaseActivity;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.vp_container)
    ViewPager vpContainer;
    @BindView(R.id.bottom_navigation_bar)
    BottomNavigationBar bottomNavigationBar;
    private MainAdapter mainAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        vpContainer.setOffscreenPageLimit(1);
        bottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.ic_main_home, R.string.home))
                .addItem(new BottomNavigationItem(R.drawable.ic_main_test, R.string.home))
                .addItem(new BottomNavigationItem(R.drawable.ic_main_my, R.string.my))
                .setTabSelectedListener(bottomNavigationBarListener)
                .setInActiveColor(R.color.black_9)//未选中时的颜色
                .setActiveColor(R.color.colorAccent)//选中时的颜色
                .setMode(BottomNavigationBar.MODE_FIXED)
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
                .setFirstSelectedPosition(0)
                .initialise();
        if (mainAdapter == null) {
            mainAdapter = new MainAdapter(getSupportFragmentManager());
        }
        vpContainer.setAdapter(mainAdapter);
    }

    private BottomNavigationBar.OnTabSelectedListener bottomNavigationBarListener = new BottomNavigationBar.OnTabSelectedListener() {

        @Override
        public void onTabSelected(int position) {
            vpContainer.setCurrentItem(position, true);
        }

        @Override
        public void onTabUnselected(int position) {

        }

        @Override
        public void onTabReselected(int position) {

        }
    };
}
