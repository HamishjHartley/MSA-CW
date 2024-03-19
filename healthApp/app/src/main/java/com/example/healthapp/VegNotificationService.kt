package com.example.healthapp

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat

class VegNotificationService(
    private val context: Context
) {

    fun showNotification(counter: Int) {
        val activityIntent = Intent(context, MainActivity::class.java)
        val activityPendingIntent = PendingIntent.getActivity(
            context,
            1,
            activityIntent,
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) PendingIntent.FLAG_IMMUTABLE else 0
        )

        val notification = NotificationCompat.Builder(context, COUNTER_CHANNEL_ID)
            .setSmallIcon(R.drawable.veg)
            .setContentTitle("Add portion of 5/day")
            .setContentText("Total portions: $counter")
            .setContentIntent(activityPendingIntent)
            .addAction(
                R.drawable.veg,
                "Increment",
                
            )
    }

    companion object{
        const val  COUNTER_CHANNEL_ID = "counter_channel"
    }
}