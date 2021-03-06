package com.programmergabut.peototype_emoney

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_register.*
import java.util.regex.Matcher
import java.util.regex.Pattern

class RegisterActivity : BaseActivity(), TextWatcher {

    private var arrValidation = arrayOf(false, false, false, false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        setListener()
    }

    private fun setListener() {
        btn_do_register.setOnClickListener{
            gotoIntent(SecurityCode::class.java, null, false)
        }

        et_first_name.addTextChangedListener(this)
        et_last_name.addTextChangedListener(this)
        et_email.addTextChangedListener(this)
        et_password.addTextChangedListener(this)
        et_password_confirm.addTextChangedListener(this)
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

    override fun afterTextChanged(s: Editable?) {
        when(s.hashCode()){
            et_first_name.text.hashCode() -> validateInput(et_first_name.text.hashCode())
            et_last_name.text.hashCode() -> validateInput(et_last_name.text.hashCode())
            et_email.text.hashCode() -> validateInput(et_email.text.hashCode())
            et_password.text.hashCode() -> validateInput(et_password.text.hashCode())
            et_password_confirm.text.hashCode() -> validateInput(et_password_confirm.text.hashCode())
        }
    }

    private fun validateInput(hashCode: Int){
        when(hashCode){
            et_first_name.text.hashCode() -> {
                if (et_first_name.text.toString().length < 2) {
                    et_first_name.error = "username is less than 2"
                    arrValidation[0] = false
                } else
                    arrValidation[0] = true
            }
            et_last_name.text.hashCode() -> {
                if (et_last_name.text.toString().length < 2) {
                    et_last_name.error = "username is less than 2"
                    arrValidation[0] = false
                } else
                    arrValidation[0] = true
            }
            et_email.text.hashCode() -> {
                if (et_email.text.toString().length < 2) {
                    et_email.error = "email is less than 2"
                    arrValidation[1] = false
                }
                else if(!emailValidator(et_email.text.toString())){
                    et_email.error = "email must have @ and ."
                    arrValidation[1] = false
                }
                else
                    arrValidation[1] = true
            }
            et_password.text.hashCode() -> {
                if (et_password.text.toString().isEmpty()) {
                    et_password.error = "password cannot be empty"
                    arrValidation[2] = false
                } else
                    arrValidation[2] = true
            }
            et_password_confirm.text.hashCode() -> {
                if (et_password_confirm.text.toString().isEmpty()) {
                    et_password_confirm.error = "confirm password cannot be empty"
                    arrValidation[3] = false
                }
                else
                    arrValidation[3] = true
            }
        }

        if(arrValidation.contains(false)){
            btn_do_register.isEnabled = false
            btn_do_register.setBackgroundColor(ContextCompat.getColor(this, R.color.grey))
        }
        else{
            btn_do_register.isEnabled = true
            btn_do_register.setBackgroundColor(ContextCompat.getColor(this, R.color.purple_700))
        }

    }

    private fun emailValidator(email: String?): Boolean {
        if(!email.isNullOrEmpty()){

            val trimEmail = email.trim()
            val pattern: Pattern
            val matcher: Matcher
            val EMAIL_PATTERN =
                "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"
            pattern = Pattern.compile(EMAIL_PATTERN)
            matcher = pattern.matcher(trimEmail)

            return matcher.matches()
        }

        return false
    }
}