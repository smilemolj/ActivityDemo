package com.fengzhisoft.activitydemo.service

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import androidx.appcompat.app.AppCompatActivity
import com.fengzhisoft.activitydemo.R
import kotlinx.android.synthetic.main.activity_service.*


class ServiceActivity : AppCompatActivity() {

    lateinit var serviceconnection: ServiceConnection

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)

        serviceconnection = object : ServiceConnection {
            override fun onServiceDisconnected(p0: ComponentName?) {
            }

            override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
                val myBinder: MyBinder = p1 as MyBinder
            }

            override fun onNullBinding(name: ComponentName?) {
            }
        }

        button_service.setOnClickListener {
            //            startService(Intent(this, MyService::class.java))
            bindService(Intent(this,MyService::class.java),serviceconnection, Context.BIND_AUTO_CREATE)
        }

    }
}
