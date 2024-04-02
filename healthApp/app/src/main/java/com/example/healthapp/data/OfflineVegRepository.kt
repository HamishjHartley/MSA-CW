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



/*

import com.example.healthapp.data.Veg
import com.example.healthapp.data.VegDao
import com.example.healthapp.data.OfflineVegRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class OfflineVegRepositoryTest {

    @Mock
    private lateinit var mockVegDao: VegDao

    private lateinit var offlineVegRepository: OfflineVegRepository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        offlineVegRepository = OfflineVegRepository(mockVegDao)
    }

    @Test
    fun testGetAllVegStream() = runBlocking {
        val mockVegList = listOf(Veg(1, "Carrot"), Veg(2, "Broccoli"))
        `when`(mockVegDao.getAllVeg()).thenReturn(flowOf(mockVegList))

        val result = offlineVegRepository.getAllVegStream()

        result.collect { vegList ->
            assertEquals(mockVegList, vegList)
        }
    }

    @Test
    fun testGetVegStream() = runBlocking {
        val vegId = 1
        val mockVeg = Veg(vegId, "Carrot")
        `when`(mockVegDao.getVeg(vegId)).thenReturn(flowOf(mockVeg))

        val result = offlineVegRepository.getVegStream(vegId)

        result.collect { veg ->
            assertEquals(mockVeg, veg)
        }
    }

    @Test
    fun testInsertVeg() = runBlocking {
        val mockVeg = Veg(1, "Carrot")

        offlineVegRepository.insertVeg(mockVeg)

        verify(mockVegDao).insert(mockVeg)
    }

    @Test
    fun testDelete() = runBlocking {
        val mockVeg = Veg(1, "Carrot")

        offlineVegRepository.delete(mockVeg)

        verify(mockVegDao).delete(mockVeg)
    }
}


 */