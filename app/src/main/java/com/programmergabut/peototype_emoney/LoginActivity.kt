package com.programmergabut.peototype_emoney

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*
import java.util.*

const val EMAIL = "admin@admin.com"
const val PASSWORD = "admin"
const val SECURITY_CODE = "123"

class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setListener()
    }

    private fun setListener() {
        btn_login.setOnClickListener {

            val id = et_id.text.toString()
            val pass = et_password.text.toString()
            val security = et_security_code.text

            if(id.toLowerCase(Locale.ROOT).trim() == EMAIL.toLowerCase(Locale.ROOT) &&
                pass.toLowerCase(Locale.ROOT).trim() == PASSWORD.toLowerCase(Locale.ROOT) && security.toString() == SECURITY_CODE){
                gotoIntent(HomeActivity::class.java, null, true)
            }
            else if(et_id.text.toString().isEmpty() || et_password.text.toString().isEmpty() || et_security_code.text.toString().isEmpty())
                showBottomSheet("Error", "username, password, or security code cannot be empty")
            else
                showBottomSheet("User not found", "username or password is incorrect")

        }
    }

}