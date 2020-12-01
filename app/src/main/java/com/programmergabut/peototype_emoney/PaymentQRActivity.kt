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

        val bundle = intent.extras

        iv_logo.setImageResource(bundle?.getInt(DRAWABLE) ?: 0)
        tv_username.text = bundle?.getString(USERNAME) ?: "username"
        tv_norek.text = bundle?.getString(NOREK) ?: "norek"

        Handler().postDelayed({
            gotoIntent(PaymentConfirmationActivity::class.java, null, false)
        }, 2000)
    }



}