package com.dong.develop.base;

import java.lang.ref.SoftReference;

/**
 * Created by dong on 2017/5/19.
 */

public abstract class BasePresenter<V extends BaseView>{
    private SoftReference<V> softReference;
    public void attachView(V view){
       softReference = new SoftReference<V>(view);
    }

    public void detachView(){
        if(softReference != null) {
            softReference.clear();
        }
    }

    public V getView(){
        return softReference.get();
    }
    public boolean isAttach(){
        return softReference.get() == null ? false : true;
    }
    /**
     * presenter启动方法
     */
    public abstract void start();
}
