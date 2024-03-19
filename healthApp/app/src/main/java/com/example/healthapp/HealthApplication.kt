package com.example.healthapp

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import com.example.healthapp.data.AppContainer
import com.example.healthapp.data.AppDataContainer

class HealthApplication : Application() {


    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
        createNotificationChanngel()

    }

    private fun createNotificationChanngel() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                VegNotificationService.COUNTER_CHANNEL_ID,"Counter",NotificationManager.IMPORTANCE_DEFAULT
            )
            channel.description = "Used to add portion of fruit/veg"

            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)

        }
    }
}