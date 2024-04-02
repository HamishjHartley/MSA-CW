package com.example.healthapp

<<<<<<< Updated upstream
=======
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorManager
import android.os.Build
>>>>>>> Stashed changes
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.healthapp.ui.AppViewModelProvider
import com.example.healthapp.ui.home.HomeScreen
import com.example.healthapp.ui.theme.HealthAppTheme

<<<<<<< Updated upstream
class MainActivity : ComponentActivity() {
=======
class MainActivity<ActivityMainBinding> : ComponentActivity() {

    var binding: ActivityMainBinding = TODO()
    val CHANNEL_ID = "channelID"
    val CHANNEL_NAME = "channelName"
    val NOTIF_ID = 0

    //Obtaining SensorManager object
    private val sensorManager by lazy {
        getSystemService(Context.SENSOR_SERVICE) as SensorManager
    }
    private val sensor: Sensor? by lazy {
        sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER) }

    @RequiresApi(Build.VERSION_CODES.O)
>>>>>>> Stashed changes
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val service = VegNotificationService(applicationContext)
        setContent {
            HealthAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Box(modifier = Modifier.fillMaxSize()){
                        Button(onClick = {
                            service.showNotification(Counter.value)
                        }) {
                            Text(text="Show notification")
                        }
                    }
                }
            }
        }
    }
<<<<<<< Updated upstream
}
=======
    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }



    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotifChannel() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel = NotificationChannel(CHANNEL_ID,CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT).apply {
                lightColor = Color.BLUE
                enableLights(true)
            }
            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }
    }
}

>>>>>>> Stashed changes
