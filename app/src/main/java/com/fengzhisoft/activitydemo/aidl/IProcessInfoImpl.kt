package com.fengzhisoft.activitydemo.aidl

class IProcessInfoImpl : IProcessInfo.Stub() {
    override fun getProcessId(): Int {
        return android.os.Process.myPid()
    }
}