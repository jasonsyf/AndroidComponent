package com.jason_sunyf.core.http;


import com.jason_sunyf.core.appbase.Config;
import com.jason_sunyf.core.http.interceptor.LogInterceptor;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * the more diligent, the more luckier you are !
 * ---------------------------------------------
 * Created by StudyAbc on 2017/7/14.
 *
 * @des
 */

public class RetrofitUtil {
    private static Retrofit retrofit;

    public static Retrofit init() {
        if (retrofit == null) {
            synchronized (RetrofitUtil.class) {
                if (retrofit == null) {
                    retrofit = new Retrofit
                            .Builder()
                            .baseUrl(getBaseUrl())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .addConverterFactory(GsonConverterFactory.create())
                            .client(getClient())
                            .build();
                }
            }
        }
        return retrofit;
    }

    public static Class getService(Class clazz) {
        return clazz;
    }

    public static String getBaseUrl() {
        return Config.BaseIP;
    }

    /**
     * Created by LWH at 2017/8/24 00:16
     * 设置client和拦截器
     */
    private static OkHttpClient getClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(new LogInterceptor())
                .build();
    }
}
