package com.dong.develop.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.ParameterizedType;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by dong on 2017/5/19.
 */

public abstract class BaseFrament<V extends BaseView,P extends BasePresenter> extends Fragment{
    /**
     * fragment根布局
     */
    protected View rootView;
    /**
     * ButterKnife返回的引用，用于unbind
     */
    private Unbinder bkBind;
    protected P mPresenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(rootView == null) {
            rootView = inflater.inflate(getLayoutId(),container,false);
        }
        bkBind = ButterKnife.bind(this,rootView);
        mPresenter = getInstance(this,1);
        if(mPresenter instanceof BasePresenter) {
            mPresenter.attachView((V)this);
        }
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view,savedInstanceState);
    }
    /**
     * 初始化视图
     */
    protected abstract void initView(View view, @Nullable Bundle savedInstanceState);

    /**
     * 获取布局id，base类反射布局时被调用
     * @return
     */
    protected abstract int getLayoutId();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(mPresenter != null) mPresenter.detachView();
        if(bkBind != null) bkBind.unbind();
    }

    /**
     * 获取当前对象的泛型类，并为其创建实例
     * @param o 当前对象
     * @param i 泛型参数的位置
     * @param <T>
     * @return
     */
    public <T> T getInstance(Object o, int i) {
        try {
            return ((Class<T>) ((ParameterizedType) (o.getClass()
                    .getGenericSuperclass())).getActualTypeArguments()[i])
                    .newInstance();
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        return null;
    }
}
