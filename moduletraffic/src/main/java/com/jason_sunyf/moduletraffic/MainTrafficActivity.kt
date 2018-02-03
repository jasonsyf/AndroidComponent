package com.jason_sunyf.moduletraffic

import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.jason_sunyf.core.base.BaseActivity
import com.jason_sunyf.core.base.BasePresenter

@Route(path = "/traffic/main") //aroute 定义路径
class MainTrafficActivity : BaseActivity<BasePresenter<*>>() {
    internal var mTextView: TextView? = null
    internal var s: String?=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActionBarTitleTv.text = "交通模块"
        setContentView(R.layout.activity_main_traffic)
    }

    override fun initPresenter() {

    }

    override fun initView() {
        mTextView = findViewById(R.id.traffic_text)
        s = intent.getStringExtra("jason")
        mTextView!!.text = s
    }

    override fun initDataAndEvent() {
        mTextView!!.setOnClickListener {
            // 1. 应用内简单的跳转(通过URL跳转在'进阶用法'中)
            ARouter.getInstance().build("/whether/main").navigation()
        }// 2. 跳转并携带参数
            //                ARouter.getInstance().build("/test/1")
            //                        .withLong("key1", 666L)
            //                        .withString("key3", "888")
            //                        .withObject("key4", new Test("Jack", "Rose"))
            //                        .navigation();
    }


}
