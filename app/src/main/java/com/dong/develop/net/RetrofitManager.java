package com.dong.develop.net;

import android.support.annotation.NonNull;

import com.dong.develop.MyApplication;
import com.orhanobut.logger.Logger;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dong on 2017/6/9.
 */

public class RetrofitManager {
    /**
     *避免出现 HTTP 403 Forbidden，参考：http://stackoverflow.com/questions/13670692/403-forbidden-with-java-but-not-web-browser
     */
    public static final String AVOID_HTTP403_FORBIDDEN = "User-Agent: Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11";
    public static final String LOG_HTTP = "HTTPTAG";
    public static INewsApi iNewsApi;
    public static UmiApi umiApi;
    /**
     * 初始化Retrofit
     */
    public static void init() {
        // 指定缓存路径,缓存大小100Mb
        Cache cache = new Cache(new File(MyApplication.mContext.getCacheDir(), "HttpCache"),
                1024 * 1024 * 100);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().cache(cache)
                .retryOnConnectionFailure(true)
                .addInterceptor(logInterceptor)
//                .addInterceptor(sRewriteCacheControlInterceptor)
//                .addNetworkInterceptor(sRewriteCacheControlInterceptor)
                .connectTimeout(10, TimeUnit.SECONDS)
                .build();

        if (iNewsApi == null) {
            Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(INewsApi.INEW_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());
            Retrofit retrofit = builder.build();
            iNewsApi = retrofit.create(INewsApi.class);
        }
        if(umiApi == null) {
            Retrofit.Builder builder = new Retrofit.Builder()
                    .baseUrl(UmiApi.BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create());
            Retrofit retrofit = builder.build();
            umiApi = retrofit.create(UmiApi.class);
        }
    }
    /**
     * 打印返回的json数据拦截器
     */
    private static final Interceptor logInterceptor = new Interceptor() {

        @Override
        public Response intercept(Chain chain) throws IOException {
            final Request request = chain.request();
            Buffer requestBuffer = new Buffer();
            if (request.body() != null) {
                request.body().writeTo(requestBuffer);
            } else {
                Logger.d(LOG_HTTP, "request.body() == null");
            }
            //打印url信息
            Logger.d(LOG_HTTP,request.url() + (request.body() != null ? "?" + parseParams(request.body(), requestBuffer) : ""));
            final Response response = chain.proceed(request);
            return response;
        }
    };
    @NonNull
    private static String parseParams(RequestBody body, Buffer requestBuffer) throws UnsupportedEncodingException {
        if (body.contentType() != null && !body.contentType().toString().contains("multipart")) {
            return URLDecoder.decode(requestBuffer.readUtf8(), "UTF-8");
        }
        return "null";
    }
}
