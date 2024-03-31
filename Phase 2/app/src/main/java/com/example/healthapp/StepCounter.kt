package com.example.healthapp

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager

class StepCounter(context: Context, private val stepListener: StepListener) : SensorEventListener {

    private var sensorManager: SensorManager? = null
    private var stepSensor: Sensor? = null

    private var stepsTaken = 0

    init {
        sensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager?
        stepSensor = sensorManager?.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
    }

    fun register() {
        sensorManager?.registerListener(this, stepSensor, SensorManager.SENSOR_DELAY_NORMAL)
    }

    fun unregister() {
        sensorManager?.unregisterListener(this)
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event?.sensor?.type == Sensor.TYPE_ACCELEROMETER) {
            detectStep(event.values[0], event.values[1], event.values[2])
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        // Not used
    }

    private fun detectStep(x: Float, y: Float, z: Float) {
        val magnitude = Math.sqrt((x * x + y * y + z * z).toDouble())
        if (magnitude > STEP_THRESHOLD) {
            stepsTaken++
            stepListener.onStep(stepsTaken)
        }
    }

    interface StepListener {
        fun onStep(stepCount: Int)
    }

    companion object {
        private const val STEP_THRESHOLD = 10 // Adjust as necessary
    }
}