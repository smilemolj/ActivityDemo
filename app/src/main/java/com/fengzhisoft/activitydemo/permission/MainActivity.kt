package com.fengzhisoft.activitydemo.permission

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.fengzhisoft.activitydemo.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val MY_PERMISSIONS_REQUEST_CALL_PHONE = 8

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                Log.i("-->", "checkSelfPermission:Permission is not granted")
                //未授权就请求权限
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.CALL_PHONE),
                    MY_PERMISSIONS_REQUEST_CALL_PHONE
                )

            } else {
                Log.i("-->", "Permission has already been granted")
//                已授权就进入执行操作
            }
        }
    }

//    ******注意：这里有坑，不要写
//    override fun onRequestPermissionsResult(
//        requestCode: Int,
//        permissions: Array<out String>,
//        grantResults: IntArray
//    ) {
////        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//        when (requestCode) {
//            MY_PERMISSIONS_REQUEST_CALL_PHONE -> {
//                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    Log.i(
//                        "-->",
//                        "permission was granted, yay! Do the contacts-related task you need to do."
//                    )
//                }else{
//                    Log.i("-->","permission denied, boo! Disable the functionality that depends on this permission.")
//                }
//                return
//            }
//        }
//    }


}
