package com.jason_sunyf.moudlewhether.whether;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.google.gson.Gson;
import com.jason_sunyf.core.base.BaseActivity;
import com.jason_sunyf.core.util.ToastUtil;
import com.jason_sunyf.core.util.X;
import com.jason_sunyf.moudlewhether.R;
import com.jason_sunyf.moudlewhether.entity.WhetherByCity;

@Route(path = "/whether/main")
public class MainWhetherActivity extends BaseActivity<WhetherPresenter> implements WhetherContract.View {
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActionBarTitleTv.setText("天气模块");
        setContentView(R.layout.activity_main_whether);
        mPresenter.getWhetherData("郑州");
    }

    @Override
    protected void initPresenter() {
        mPresenter = new WhetherPresenter(this);
    }

    @Override
    protected void initView() {
        mTextView = (TextView) findViewById(R.id.textView);
    }

    @Override
    protected void initDataAndEvent() {
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 1. 应用内简单的跳转(通过URL跳转在'进阶用法'中)
                X.Ext.init(getApplication());
                ARouter.init(getApplication());
                ARouter.getInstance().build("/traffic/main").navigation(MainWhetherActivity.this, new NavigationCallback() {
                    @Override
                    public void onFound(Postcard postcard) {
                        ToastUtil.showToast("找到了目标页面");
                    }

                    @Override
                    public void onLost(Postcard postcard) {
                        ToastUtil.showToast("降级");
                    }

                    @Override
                    public void onArrival(Postcard postcard) {
                        ToastUtil.showToast("到达了目标页面");
                    }

                    @Override
                    public void onInterrupt(Postcard postcard) {
                        ToastUtil.showToast("截取了目标页面");
                    }
                });
                // 2. 跳转并携带参数
//                ARouter.getInstance().build("/test/1")
//                        .withLong("key1", 666L)
//                        .withString("key3", "888")
//                        .withObject("key4", new Test("Jack", "Rose"))
//                        .navigation();
            }
        });
    }

    @Override
    public void showWhetherData(WhetherByCity whetherByCity) {
        Toast.makeText(this, "成功", Toast.LENGTH_SHORT).show();
        mTextView.setText(new Gson().toJson(whetherByCity));
    }
}
