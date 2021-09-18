package com.linh.broadcastreceiversample

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class LocalBroadcastReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context, p1: Intent) {
        val builder = NotificationCompat.Builder(context, "2")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("Broadcast Receiver Sample")
            .setContentText("Local broadcast: Door SHTUCK, DOOR SHTUCK!!!")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel =
                NotificationChannel("2", "Local sample channel", NotificationManager.IMPORTANCE_DEFAULT)
            val notificationManager: NotificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }

        with(NotificationManagerCompat.from(context)) {
            notify(1, builder.build())
        }
    }
}