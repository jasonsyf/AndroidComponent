package com.jason_sunyf.moudlewhether.whether;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.google.gson.Gson;
import com.jason_sunyf.core.base.BaseActivity;
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
                ARouter.getInstance().build("/traffic/main").navigation();

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
