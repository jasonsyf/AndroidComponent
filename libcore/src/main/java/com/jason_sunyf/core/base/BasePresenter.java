package com.jason_sunyf.core.base;

/**
 * Created by Jason_Sunyf on 2017/12/16 0016.
 * Email： jason_sunyf@163.com
 */

public interface BasePresenter<T extends BaseView> {

    void attachView(T view);

    void detachView();
}
