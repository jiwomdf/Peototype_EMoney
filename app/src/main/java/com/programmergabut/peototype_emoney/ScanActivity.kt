package com.programmergabut.peototype_emoney

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.res.ResourcesCompat
import com.google.zxing.Result
import com.karumi.dexter.Dexter
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.PermissionListener
import kotlinx.android.synthetic.main.activity_scan.*
import me.dm7.barcodescanner.zxing.ZXingScannerView

class ScanActivity : BaseActivity(), ZXingScannerView.ResultHandler {

    companion object {
        const val DRAWABLE = "drawable"
        const val PLATFORM_NAME = "PLATFORM_NAME"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scan)

        iv_logo.setImageDrawable(ResourcesCompat.getDrawable(resources, intent.extras?.getInt(DRAWABLE)!!, null))
        tv_payment_method.text = "PAYMENT METHOD\n${intent.extras?.getString(PLATFORM_NAME)!!}"
        setListener()
    }

    private fun setListener() {
        Dexter.withActivity(this)
            .withPermission(Manifest.permission.CAMERA)
            .withListener(object: PermissionListener {
                override fun onPermissionGranted(response: PermissionGrantedResponse?) {
                    barcode_scanner.setResultHandler(this@ScanActivity)
                    barcode_scanner.startCamera()
                }

                override fun onPermissionRationaleShouldBeShown(
                    permission: PermissionRequest?,
                    token: PermissionToken?
                ) {

                }

                override fun onPermissionDenied(response: PermissionDeniedResponse?) {
                    Toast.makeText(this@ScanActivity, "You Must Accept this permission", Toast.LENGTH_SHORT).show()

                }
            })
            .check()
    }

    override fun handleResult(rawResult: Result?) {
        Log.d("ResultQR", rawResult?.text!!)

        val bundle = Bundle()
        bundle.putInt(DRAWABLE, R.drawable.logo_ovo)
        bundle.putString(USERNAME, USERNAME)
        bundle.putString(NOREK, NOREK)

        gotoIntent(PaymentConfirmationEWalletActivity::class.java, bundle, false)
    }

    override fun onDestroy() {
        super.onDestroy()
        barcode_scanner.stopCamera()
    }

    override fun onResume() {
        super.onResume()
        barcode_scanner.setResultHandler(this)
        barcode_scanner.startCamera()
    }

    override fun onPause() {
        super.onPause()
        barcode_scanner.stopCamera()
    }
}