package com.dong.develop.base;


import com.trello.rxlifecycle2.LifecycleTransformer;

/**
 * Created by dong on 2017/5/19.
 */

public interface IBaseView {
    /**
     * 显示加载动画
     */
    void showLoading();

    /**
     * 绑定生命周期
     * @param <T>
     * @return
     */
     <T> LifecycleTransformer<T> bindToLifecycle();
}
