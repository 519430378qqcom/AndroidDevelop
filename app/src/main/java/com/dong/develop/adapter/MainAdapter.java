package com.dong.develop.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.dong.develop.ui.fragment.HomeFragment;
import com.dong.develop.ui.fragment.MyFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dong on 2017/5/17.
 */

public class MainAdapter extends FragmentPagerAdapter{
    private List<Fragment> fragmentList;
    public MainAdapter(FragmentManager fm) {
        super(fm);
        fragmentList = new ArrayList<>();
        fragmentList.add(new HomeFragment());
        fragmentList.add(new MyFragment());
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
