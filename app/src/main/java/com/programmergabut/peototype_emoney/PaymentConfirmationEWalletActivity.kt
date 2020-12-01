package com.programmergabut.peototype_emoney

import android.content.Intent
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_payment_confirmation.*
import kotlinx.android.synthetic.main.activity_payment_confirmation.t9_key_0
import kotlinx.android.synthetic.main.activity_payment_confirmation.t9_key_1
import kotlinx.android.synthetic.main.activity_payment_confirmation.t9_key_2
import kotlinx.android.synthetic.main.activity_payment_confirmation.t9_key_3
import kotlinx.android.synthetic.main.activity_payment_confirmation.t9_key_4
import kotlinx.android.synthetic.main.activity_payment_confirmation.t9_key_5
import kotlinx.android.synthetic.main.activity_payment_confirmation.t9_key_6
import kotlinx.android.synthetic.main.activity_payment_confirmation.t9_key_7
import kotlinx.android.synthetic.main.activity_payment_confirmation.t9_key_8
import kotlinx.android.synthetic.main.activity_payment_confirmation.t9_key_9
import kotlinx.android.synthetic.main.activity_payment_confirmation.t9_key_backspace
import kotlinx.android.synthetic.main.activity_payment_confirmation_e_wallet.*

class PaymentConfirmationEWalletActivity : BaseActivity(), View.OnClickListener {

    private var showedTxt = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_confirmation_e_wallet)
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

        ll_confirm.setOnClickListener {
            val intent = Intent(this, SuccessActivity::class.java)
            val bundle = Bundle()
            bundle.putString(SuccessActivity.HARGA, HARGA_PESANAN)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.t9_key_backspace -> {
                if(showedTxt.isNotEmpty())
                    showedTxt = showedTxt.substring(0, showedTxt.length - 1)
            }
            R.id.t9_key_1 -> {
                showedTxt += "1"
            }
            R.id.t9_key_2 -> {
                showedTxt += "2"
            }
            R.id.t9_key_3 -> {
                showedTxt += "3"
            }
            R.id.t9_key_4 -> {
                showedTxt += "4"
            }
            R.id.t9_key_5 -> {
                showedTxt += "5"
            }
            R.id.t9_key_6 -> {
                showedTxt += "6"
            }
            R.id.t9_key_7 -> {
                showedTxt += "7"
            }
            R.id.t9_key_8 -> {
                showedTxt += "8"
            }
            R.id.t9_key_9 -> {
                showedTxt += "9"
            }
            R.id.t9_key_0 -> {
                showedTxt += "0"
            }
        }

        tv_showed_price.text = "Rp $showedTxt"
    }
}