package com.jason_sunyf.moduletraffic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.jason_sunyf.core.base.BaseActivity;

@Route(path = "/traffic/main") //aroute 定义路径
public class MainTrafficActivity extends BaseActivity {
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActionBarTitleTv.setText("交通模块");
        setContentView(R.layout.activity_main_traffic);
    }

    @Override
    protected void initPresenter() {

    }

    @Override
    protected void initView() {
        mTextView = findViewById(R.id.traffic_text);
    }

    @Override
    protected void initDataAndEvent() {
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 1. 应用内简单的跳转(通过URL跳转在'进阶用法'中)
                ARouter.getInstance().build("/whether/main").navigation();
                // 2. 跳转并携带参数
//                ARouter.getInstance().build("/test/1")
//                        .withLong("key1", 666L)
//                        .withString("key3", "888")
//                        .withObject("key4", new Test("Jack", "Rose"))
//                        .navigation();
            }
        });
    }
}