package com.example.healthapp.data

import kotlinx.coroutines.flow.Flow

class OfflineVegRepository(private val vegDao: VegDao) : VegRepository {
//    override fun getAllVegStream(): Flow<List<Veg>> = vegDao.getAllVeg()
//
//    override fun getVegStream(id: Int): Flow<Veg?> = vegDao.getVeg(id)

    //    suspend fun insertVeg(veg: Veg) = vegDao.insert(veg)
//
//    suspend fun deleteVeg(veg: Veg) = vegDao.delete(veg)
    override fun getAllVegStream(): Flow<List<Veg>> = vegDao.getAllVeg()


    override fun getVegStream(id: Int): Flow<Veg?> = vegDao.getVeg(id)


    override suspend fun insertVeg(veg: Veg) = vegDao.insert(veg)


    override suspend fun delete(veg: Veg) = vegDao.delete(veg)

}