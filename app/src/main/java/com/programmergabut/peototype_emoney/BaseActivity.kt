package com.programmergabut.peototype_emoney

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.layout_bottom_sheet.view.*

abstract class BaseActivity: AppCompatActivity() {

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
        return super.dispatchTouchEvent(ev)
    }

    protected fun <T : Any> gotoIntent(classIntent : Class<T>, bundle : Bundle?, isFinish : Boolean){
        val intent = Intent(this, classIntent)
        if(bundle != null)
            intent.putExtras(bundle)
        startActivity(intent)
        if(isFinish)
            finish()
    }

    protected fun showBottomSheet(title : String = "Error", description : String = "", btnText: String = "Oke",
                                  isCancelable : Boolean = true, isFinish : Boolean = false) {

        val bottomSheetDialog = BottomSheetDialog(this)
        val layout = layoutInflater.inflate(R.layout.layout_bottom_sheet, null)
        layout.tv_e_title.text = title
        layout.tv_e_dsc.text = description
        layout.btn_ok.text = btnText

        layout.btn_ok.setOnClickListener{
            bottomSheetDialog.dismiss()
            if(isFinish)
                finish()
        }
        bottomSheetDialog.setCancelable(isCancelable)
        bottomSheetDialog.setContentView(layout)
        bottomSheetDialog.show()
    }

    protected fun showBottomSheetCustom(
        title: String = "Error", description: String = "", btnText: String = "Oke",
        isCancelable: Boolean = true, isFinish: Boolean = false, function: () -> Unit
    ) {

        val bottomSheetDialog = BottomSheetDialog(this)
        val layout = layoutInflater.inflate(R.layout.layout_bottom_sheet, null)
        layout.tv_e_title.text = title
        layout.tv_e_dsc.text = description
        layout.btn_ok.text = btnText

        layout.btn_ok.setOnClickListener{
            bottomSheetDialog.dismiss()
            if(isFinish)
                function()
        }
        bottomSheetDialog.setCancelable(isCancelable)
        bottomSheetDialog.setContentView(layout)
        bottomSheetDialog.show()
    }


}