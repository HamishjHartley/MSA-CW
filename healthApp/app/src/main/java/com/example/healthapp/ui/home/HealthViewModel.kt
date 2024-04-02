package com.example.healthapp.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.healthapp.data.Veg
import com.example.healthapp.data.VegRepository

class HealthViewModel(private val vegRepository: VegRepository) : ViewModel() {

    //Holds current vegUiState
    var vegUiState by mutableStateOf(VegUiState())
        private set

    //Updates the vegUiState, with [vegDetail] parameter
    fun updateUiState(vegDetails: VegDetails) {
        vegUiState =
            VegUiState(vegDetails = vegDetails)
    }

    suspend fun addVeg() {
        vegRepository.insertVeg(vegUiState.vegDetails.toVeg())
    }

    
}

//Represents Ui State for a portion of fruit/veg.
data class VegUiState(
    val vegDetails: VegDetails = VegDetails(),
)

//TODO: add more functionality to vegtable portion input
data class VegDetails(
    val id : Int = 0,
    val name: String ="", //To be implemented
    val quantity: Int = 1, //By default each veg is 1 portion
)

//Converts VegDetails to Veg object
fun VegDetails.toVeg(): Veg = Veg(
    id = id,
    name = name,
    quantity =quantity
)

