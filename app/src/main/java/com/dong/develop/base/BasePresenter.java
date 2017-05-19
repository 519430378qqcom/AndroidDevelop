package com.dong.develop.base;

/**
 * Created by dong on 2017/5/19.
 */

public abstract class BasePresenter<V extends BaseView>{
    private V mView;
    public void attachView(V view){
        mView = view;
        start();
    }

    public void detachView(){
        mView = null;
    }

    /**
     * presenter启动方法
     */
    protected abstract void start();
}
