package com.dong.develop.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.develop.core.utils.ToastUtils;
import com.dong.develop.R;
import com.dong.develop.base.LazyFragment;
import com.dong.develop.utils.NDK;

/**
 * Created by dong on 2017/5/17.
 * 我的
 */

public class MyFragment extends LazyFragment {


    @Override
    protected void initView(View view, @Nullable Bundle savedInstanceState) {
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_my;
    }


    @Override
    protected void lazyLoad() {
        ToastUtils.showToast(mContext, NDK.getTime1());
    }

}
