package com.dong.develop.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.dong.develop.R;
import com.dong.develop.base.LazyFragment;
import com.dong.develop.contract.MainContract;
import com.dong.develop.presenter.HomeFragmentPresenter;

import butterknife.BindView;

/**
 * Created by dong on 2017/5/17.
 * 首页
 */

public class HomeFragment extends LazyFragment<MainContract.HomeView, HomeFragmentPresenter> implements MainContract.HomeView {
    @BindView(R.id.tv)
    TextView tv;

    @Override
    protected void initView(View view, @Nullable Bundle savedInstanceState) {
//        Observable.create(new ObservableOnSubscribe<String>(){
//
//            @Override
//            public void subscribe(@NonNull ObservableEmitter<String> e) throws Exception {
//
//            }
//        }).subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<String>() {
//                    @Override
//                    public void accept(@NonNull String s) throws Exception {
//
//                    }
//                });
//        Observable.just("123","123");
//        Observable.fromArray("23","31");
//        Observable.fromCallable(new Callable<Object>() {
//            @Override
//            public Object call() throws Exception {
//                return new Object();
//            }
//        });
//        Observable.interval(0,1, TimeUnit.SECONDS)
//                .take(3)
//                .map(new Function<Long, Long>() {
//                    @Override
//                    public Long apply(@NonNull Long aLong) throws Exception {
//                        return aLong+1;
//                    }
//                })
//                .doOnSubscribe(new Consumer<Disposable>() {
//                    @Override
//                    public void accept(@NonNull Disposable disposable) throws Exception {
//                        tv.setText("ada");
//                    }
//                });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initData() {
        mPresenter.start();
    }

    @Override
    public void update(String text) {
        tv.setText(text);
    }
}
