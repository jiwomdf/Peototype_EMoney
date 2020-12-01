package com.programmergabut.peototype_emoney

import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_ewalet_payment.*
import kotlinx.android.synthetic.main.activity_ewalet_payment.iv_notification

class EwaletPayment : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ewalet_payment)

        setLogo()
        setListener()
    }

    private fun setLogo(){
        Glide.with(this).load(R.drawable.logo_shopee).into(iv_shopee)
        Glide.with(this).load(R.drawable.logo_gopay).into(iv_gopay)
        Glide.with(this).load(R.drawable.logo_ovo).into(iv_ovo)
    }

    private fun setListener(){
        iv_back.setOnClickListener {
            finish()
        }
        iv_notification.setOnClickListener {
            gotoIntent(NotificationActivity::class.java, null , false)
        }
        tr_shopee.setOnClickListener {

            val bundle = Bundle()
            bundle.putInt(SecurityCode.DRAWABLE, R.drawable.logo_shopee)
            bundle.putString(SecurityCode.PLATFORM_NAME, "Shopee Pay")

            gotoIntent(SecurityCode::class.java, bundle, false)
        }
        tr_gopay.setOnClickListener {

            val bundle = Bundle()
            bundle.putInt(SecurityCode.DRAWABLE, R.drawable.logo_gopay)
            bundle.putString(SecurityCode.PLATFORM_NAME, "GoPay")

            gotoIntent(SecurityCode::class.java, bundle, false)
        }
        tr_ovo.setOnClickListener {

            val bundle = Bundle()
            bundle.putInt(SecurityCode.DRAWABLE, R.drawable.logo_ovo)
            bundle.putString(SecurityCode.PLATFORM_NAME, "OVO")

            gotoIntent(SecurityCode::class.java, bundle, false)
        }
    }

}