package com.example.healthapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(version=1, entities = [Veg::class])
abstract class VegDatabase : RoomDatabase() {

    abstract fun vegDao(): VegDao

    companion object {
        @Volatile
        private var Instance: VegDatabase? = null

        fun getDatabase(context: Context): VegDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, VegDatabase::class.java, "veg_database")
                    .build().also {Instance = it}
            }
        }
    }
}