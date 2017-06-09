package com.dong.develop.api;

import retrofit2.Retrofit;

/**
 * Created by dong on 2017/6/9.
 */

public class RetrofitManager {
    public static INewsApi iNewsApi;

    /**
     * 初始化Retrofit
     */
    public static void init() {
        if (iNewsApi == null) {
            Retrofit.Builder builder = new Retrofit.Builder();
            builder.baseUrl(INewsApi.INEW_BASE_URL);
            Retrofit retrofit = builder.build();
            iNewsApi = retrofit.create(INewsApi.class);
        }
    }
}
