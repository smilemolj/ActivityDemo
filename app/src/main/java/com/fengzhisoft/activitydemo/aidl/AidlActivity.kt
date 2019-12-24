package com.fengzhisoft.activitydemo.aidl

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import com.fengzhisoft.activitydemo.R
import kotlinx.android.synthetic.main.activity_aidl.*

class AidlActivity : AppCompatActivity() {

    private val serviceconnection: ServiceConnection by lazy {
        object : ServiceConnection {
            override fun onServiceDisconnected(p0: ComponentName?) {
                Log.i("tag-->", "myremoteservice onServiceDisconnected")
            }

            override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
                Log.i("tag-->", "myremoteservice onserviceconnected")
//                取数据
                val processInfo = IProcessInfo.Stub.asInterface(p1)
                Log.i("tag-->", "myremoteservice process id=+${processInfo.processId}")
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aidl)

        button_aidl.setOnClickListener {
            //            bindService(
//                Intent(this, MyRemoteService::class.java),
//                serviceconnection,
//                Context.BIND_AUTO_CREATE
//            )

//            startActivity(Intent().apply {
//                action = "nihaohahaha"
//            })

//            val mapIntent: Intent = Uri.parse(
//                "geo:0,0?q=中国+重庆+朝天门"
//            ).let { location ->
//                // Or map point based on latitude/longitude
//                // Uri location = Uri.parse("geo:37.422219,-122.08364?z=14"); // z param is zoom level
//                Intent(Intent.ACTION_VIEW, location)
//            }
//            startActivity(mapIntent)

            val webintent = Uri.parse("http://www.baidu.com").let {
                Intent(Intent.ACTION_VIEW, it)
            }
            startActivity(webintent)
        }
    }
}
