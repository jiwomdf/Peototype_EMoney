package com.programmergabut.peototype_emoney

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_notification.*

class NotificationActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        setListener()
    }

    private fun setListener() {
        iv_back.setOnClickListener {
            finish()
        }
    }


}