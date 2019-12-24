package com.fengzhisoft.activitydemo.permission

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fengzhisoft.activitydemo.R
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val message = intent.getStringExtra("nihao")
        textView.text=message
    }
}
