package com.programmergabut.peototype_emoney

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setListener()
    }


    private fun setListener() {
        tv_login.setOnClickListener {
            gotoIntent(LoginActivity::class.java, null, false)
        }
        tv_sign_up.setOnClickListener {
            gotoIntent(RegisterActivity::class.java, null, false)
        }
    }



}