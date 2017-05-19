package com.dong.develop.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;


/**
 * Created by dong on 2017/5/19.
 */

public abstract class LazyFragment extends BaseFrament{
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
    protected Boolean isFirstLoad = false;
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view,savedInstanceState);
        isInitView = true;
        initData();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        this.isVisibleToUser = isVisibleToUser;
        initData();
    }

    protected abstract void lazyLoad();

    private void initData() {
        if(isVisibleToUser&&isInitView&&isFirstLoad) {
            lazyLoad();
            isFirstLoad = false;
        }
    }
}
