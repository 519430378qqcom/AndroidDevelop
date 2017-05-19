package com.dong.develop.contract;

import com.dong.develop.base.BasePresenter;
import com.dong.develop.base.BaseView;

/**
 * Created by dong on 2017/5/19.
 */

public interface MainActivityContract {
    abstract class MPresenter<V extends MView> extends BasePresenter<V>{

    }
    interface MView extends BaseView {}
}
