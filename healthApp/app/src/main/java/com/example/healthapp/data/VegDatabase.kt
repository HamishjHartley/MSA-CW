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



/*
import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.healthapp.data.VegDatabase
import org.junit.After
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class VegDatabaseTest {

    private lateinit var vegDatabase: VegDatabase
    private lateinit var context: Context

    @Before
    fun setUp() {
        context = ApplicationProvider.getApplicationContext()
        vegDatabase = Room.inMemoryDatabaseBuilder(context, VegDatabase::class.java).build()
    }

    @After
    fun tearDown() {
        vegDatabase.close()
    }

    @Test
    fun testDatabaseCreation() {
        assertNotNull(vegDatabase)
    }

    @Test
    fun testVegDao() {
        val vegDao = vegDatabase.vegDao()
        assertNotNull(vegDao)
    }
}


 */