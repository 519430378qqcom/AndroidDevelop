package com.dong.develop.net;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

import static com.dong.develop.net.RetrofitManager.AVOID_HTTP403_FORBIDDEN;

/**
 * Created by dong on 2017/6/9.
 */

public interface INewsApi {
    static final String INEW_BASE_URL = "http://c.3g.163.com/";

    /**
     * 获取专题
     * eg: http://c.3g.163.com/nc/special/S1451880983492.html
     * @param specialId 专题Id
     * @return
     */
    @Headers(AVOID_HTTP403_FORBIDDEN)
    @GET("nc/special/{specialId}.html")
    Call<ResponseBody> getSpecial(@Path("specialId") String specialId);
}
