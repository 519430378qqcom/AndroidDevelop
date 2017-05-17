package com.dong.develop.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by dong on 2017/5/17.
 */

public abstract class LazyFragment extends BaseFragment{
    /**
     * fragment是否可见
     */
    protected boolean isVisibleToUser;
    /**
     * view是否初始化完成
     */
    protected boolean isInitView;
    /**
     * 是否第一次加载数据
     */
    protected boolean isFirstLoad = true;
    private Unbinder bkBind;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        this.isVisibleToUser = isVisibleToUser;
        lazyLoad();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(getLayoutId(), container, false);
        bkBind = ButterKnife.bind(inflate);
        isInitView = true;
        lazyLoad();
        return inflate;
    }

    /**
     * 返回需要加载的布局id
     * @return
     */
    protected abstract int getLayoutId();

    private void lazyLoad() {
        if(isVisibleToUser && isInitView && isFirstLoad) {
            initData();
            isFirstLoad = false;
        }
    }

    /**
     * 加载数据，在懒加载判断成功后会被调用一次
     */
    protected abstract void initData();

    @Override
    public void onDestroyView() {
        if(bkBind != null) {
            bkBind.unbind();
        }
        super.onDestroyView();
    }
}
