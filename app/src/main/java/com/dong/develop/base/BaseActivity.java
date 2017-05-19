package com.dong.develop.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.develop.core.utils.AppManager;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by dong on 2017/5/19.
 */

public abstract class BaseActivity extends AppCompatActivity{
    /**
     * ButterKnife返回的引用，用于unbind
     */
    private Unbinder bkBind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        AppManager.getInstance().addActivity(this);
        bkBind = ButterKnife.bind(this);
        initView(savedInstanceState);
    }


    /**
     * 获取布局id,base类反射布局时被调用
     * @return
     */
    protected abstract int getLayoutId();

    /**
     * 初始化视图
     */
    protected abstract void initView(@Nullable Bundle savedInstanceState);

    @Override
    protected void onDestroy() {
        bkBind.unbind();
        AppManager.getInstance().finishActivity(this);
        super.onDestroy();
    }
}
