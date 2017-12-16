package com.jason_sunyf.moudlewhether.apis;

import com.jason_sunyf.core.http.response.JhResponse;
import com.jason_sunyf.moudlewhether.entity.WhetherByCity;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Jason_Sunyf on 2017/12/13 0013.
 * Email： jason_sunyf@163.com
 */

public interface JuheApis {
    @GET("weather/index")
    Flowable<JhResponse<WhetherByCity>> getWhether(@Query("cityname") String cityname,
                                                   @Query("key") String key);

}