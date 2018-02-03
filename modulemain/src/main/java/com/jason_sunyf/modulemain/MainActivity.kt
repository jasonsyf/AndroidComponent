package com.jason_sunyf.modulemain

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.jason_sunyf.core.base.BaseActivity
import com.jason_sunyf.core.base.BasePresenter
import com.jason_sunyf.moduletraffic.MainTrafficActivity
import com.jason_sunyf.moudlewhether.whether.MainWhetherActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<BasePresenter<*>>(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActionBarTitleTv.text = "模块化项目"
        setContentView(R.layout.activity_main)
        btn1!!.setOnClickListener(this)
        btn2!!.setOnClickListener(this)
        btn3!!.setOnClickListener(this)
    }

    override fun initPresenter() {

    }


    override fun initDataAndEvent() {

    }

    override fun onClick(v: View) {
        if (v.id == R.id.btn1) {
            startActivity(Intent(this, MainWhetherActivity::class.java))
        } else if (v.id == R.id.btn2) {
            startActivity(Intent(this, MainTrafficActivity::class.java))
        } else if (v.id == R.id.btn3) {
            startActivity(Intent(this, MainTrafficActivity::class.java))
        }
    }


}
