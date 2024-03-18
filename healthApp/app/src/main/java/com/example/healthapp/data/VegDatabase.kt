package com.example.healthapp.data

import android.content.Context

@Database(entities = [Veg:class], version = 1, exportSchema = false)
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