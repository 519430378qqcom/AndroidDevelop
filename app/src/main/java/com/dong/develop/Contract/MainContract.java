package com.dong.develop.contract;

import com.dong.develop.base.BasePresenter;
import com.dong.develop.base.BaseView;

/**
 * Created by dong on 2017/5/19.
 */

public interface MainContract {
    abstract class MPresenter<V extends MView> extends BasePresenter<V>{

    }
    interface MView extends BaseView {}

    abstract class HomePresenter<V extends HomeView> extends BasePresenter<V>{
    }
    interface HomeView extends BaseView {
        void update(String text);
    }
}
