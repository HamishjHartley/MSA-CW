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

/*
import com.example.healthapp.data.Veg
import com.example.healthapp.data.VegRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class VegRepositoryTest {

    @Mock
    private lateinit var vegRepository: VegRepository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun `test getAllVegStream`() = runBlocking {
        val mockVegList = listOf(Veg(1, "Carrot"), Veg(2, "Broccoli"))
        `when`(vegRepository.getAllVegStream()).thenReturn(flowOf(mockVegList))

        val vegStream = vegRepository.getAllVegStream()

        assertEquals(mockVegList, vegStream.first())
    }

    @Test
    fun `test getVegStream`() = runBlocking {
        val vegId = 1
        val mockVeg = Veg(vegId, "Carrot")
        `when`(vegRepository.getVegStream(vegId)).thenReturn(flowOf(mockVeg))

        val vegStream = vegRepository.getVegStream(vegId)

        assertEquals(mockVeg, vegStream.first())
    }

    @Test
    fun `test insertVeg`() = runBlocking {
        val mockVeg = Veg(1, "Carrot")

        vegRepository.insertVeg(mockVeg)

        // Verify that insertVeg method is called
    }

    @Test
    fun `test delete`() = runBlocking {
        val mockVeg = Veg(1, "Carrot")

        vegRepository.delete(mockVeg)

        // Verify that delete method is called
    }
}
*/
