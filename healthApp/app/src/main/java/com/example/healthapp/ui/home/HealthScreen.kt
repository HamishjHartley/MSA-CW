package com.example.healthapp.ui.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun HomeScreen(
    viewModel: HealthViewModel,
    modifier: Modifier = Modifier
){
    VegButton(onAddVeg = { })
}




@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun VegButton(
    onAddVeg: () -> Unit,
    modifier: Modifier = Modifier){
    Scaffold(
        modifier = modifier
    ){
        Button(
            onClick = onAddVeg,
            shape = MaterialTheme.shapes.small,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text="Add portion")
        }
    }
}