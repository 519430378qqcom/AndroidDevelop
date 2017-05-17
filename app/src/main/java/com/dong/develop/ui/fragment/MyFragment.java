package com.dong.develop.ui.fragment;

import android.support.v7.widget.CardView;
import android.view.View;

import com.dong.develop.R;
import com.dong.develop.base.LazyFragment;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by dong on 2017/5/17.
 * 我的
 */

public class MyFragment extends LazyFragment {
    @BindView(R.id.iv_my_head)
    CircleImageView ivMyHead;
    @BindView(R.id.cd_my_head)
    CardView cdMyHead;
    @BindView(R.id.cd_my_about)
    CardView cdMyAbout;
    @BindView(R.id.cd_my_setting)
    CardView cdMySetting;
    Unbinder unbinder;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_my;
    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.iv_my_head, R.id.cd_my_head, R.id.cd_my_about, R.id.cd_my_setting})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_my_head:
                break;
            case R.id.cd_my_head:
                break;
            case R.id.cd_my_about:
                break;
            case R.id.cd_my_setting:
                break;
        }
    }
}