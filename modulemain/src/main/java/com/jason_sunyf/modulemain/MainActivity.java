package com.jason_sunyf.modulemain;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.jason_sunyf.core.base.BaseActivity;
import com.jason_sunyf.moduletraffic.MainTrafficActivity;
import com.jason_sunyf.moudlewhether.whether.MainWhetherActivity;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private Button btn1, btn2, btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActionBarTitleTv.setText("模块化项目");
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
    }

    @Override
    protected void initPresenter() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initDataAndEvent() {

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn1) {
            startActivity(MainWhetherActivity.class);
        } else if (v.getId() == R.id.btn2) {
            startActivity(MainTrafficActivity.class);
        } else if (v.getId() == R.id.btn3) {
            startActivity(MainTrafficActivity.class);
        }
    }
}
