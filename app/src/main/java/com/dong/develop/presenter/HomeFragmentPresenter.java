package com.dong.develop.presenter;

import com.dong.develop.api.RetrofitManager;
import com.dong.develop.contract.MainContract;
import com.orhanobut.logger.Logger;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by dong on 2017/5/22.
 */

public class HomeFragmentPresenter extends MainContract.HomePresenter<MainContract.HomeView>{
    @Override
    public void start() {
        Call<ResponseBody> call = RetrofitManager.iNewsApi.getSpecial("S1451880983492");
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Logger.t("Manager");
                Logger.e(response.body().toString());
                if(isAttach()) {
                    getView().update(response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
}
