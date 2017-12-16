package com.jason_sunyf.core.base;


import android.content.Context;
import android.os.Bundle;

/**
 * view接口基类
 * Created by Jason_Sunyf on 2017/12/16 0016.
 * Email： jason_sunyf@163.com
 */

public  interface BaseView {

    void showErrorMsg(String msg);

    void showLoading();

    void hiddenLoading();

    /**
     * 跳转有参数传递的activity
     *
     * @param tClass 跳转的界面
     * @param bundle 参数
     */
    void startActivity(Class<?> tClass, Bundle bundle);

    /**
     * 跳转activity
     *
     * @param tClass 跳转的界面
     */
    void startActivity(Class<?> tClass);

    /**
     * 跳转有参数传递且有返回结果的activity
     */
    void startActivityForResult(Class<?> tClass, Bundle bundle, int requestCode);

    /**
     * 跳转activity带返回结果
     */
    void startActivityForResult(Class<?> tClass, int requestCode);

    /**
     * 获取上下文
     *
     * @return 上下文
     */
    Context getContext();

}

