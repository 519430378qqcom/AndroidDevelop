package com.dong.develop.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.develop.core.utils.AppManager;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import java.lang.reflect.ParameterizedType;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by dong on 2017/5/19.
 */

public abstract class BaseActivity<V extends IBaseView,P extends BasePresenter> extends RxAppCompatActivity {
    /**
     * ButterKnife返回的引用，用于unbind
     */
    private Unbinder bkBind;
    protected P mPresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        AppManager.getInstance().addActivity(this);
        bkBind = ButterKnife.bind(this);
        mPresenter = getInstance(this,1);
        if(mPresenter instanceof BasePresenter) {
            mPresenter.attachView((V)this);
        }
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
        super.onDestroy();
        if(mPresenter != null) mPresenter.detachView();
        if(bkBind != null) bkBind.unbind();
        AppManager.getInstance().finishActivity(this);
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
