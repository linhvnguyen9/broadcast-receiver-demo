package com.linh.broadcastreceiversample

import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.localbroadcastmanager.content.LocalBroadcastManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val br = MyBroadcastReceiver()
        val filter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION).apply {
            addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        }
        registerReceiver(br, filter)

        val localReceiver = LocalBroadcastReceiver()
        val localFilter = IntentFilter("com.linh.broadcastreceiversample.MY_BROADCAST").apply {
        }
        registerReceiver(localReceiver, localFilter)

        findViewById<Button>(R.id.button_main_nuke).setOnClickListener {
            Intent().also {
                it.action = "com.linh.broadcastreceiversample.MY_BROADCAST"
                sendBroadcast(it)
            }
        }
    }
}