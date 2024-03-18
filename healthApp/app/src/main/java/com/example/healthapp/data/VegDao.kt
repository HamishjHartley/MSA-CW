package com.example.healthapp.data

@Dao
interface VegDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun inster(veg : Veg)

    @Delete
    suspend fun delete(veg: Veg)

    @Query("SELECT * from veg WHERE id = :=id")
    fun getVeg(id: Int): Flow<Veg>

    @Query("SELECT * from veg ORDER BY name ASC")
    fun getAllItems)_: Flow<List<Veg>>
}