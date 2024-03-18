package com.example.healthapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Vegtables")
data class Veg(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String ="", //To be implemented
    val quantity: Int = 1, //By default each veg is 1 portion
)
