package com.dong.develop.contract;

import com.dong.develop.base.BasePresenter;
import com.dong.develop.base.IBaseView;
import com.dong.develop.bean.UmiIndex;

/**
 * Created by dong on 2017/6/15.
 */

public interface HomeFragmentContract {
    abstract class Presenter<V extends IView> extends BasePresenter<V> {
    }

    interface IView extends IBaseView {
        void update(String text);

        void index(UmiIndex umiIndex);
    }
}
