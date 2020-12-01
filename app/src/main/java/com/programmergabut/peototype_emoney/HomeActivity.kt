package com.programmergabut.peototype_emoney

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setListener()
    }

    private fun setListener(){
        cl_home_2.setOnClickListener {
            gotoIntent(DebitPaymentActivity::class.java, null, false)
        }
        cv_ewalet.setOnClickListener {
            gotoIntent(EwaletPayment::class.java, null, false)
        }
    }


}