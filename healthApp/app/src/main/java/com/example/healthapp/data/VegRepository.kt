package com.example.healthapp.data

import kotlinx.coroutines.flow.Flow

interface VegRepository{
    /**
     * Retrieve all the vegtables from the the given data source.
     */
    fun getAllVegStream(): Flow<List<Veg>>

    /**
     * Retrieve a vegtable from the given data source that matches with the [id].
     */
    fun getVegStream(id: Int): Flow<Veg?>

    /**
     * Insert vegtable in the data source
     */
    suspend fun insertVeg(veg: Veg)

    /**
     * Delete vegtable from the data source
     */
    suspend fun delete(veg: Veg)

}
