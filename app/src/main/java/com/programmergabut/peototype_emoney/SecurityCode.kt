package com.programmergabut.peototype_emoney

import android.content.Intent
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_security_code.*

class SecurityCode : BaseActivity(), View.OnClickListener {

    private var counter = 0
    private var logo: Int? = null
    private var platformName: String? = null

    companion object {
        const val DRAWABLE = "drawable"
        const val PLATFORM_NAME = "PLATFORM_NAME"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_security_code)

        logo = intent.extras?.getInt(DRAWABLE)
        platformName = intent.extras?.getString(PLATFORM_NAME)

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
                if(++counter >= 5){

                    if(logo != null && platformName != null){

                        val bundle = Bundle()
                        bundle.putInt(ScanActivity.DRAWABLE, logo!!)
                        bundle.putString(ScanActivity.PLATFORM_NAME, platformName)

                        counter = 0

                        gotoIntent(ScanActivity::class.java, bundle, false)
                    }
                    else{
                        counter = 0
                        showBottomSheetCustom("Account Created", "your account is successfully created",
                            "back to login screen", isCancelable = false, isFinish = true
                        ) {
                            val i = Intent(this, LoginActivity::class.java)
                            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                            startActivity(i)
                        }
                    }
                }

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