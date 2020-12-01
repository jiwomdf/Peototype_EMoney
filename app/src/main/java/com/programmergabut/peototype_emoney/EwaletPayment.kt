package com.programmergabut.peototype_emoney

import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_debit_payment.tr_bca
import kotlinx.android.synthetic.main.activity_debit_payment.tr_mandiri
import kotlinx.android.synthetic.main.activity_debit_payment.tr_mega
import kotlinx.android.synthetic.main.activity_ewalet_payment.*

class EwaletPayment : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ewalet_payment)

        setLogo()
        setListener()
    }

    private fun setLogo(){
        Glide.with(this).load(getDrawable(R.drawable.logo_shopee)).into(iv_shopee)
        Glide.with(this).load(getDrawable(R.drawable.logo_gopay)).into(iv_gopay)
        Glide.with(this).load(getDrawable(R.drawable.logo_ovo)).into(iv_ovo)
    }

    private fun setListener(){
        tr_bca.setOnClickListener {
            gotoIntent(DebitPaymentActivity::class.java, null, false)
        }
        tr_mandiri.setOnClickListener {
            gotoIntent(DebitPaymentActivity::class.java, null, false)
        }
        tr_mega.setOnClickListener {
            gotoIntent(DebitPaymentActivity::class.java, null, false)
        }
    }

}