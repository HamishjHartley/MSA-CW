package com.example.healthapp.ui.theme

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.healthapp.StepCounter

class HomeViewModel(application: Application) : AndroidViewModel(application), StepCounter.StepListener {

    private val _stepCount = MutableLiveData<Int>()
    val stepCount: LiveData<Int>
        get() = _stepCount

    private val stepCounter = StepCounter(application.applicationContext, this)

    init {
        _stepCount.value = 0
        stepCounter.register()
    }

    override fun onStep(stepCount: Int) {
        _stepCount.postValue(stepCount)
    }

    override fun onCleared() {
        super.onCleared()
        stepCounter.unregister()
    }
}