package com.dong.develop.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by dong on 2017/5/16.
 */

public abstract class BaseActivity extends AppCompatActivity{

    protected Unbinder bkBind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        bkBind = ButterKnife.bind(this);
        initView();
        initData();
    }

    /**
     * 获取layout布局id
     * @return
     */
    protected abstract int getLayoutId();

    /**
     * 初始化视图
     */
    protected abstract void initView();

    /**
     * 初始化数据
     */
    protected void initData(){};

    @Override
    protected void onDestroy() {
        if(bkBind != null) {
            bkBind.unbind();
        }
        super.onDestroy();
    }
}
