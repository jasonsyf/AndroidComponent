package com.jason_sunyf.moudlewhether.whether

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.facade.callback.NavCallback
import com.alibaba.android.arouter.facade.callback.NavigationCallback
import com.alibaba.android.arouter.launcher.ARouter
import com.google.gson.Gson
import com.jason_sunyf.core.base.BaseActivity
import com.jason_sunyf.core.util.ToastUtil
import com.jason_sunyf.core.util.X
import com.jason_sunyf.moudlewhether.R
import com.jason_sunyf.moudlewhether.entity.Test
import com.jason_sunyf.moudlewhether.entity.WhetherByCity

@Route(path = "/whether/main")
class MainWhetherActivity : BaseActivity<WhetherPresenter>(), WhetherContract.View {
    private var mTextView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActionBarTitleTv.text = "天气模块"
        setContentView(R.layout.activity_main_whether)
        mPresenter.getWhetherData("郑州")
    }

    override fun initPresenter() {
        mPresenter = WhetherPresenter(this)
    }

    override fun initView() {
        mTextView = findViewById<View>(R.id.textView) as TextView
    }

    override fun initDataAndEvent() {
        mTextView!!.setOnClickListener {
            //                 1. 应用内简单的跳转(通过URL跳转在'进阶用法'中)
            //                ARouter.getInstance().build("/traffic/main").navigation(MainWhetherActivity.this)
            //                 2. 跳转并携带参数
            ARouter.getInstance().build("/traffic/main")
                    .withString("jason", "我是跳转后传过去的数据")
                    .navigation()
        }
    }

    override fun showWhetherData(whetherByCity: WhetherByCity) {
        Toast.makeText(this, "成功", Toast.LENGTH_SHORT).show()
        mTextView!!.text = Gson().toJson(whetherByCity)
    }
}
