package com.dong.develop.contract;

import com.dong.develop.base.BasePresenter;
import com.dong.develop.base.IBaseView;

/**
 * Created by dong on 2017/5/19.
 */

public interface MainActivityContract {
    abstract class Presenter<V extends IView> extends BasePresenter<V>{

    }
    interface IView extends IBaseView {}

}
