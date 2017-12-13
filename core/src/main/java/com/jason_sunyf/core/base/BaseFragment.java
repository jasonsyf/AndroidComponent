package com.jason_sunyf.core.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jason_sunyf.core.http.rxfamily.RxPresenter;

/**
 * Created by jerry on 2017/11/3.
 */

public abstract class BaseFragment<T extends BasePresenter> extends Fragment implements BaseView {
    protected T mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initPresenter();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
        super.onViewCreated(view, savedInstanceState);
    }

    protected abstract void initPresenter();

    @Override
    public void onDestroyView() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroyView();
    }

    /**
     * Created by LWH at 2017/4/7 0007 下午 2:35
     * 跳转有参数传递的界面
     */
    public void startActivity(Class<?> tClass, Bundle bundle) {
        Intent intent = new Intent(getContext(), tClass);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * Created by LWH at 2017/4/7 0007 下午 2:36
     * 跳转界面
     */
    public void startActivity(Class<?> tClass) {
        Intent intent = new Intent(getContext(), tClass);
        startActivity(intent);
    }

    public void startActivityForResult(Class<?> tClass, Bundle bundle, int requestCode) {
        Intent intent = new Intent(getContext(), tClass);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }

    public void startActivityForResult(Class<?> tClass, int requestCode) {
        Intent intent = new Intent(getContext(), tClass);
        startActivityForResult(intent, requestCode);
    }

    @Override
    public void showErrorMsg(String msg) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hiddenLoading() {

    }

    /**
     * Created by LWH at 2017/4/7 0007 下午 2:37
     * 获取页面上下文
     */
    @Override
    public Context getContext() {
        return getActivity();
    }
}
