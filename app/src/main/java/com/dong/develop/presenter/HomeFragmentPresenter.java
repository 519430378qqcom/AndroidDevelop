package com.dong.develop.presenter;

import com.dong.develop.bean.UmiIndex;
import com.dong.develop.contract.HomeFragmentContract;
import com.dong.develop.net.RetrofitManager;
import com.dong.develop.net.UmiApi;

import org.reactivestreams.Subscription;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by dong on 2017/5/22.
 */

public class HomeFragmentPresenter extends HomeFragmentContract.Presenter<HomeFragmentContract.IView>{
    @Override
    public void getData() {
        final UmiApi umiApi = RetrofitManager.umiApi;
        umiApi.getIndex()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(getView().<UmiIndex>bindToLifecycle())
                .doOnSubscribe(new Consumer<Subscription>() {
                    @Override
                    public void accept(@NonNull Subscription subscription) throws Exception {
                        if (isAttach()) {
                            getView().showLoading();
                        }
                    }
                })
                .doOnComplete(new Action() {
                    @Override
                    public void run() throws Exception {

                    }
                })
                .subscribe(new Consumer<UmiIndex>() {
                    @Override
                    public void accept(@NonNull UmiIndex umiIndex) throws Exception {
                        if (isAttach()) {
                            getView().index(umiIndex);
                        }
                    }
                });
    }
}
