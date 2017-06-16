package com.dong.develop.net;

import com.dong.develop.bean.UmiIndex;

import io.reactivex.Flowable;
import retrofit2.http.GET;

/**
 * Created by dong on 2017/6/13.
 */

public interface UmiApi {
    public static final String BASE_URL = "http://v.youmi.cn/";
    /**
     * http://v.youmi.cn/api8/index
     */
    @GET("api8/index")
    Flowable<UmiIndex> getIndex();
}
