package com.example.healthapp.data

import android.content.Context

interface AppContainer{
    val vegRepository : VegRepository
}

class AppDataContainer(private val context: Context) : AppContainer {
    override val vegRepository: VegRepository by lazy {
        OfflineVegRepository(VegDatabase.getDatabase(context).vegDao())
    }
}