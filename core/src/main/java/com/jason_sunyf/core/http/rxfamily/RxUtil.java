package com.jason_sunyf.core.http.rxfamily;


import android.util.Log;

import com.google.gson.Gson;
import com.jason_sunyf.core.http.exception.ApiException;
import com.jason_sunyf.core.http.response.BaseResponse;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.FlowableTransformer;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Jason_Sunyf on 2017/12/9 0009.
 * Email： jason_sunyf@163.com
 */
public class RxUtil {

//      ====================================Observable================================================
    /**
     * 统一线程处理
     *
     * @param <T>
     * @return
     */
    public static <T> ObservableTransformer<T, T> rxObserverSchedulerHelper() {    //compose简化线程
        return new ObservableTransformer<T, T>() {
            @Override
            public Observable<T> apply(Observable<T> observable) {
                return observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
    /**
     * 统一返回结果处理
     *
     * @param <T>
     * @return
     */

    public static <T> ObservableTransformer<BaseResponse<T>,T > handleObserverResult() {   //compose判断结果
        return httpResponseFlowable -> httpResponseFlowable.flatMap(tBaseResponse -> {
            if (tBaseResponse.isOk()) {

                Log.i("onNext", "onNext: "+new Gson().toJson(tBaseResponse));
                return createObserverData(tBaseResponse.getValue());
            } else {
                return Observable.error(new ApiException(tBaseResponse.getMessage(), tBaseResponse.getCode()));
            }
        });
    }

    /**
     * 统一返回结果处理
     *
     * @param <T>
     * @return
     */
    public static <T> ObservableTransformer<BaseResponse<T>,T > handleObserverObjectResult() {   //compose判断结果
        return httpResponseFlowable -> httpResponseFlowable.flatMap(tBaseResponse -> {
            if (tBaseResponse.isOk()) {
                return createObserverData((T) tBaseResponse);
            } else {
                return Observable.error(new ApiException(tBaseResponse.getMessage(), tBaseResponse.getCode()));
            }
        });
    }

    /**
     * 生成Flowable
     *
     * @param t baseresponse
     * @return
     */
    public static <T> Observable<T> createObserverData(final T t) {
        return Observable.create(new ObservableOnSubscribe<T>() {
            @Override
            public void subscribe(ObservableEmitter<T> emitter) throws Exception {
                try {
                    emitter.onNext(t);
                    emitter.onComplete();
                } catch (Exception e) {
                    emitter.onError(e);
                }
            }
        });
    }

//      ====================================Flowable================================================
    /**
     * 统一线程处理
     *
     * @param <T>
     * @return
     */
    public static <T> FlowableTransformer<T, T> rxSchedulerHelper() {    //compose简化线程
        return new FlowableTransformer<T, T>() {
            @Override
            public Flowable<T> apply(Flowable<T> tFlowable) {
                return tFlowable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    /**
     * 统一返回结果处理
     *
     * @param <T>
     * @return
     */
    public static <T> FlowableTransformer<BaseResponse<T>,T > handleResult() {   //compose判断结果
        return httpResponseFlowable -> httpResponseFlowable.flatMap(tBaseResponse -> {
            if (tBaseResponse.isOk()) {
                Log.i("onNext", "onNext: "+new Gson().toJson(tBaseResponse));
                return createData(tBaseResponse.getValue());
            } else {
                return Flowable.error(new ApiException(tBaseResponse.getMessage(), tBaseResponse.getCode()));
            }
        });
    }

    /**
     * 统一返回结果处理
     *
     * @param <T>
     * @return
     */
    public static <T> FlowableTransformer<BaseResponse<T>,T > handleObjectResult() {   //compose判断结果
        return httpResponseFlowable -> httpResponseFlowable.flatMap(tBaseResponse -> {
            if (tBaseResponse.isOk()) {
                return createData((T) tBaseResponse);
            } else {
                return Flowable.error(new ApiException(tBaseResponse.getMessage(), tBaseResponse.getCode()));
            }
        });
    }
 
    /**
     * 生成Flowable
     *
     * @param t baseresponse
     * @return
     */
    public static <T> Flowable<T> createData(final T t) {
        return Flowable.create(new FlowableOnSubscribe<T>() {
            @Override
            public void subscribe(FlowableEmitter<T> emitter) throws Exception {
                try {
                    emitter.onNext(t);
                    emitter.onComplete();
                } catch (Exception e) {
                    emitter.onError(e);
                }
            }
        }, BackpressureStrategy.BUFFER);
    }
}
