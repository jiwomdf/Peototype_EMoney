package com.programmergabut.peototype_emoney

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        tv_name.text = USERNAME
        tv_phone.text = PHONE
        setListener()
    }

    private fun setListener() {
        iv_back.setOnClickListener {
            finish()
        }
        cl_sign_out.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(i)
        }
    }
}