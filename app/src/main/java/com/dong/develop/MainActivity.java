package com.dong.develop;


import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.dong.develop.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.vp_container)
    ViewPager vpContainer;
    //    @BindView(R.id.rb_home)
//    RadioButton rbHome;
//    @BindView(R.id.rb_my)
//    RadioButton rbMy;
//    @BindView(R.id.rg_bottom)
//    RadioGroup rgBottom;
    @BindView(R.id.bottom_navigation_bar)
    BottomNavigationBar bottomNavigationBar;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
//        switchBottomStatus(R.id.rb_home);
        bottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.ic_main_home,R.string.home))
                .addItem(new BottomNavigationItem(R.drawable.ic_main_my,R.string.my))
                .setFirstSelectedPosition(0)
                .initialise();
    }

    /**
     * 切换底部按钮的状态
     *
     * @param id
     */
    private void switchBottomStatus(int id) {
//        switch (id) {
//            case R.id.rb_home:
//                rbHome.setTextColor(Color.parseColor("#ff6600"));
//                break;
//        }
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
