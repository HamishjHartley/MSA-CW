package com.example.healthapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface VegDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(veg : Veg)

    @Delete
    suspend fun delete(veg: Veg)

    @Query("SELECT * from vegtables WHERE id = :id")
    fun getVeg(id: Int): Flow<Veg>

    @Query("SELECT * from vegtables ORDER BY name ASC")
    fun getAllVeg(): Flow<List<Veg>>
}