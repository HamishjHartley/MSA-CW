package com.example.healthapp.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.healthapp.ui.home.HealthViewModel

object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
            HealthViewModel(healthApplication().container.vegRepository)
        }
    }
}

fun CreationExtras.healthApplication(): HealthApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as HealthApplication)
