package com.example.healthapp.data

class OfflineVegRepository(private val vegDao) : VegRepository {
    override fun getAllVegStream(): Flow<List<Veg>> = vegDao.getAllVeg()

    override fun getVegStream(id: Int): Flow<Veg?> = vegDao.getVeg(id)

    override suspend fun insertVeg(veg: Veg) = vegDao.insert(veg)

    override suspend fun deleteVeg(veg: Veg) = vegDao.insert(veg)
}