package com.programmergabut.peototype_emoney

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_debit_payment.*

class DebitPaymentActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_debit_payment)

        setLogo()
        setListener()
    }

    private fun setLogo(){
        Glide.with(this).load(getDrawable(R.drawable.logo_bca)).into(iv_bca)
        Glide.with(this).load(getDrawable(R.drawable.logo_mandiri)).into(iv_mandiri)
        Glide.with(this).load(getDrawable(R.drawable.logo_mega)).into(iv_mega)
    }

    private fun setListener(){
        iv_back.setOnClickListener {
            finish()
        }
        iv_notification.setOnClickListener {
            gotoIntent(NotificationActivity::class.java, null , false)
        }
        tr_bca.setOnClickListener {

            val b = Bundle()
            b.putInt(PaymentQRActivity.DRAWABLE, R.drawable.logo_bca)
            b.putString(PaymentQRActivity.USERNAME, USERNAME)
            b.putString(PaymentQRActivity.NOREK, NOREK)

            gotoIntent(PaymentQRActivity::class.java, b, false)
        }
        tr_mandiri.setOnClickListener {

            val b = Bundle()
            b.putInt(PaymentQRActivity.DRAWABLE, R.drawable.logo_mandiri)
            b.putString(PaymentQRActivity.USERNAME, USERNAME)
            b.putString(PaymentQRActivity.NOREK, NOREK)

            gotoIntent(PaymentQRActivity::class.java, b, false)
        }
        tr_mega.setOnClickListener {

            val b = Bundle()
            b.putInt(PaymentQRActivity.DRAWABLE, R.drawable.logo_mega)
            b.putString(PaymentQRActivity.USERNAME, USERNAME)
            b.putString(PaymentQRActivity.NOREK, NOREK)

            gotoIntent(PaymentQRActivity::class.java, b, false)
        }
    }

}