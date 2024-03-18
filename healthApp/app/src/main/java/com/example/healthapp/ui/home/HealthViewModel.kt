package com.example.healthapp.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class HealthViewModel : ViewModel() {

    /**
     * Holds current item ui state
     */
    var vegUiState by mutableStateOf(VegUiState())
        private set

    /**
     * Updates the [itemUiState] with the value provided in the argument. This method also triggers
     * a validation for input values.
     */
    fun updateUiState(vegDetails: VegDetails) {
        vegUiState =
            VegUiState(vegDetails = vegDetails)
    }
}

/**
 * Represents Ui State for a portion of fruit/veg.
 */
data class VegUiState(
    val vegDetails: VegDetails = VegDetails(),
)

//TODO: add more functionality to vegtable portion input
data class VegDetails(
    val name: String ="", //To be implemented
    val quantity: Int = 1, //By default each veg is 1 portion
)