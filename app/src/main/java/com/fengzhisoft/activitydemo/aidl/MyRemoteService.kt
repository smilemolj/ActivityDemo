package com.fengzhisoft.activitydemo.aidl

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyRemoteService : Service() {
    private var processInfo=IProcessInfoImpl()
    override fun onBind(intent: Intent): IBinder? {
        Log.i("tag-->", "MyRemoteService+process id:${processInfo.processId}")
        return processInfo
    }
}
