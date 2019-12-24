package com.fengzhisoft.activitydemo.databing

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.fengzhisoft.activitydemo.R
import kotlinx.android.synthetic.main.activity_binding.*

class BindingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_binding)

        lifecycle.addObserver(object : LifecycleObserver {
            @OnLifecycleEvent(Lifecycle.Event.ON_START)
            fun suibianxie() {
                Log.i("tag-->", "hahaha,resume")
            }
        })


        button2.setOnClickListener {
            val normalDialog: AlertDialog.Builder =
                AlertDialog.Builder(this);
//            normalDialog.setIcon(R.drawable.icon_dialog);
            normalDialog.setTitle("我是一个普通Dialog")
            normalDialog.setMessage("你要点击哪一个按钮呢?");
            normalDialog
                .setPositiveButton(
                    "确定",
                    DialogInterface.OnClickListener { dialogInterface, i ->
                        Toast.makeText(this, "点击了确定", Toast.LENGTH_SHORT).show()
                    })
                .setNegativeButton("取消", DialogInterface.OnClickListener { dialogInterface, i ->
                    Toast.makeText(this, "点击了取消", Toast.LENGTH_SHORT).show()
                })

            // 显示
            normalDialog.show();
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("tag-->","你好")
    }
}
