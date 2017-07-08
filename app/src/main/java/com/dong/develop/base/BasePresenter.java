package com.dong.develop.base;

import java.lang.ref.SoftReference;

/**
 * Created by dong on 2017/5/19.
 */

public abstract class BasePresenter<V extends IBaseView>{
    /**
     * 对应view层的软引用
     */
    private SoftReference<V> softReference;
    public void attachView(V view){
       softReference = new SoftReference<V>(view);
    }

    public void detachView(){
        if(softReference != null) {
            softReference.clear();
        }
    }

    /**
     * 获取view层引用
     * @return
     */
    public V getView(){
        return softReference.get();
    }

    /**
     * view层引用是否存在
     * @return
     */
    public boolean isAttach(){
        return softReference.get() == null ? false : true;
    }
    /**
     * presenter默认的加载数据的方法
     */
    public abstract void getData();
}
