package com.dong.develop.ui.fragment;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.develop.core.utils.ToastUtils;
import com.dong.develop.R;
import com.dong.develop.base.LazyFragment;
import com.dong.develop.bean.UmiIndex;
import com.dong.develop.contract.HomeFragmentContract;
import com.dong.develop.net.RetrofitManager;
import com.dong.develop.net.UmiApi;
import com.dong.develop.presenter.HomeFragmentPresenter;
import com.dong.develop.utils.BusAction;
import com.hwangjr.rxbus.RxBus;
import com.hwangjr.rxbus.annotation.Subscribe;
import com.hwangjr.rxbus.annotation.Tag;
import com.hwangjr.rxbus.thread.EventThread;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by dong on 2017/5/17.
 * 首页
 */

public class HomeFragment extends LazyFragment<HomeFragmentContract.IView, HomeFragmentPresenter> implements HomeFragmentContract.IView {
    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.tv1)
    TextView tv1;
    RxPermissions rxPermissions;

    @Override
    protected void initView(View view, @Nullable Bundle savedInstanceState) {
        Observable.interval(4, 1, TimeUnit.SECONDS)
                .take(9)
                .observeOn(AndroidSchedulers.mainThread())
                .compose(this.<Long>bindToLifecycle())
                .map(new Function<Long, Long>() {
                    @Override
                    public Long apply(@NonNull Long aLong) throws Exception {
                        return aLong + 1;
                    }
                })
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(@NonNull Disposable disposable) throws Exception {
                        tv.setText("ada");
                    }
                })
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(@NonNull Long aLong) throws Exception {
                        RxBus.get().post(BusAction.TIMER, "rxbus" + aLong);
                        tv.setText(aLong + "");
                    }
                });
        UmiApi umiApi = RetrofitManager.umiApi;
        rxPermissions = new RxPermissions(getActivity());
        rxPermissions.request(Manifest.permission.CAMERA)
                .compose(this.<Boolean>bindToLifecycle())
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(@NonNull Boolean granted) throws Exception {
                        if (granted) {
                            tv.setText("成功");
                        } else {
                            tv.setText("失败");
                        }
                    }
                });
        tv1.setText((new Integer(1)==1)+"");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void lazyLoad() {
        mPresenter.getData();
    }

    @Override
    public void update(String text) {
        tv.setText(text);
    }

    @Override
    public void index(UmiIndex umiIndex) {
        tv.setText(umiIndex.getR().getSec_ask_title());
    }

    @Override
    public void showLoading() {

    }

    @Subscribe(thread = EventThread.MAIN_THREAD, tags = @Tag(BusAction.TIMER))
    public void timer(String s) {
        ToastUtils.showToast(mContext, s);
    }
}