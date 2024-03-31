package com.example.healthapp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.example.healthapp.ui.theme.HealthAppTheme
import com.example.healthapp.ui.theme.HomeViewModel

class MainActivity : ComponentActivity() {
    //Instance variables, TODO: Move to container
    private lateinit var viewModel: HomeViewModel
    private lateinit var stepCountTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        viewModel.stepCount.observe(this, { stepCount ->
            stepCountTextView.text = "Step Count: $stepCount"
        })
        setContent {
            HealthAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                }
            }
        }
    }
}
