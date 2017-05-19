package com.dong.develop.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.dong.develop.R;
import com.dong.develop.base.LazyFragment;
import com.dong.develop.contract.MainActivityContract;

/**
 * Created by dong on 2017/5/17.
 * 首页
 */

public class HomeFragment extends LazyFragment implements MainActivityContract.MView {
    @Override
    protected void initView(View view, @Nullable Bundle savedInstanceState) {
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void lazyLoad() {

    }
}
