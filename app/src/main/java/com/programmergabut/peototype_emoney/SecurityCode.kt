package com.programmergabut.peototype_emoney

import android.os.Bundle
import android.view.View
import androidx.core.content.res.ResourcesCompat
import kotlinx.android.synthetic.main.activity_security_code.*

class SecurityCode : BaseActivity(), View.OnClickListener {

    private var counter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_security_code)

        setListener()
    }

    private fun setListener(){
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
                if(++counter >= 5)
                    gotoIntent(HomeActivity::class.java, null, false)
            }
        }

        when(counter){
            0 -> {
                iv_c_1.setImageResource(R.drawable.ic_circle_white)
                iv_c_2.setImageResource(R.drawable.ic_circle_white)
                iv_c_3.setImageResource(R.drawable.ic_circle_white)
                iv_c_4.setImageResource(R.drawable.ic_circle_white)
                iv_c_5.setImageResource(R.drawable.ic_circle_white)
                iv_c_6.setImageResource(R.drawable.ic_circle_white)
            }
            1 -> {
                iv_c_1.setImageResource(R.drawable.ic_circle_orange)
                iv_c_2.setImageResource(R.drawable.ic_circle_white)
                iv_c_3.setImageResource(R.drawable.ic_circle_white)
                iv_c_4.setImageResource(R.drawable.ic_circle_white)
                iv_c_5.setImageResource(R.drawable.ic_circle_white)
                iv_c_6.setImageResource(R.drawable.ic_circle_white)
            }
            2 -> {
                iv_c_1.setImageResource(R.drawable.ic_circle_orange)
                iv_c_2.setImageResource(R.drawable.ic_circle_orange)
                iv_c_3.setImageResource(R.drawable.ic_circle_white)
                iv_c_4.setImageResource(R.drawable.ic_circle_white)
                iv_c_5.setImageResource(R.drawable.ic_circle_white)
                iv_c_6.setImageResource(R.drawable.ic_circle_white)
            }
            3 -> {
                iv_c_1.setImageResource(R.drawable.ic_circle_orange)
                iv_c_2.setImageResource(R.drawable.ic_circle_orange)
                iv_c_3.setImageResource(R.drawable.ic_circle_orange)
                iv_c_4.setImageResource(R.drawable.ic_circle_white)
                iv_c_5.setImageResource(R.drawable.ic_circle_white)
                iv_c_6.setImageResource(R.drawable.ic_circle_white)
            }
            4 -> {
                iv_c_1.setImageResource(R.drawable.ic_circle_orange)
                iv_c_2.setImageResource(R.drawable.ic_circle_orange)
                iv_c_3.setImageResource(R.drawable.ic_circle_orange)
                iv_c_4.setImageResource(R.drawable.ic_circle_orange)
                iv_c_5.setImageResource(R.drawable.ic_circle_white)
                iv_c_6.setImageResource(R.drawable.ic_circle_white)
            }
            5 -> {
                iv_c_1.setImageResource(R.drawable.ic_circle_orange)
                iv_c_2.setImageResource(R.drawable.ic_circle_orange)
                iv_c_3.setImageResource(R.drawable.ic_circle_orange)
                iv_c_4.setImageResource(R.drawable.ic_circle_orange)
                iv_c_5.setImageResource(R.drawable.ic_circle_orange)
                iv_c_6.setImageResource(R.drawable.ic_circle_white)
            }
            6 -> {
                iv_c_1.setImageResource(R.drawable.ic_circle_orange)
                iv_c_2.setImageResource(R.drawable.ic_circle_orange)
                iv_c_3.setImageResource(R.drawable.ic_circle_orange)
                iv_c_4.setImageResource(R.drawable.ic_circle_orange)
                iv_c_5.setImageResource(R.drawable.ic_circle_orange)
                iv_c_6.setImageResource(R.drawable.ic_circle_orange)
            }
        }

        if(counter <= 0)
            counter = 0
    }

}