package com.jason_sunyf.modulemain

import android.os.Bundle
import android.view.View
import android.widget.Button
import com.jason_sunyf.core.base.BaseActivity
import com.jason_sunyf.core.base.BasePresenter
import com.jason_sunyf.moduletraffic.MainTrafficActivity
import com.jason_sunyf.moudlewhether.whether.MainWhetherActivity

class MainActivity : BaseActivity<BasePresenter<*>>(), View.OnClickListener {
    private var btn1: Button? = null
    private var btn2: Button? = null
    private var btn3: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActionBarTitleTv.text = "模块化项目"
        setContentView(R.layout.activity_main)
        btn1 = findViewById<View>(R.id.btn1) as Button
        btn2 = findViewById<View>(R.id.btn2) as Button
        btn3 = findViewById<View>(R.id.btn3) as Button
        btn1!!.setOnClickListener(this)
        btn2!!.setOnClickListener(this)
        btn3!!.setOnClickListener(this)
    }

    override fun initPresenter() {

    }

    override fun initView() {

    }

    override fun initDataAndEvent() {

    }

    override fun onClick(v: View) {
        if (v.id == R.id.btn1) {
            startActivity(MainWhetherActivity::class.java)
        } else if (v.id == R.id.btn2) {
            startActivity(MainTrafficActivity::class.java)
        } else if (v.id == R.id.btn3) {
            startActivity(MainTrafficActivity::class.java)
        }
    }
}
