package com.example.healthapp.data

interface VegRepository{
    suspend fun getVeg(): List<Veg>
}

class VegRepository(

) : VegRepository {

}