package com.dong.develop.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.develop.core.utils.ToastUtils;
import com.dong.develop.R;
import com.dong.develop.base.LazyFragment;
import com.dong.develop.utils.NDK;

import butterknife.BindView;

/**
 * Created by dong on 2017/6/1.
 */

public class TestFragment extends LazyFragment{
    @BindView(R.id.recycler_virtual)
    RecyclerView recycler_virtual;
    @Override
    protected void lazyLoad() {
        ToastUtils.showToast(mContext, NDK.getTime());
    }

    @Override
    protected void initView(View view, @Nullable Bundle savedInstanceState) {
        VirtualLayoutManager layoutManager = new VirtualLayoutManager(mContext);
        //设置回收复用池大小
        RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();
        recycledViewPool.setMaxRecycledViews(0,10);
        recycler_virtual.setLayoutManager(layoutManager);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_test;
    }
}
