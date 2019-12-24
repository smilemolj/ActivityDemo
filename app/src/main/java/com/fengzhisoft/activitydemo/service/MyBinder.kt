package com.fengzhisoft.activitydemo.service

import android.os.Binder

class MyBinder :Binder(){
    //1. 定义用于通信的对象，在Service的onBind()中返回的对象。
   var mProcessId = 0

}