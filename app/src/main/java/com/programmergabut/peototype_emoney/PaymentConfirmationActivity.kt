package com.programmergabut.peototype_emoney

import android.content.Intent
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_payment_confirmation.*

class PaymentConfirmationActivity : BaseActivity(), View.OnClickListener {

    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_confirmation)


        tv_store_name.text = NAMATOKO
        tv_store_name_and_price.text = "$PESANAN\n$HARGA_PESANAN"

        setListener()
    }

    private fun setListener() {
        t9_key_1.setOnClickListener(this)
        t9_key_2.setOnClickListener(this)
        t9_key_3.setOnClickListener(this)
        t9_key_4.setOnClickListener(this)
        t9_key_5.setOnClickListener(this)
        t9_key_6.setOnClickListener(this)
        t9_key_7.setOnClickListener(this)
        t9_key_8.setOnClickListener(this)
        t9_key_9.setOnClickListener(this)
        t9_key_0.setOnClickListener(this)
        t9_key_backspace.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.t9_key_backspace -> {
                counter -= 1
            }
            else -> {
                if(++counter >= 5){
                    val intent = Intent(this, SuccessActivity::class.java)
                    val bundle = Bundle()
                    bundle.putString(SuccessActivity.HARGA, HARGA_PESANAN)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    intent.putExtras(bundle)
                    startActivity(intent)
                }

            }
        }

        if(counter <= 0)
            counter = 0
    }


}