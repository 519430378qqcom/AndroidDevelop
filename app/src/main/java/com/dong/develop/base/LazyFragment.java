package com.dong.develop.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.orhanobut.logger.Logger;


/**
 * Created by dong on 2017/5/19.
 */

public abstract class LazyFragment<V extends IBaseView,P extends BasePresenter> extends BaseFrament<V,P>{
    /**
     * 是否可见
     */
    protected Boolean isVisibleToUser = false;
    /**
     * 布局是否初始化成功
     */
    protected Boolean isInitView = false;
    /**
     * 是否第一次加载
     */
    protected Boolean isFirstLoad = true;
    public Context mContext;
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view,savedInstanceState);
        mContext = getActivity();
        isInitView = true;
        initData();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        this.isVisibleToUser = isVisibleToUser;
        Logger.e("formLazyFragment->"+this.getClass().getSimpleName()+"---"+isVisibleToUser);
        initData();
    }

    /**
     * 实现懒加载方法加载数据
     */
    protected abstract void lazyLoad();

    private void initData() {
        if(isVisibleToUser&&isInitView&&isFirstLoad) {
            lazyLoad();
            isFirstLoad = false;
        }
    }
}
