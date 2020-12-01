package com.programmergabut.peototype_emoney

import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_payment_qr.*

class PaymentQRActivity : BaseActivity() {

    companion object {
        const val DRAWABLE = "drawable"
        const val USERNAME = "username"
        const val NOREK = "norek"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_qr)

        val b = intent.extras
        val d = b?.getInt(DRAWABLE)
        
        iv_logo.setImageDrawable()
        b?.getString(USERNAME)
        b?.getString(NOREK)

        Handler().postDelayed({
            gotoIntent(PaymentConfirmationActivity::class.java, null, false)
        }, 2000)
    }



}