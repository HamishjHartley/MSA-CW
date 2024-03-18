package com.example.healthapp.data

import kotlinx.coroutines.flow.Flow

class OfflineVegRepository(private val vegDao: VegDao) : VegRepository {
//    override fun getAllVegStream(): Flow<List<Veg>> = vegDao.getAllVeg()
//
//    override fun getVegStream(id: Int): Flow<Veg?> = vegDao.getVeg(id)

//    suspend fun insertVeg(veg: Veg) = vegDao.insert(veg)
//
//    suspend fun deleteVeg(veg: Veg) = vegDao.insert(veg)
    override fun getAllvegStream(): Flow<List<Veg>> {
        TODO("Not yet implemented")
    }

    override fun getvegStream(id: Int): Flow<Veg?> {
        TODO("Not yet implemented")
    }

    override suspend fun insertveg(veg: Veg) {
        TODO("Not yet implemented")
    }

    override suspend fun delete(veg: Veg) {
        TODO("Not yet implemented")
    }
}