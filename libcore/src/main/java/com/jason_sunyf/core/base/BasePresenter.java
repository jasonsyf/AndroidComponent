package com.jason_sunyf.core.base;

/**
 * Created by jerry on 2017/11/3.
 */

public interface BasePresenter<T extends BaseView> {

    void attachView(T view);

    void detachView();
}
