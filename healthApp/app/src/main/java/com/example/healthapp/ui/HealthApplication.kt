package com.example.healthapp.ui

import android.app.Application
import com.example.healthapp.data.AppContainer
import com.example.healthapp.data.AppDataContainer

class HealthApplication : Application() {

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}