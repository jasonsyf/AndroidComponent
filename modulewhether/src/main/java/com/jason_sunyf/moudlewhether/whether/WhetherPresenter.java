package com.jason_sunyf.moudlewhether.whether;

import android.util.Log;

import com.google.gson.Gson;

import com.jason_sunyf.core.base.BaseSubscriber;
import com.jason_sunyf.core.http.RetrofitUtil;
import com.jason_sunyf.core.http.rxfamily.RxPresenter;
import com.jason_sunyf.core.http.rxfamily.RxUtil;
import com.jason_sunyf.moudlewhether.apis.JuheApis;
import com.jason_sunyf.moudlewhether.entity.WhetherByCity;

/**
 *
 * @author Jason_Sunyf
 * @date 2017/12/14 0014
 * Email： jason_sunyf@163.com
 */

public class WhetherPresenter extends RxPresenter<WhetherContract.View> implements WhetherContract.Presenter {
    private WhetherContract.View mView;

    WhetherPresenter(WhetherContract.View view) {
        mView = view;
    }

    @Override
    public void getWhetherData(String cityname) {
        addSubscribe(RetrofitUtil.init().create(JuheApis.class)
                .getWhether(cityname,"3113bf386346db1f52e57ef6483cbac8")
                .compose(RxUtil.rxSchedulerHelper())
                .compose(RxUtil.handleResult())
                .subscribeWith(new BaseSubscriber<WhetherByCity>(mView) {
                    @Override
                    public void onNext(WhetherByCity whetherByCity) {
                        Log.i("WhetherByCity", "WhetherByCity: " + new Gson().toJson(whetherByCity));
                            mView.showWhetherData(whetherByCity);
                    }
                }));
    }
}
