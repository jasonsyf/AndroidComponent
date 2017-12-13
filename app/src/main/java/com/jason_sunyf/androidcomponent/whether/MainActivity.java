package com.jason_sunyf.androidcomponent.whether;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.jason_sunyf.androidcomponent.R;
import com.jason_sunyf.androidcomponent.entity.WhetherByCity;
import com.jason_sunyf.core.base.BaseActivity;

public class MainActivity extends BaseActivity<WhetherPresenter> implements WhetherContract.View {
    private TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresenter.getWhetherData("郑州");
    }

    @Override
    protected void initPresenter() {
        mPresenter = new WhetherPresenter(this);
    }

    @Override
    protected void initView() {
        mTextView = findViewById(R.id.textView);
    }

    @Override
    protected void initDataAndEvent() {

    }

    @Override
    public void showWhetherData(WhetherByCity whetherByCity) {
        Toast.makeText(this, "成功", Toast.LENGTH_SHORT).show();
        mTextView.setText(new Gson().toJson(whetherByCity));
    }
}
