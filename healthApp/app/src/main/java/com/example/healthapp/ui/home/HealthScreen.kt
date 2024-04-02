package com.example.healthapp.ui.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.healthapp.ui.AppViewModelProvider
import kotlinx.coroutines.launch


@Composable
fun HomeScreen(
    viewModel: HealthViewModel = viewModel(factory = AppViewModelProvider.Factory),
    modifier: Modifier = Modifier
){
    val coroutineScope = rememberCoroutineScope()
    VegButton(onAddVeg = {
        coroutineScope.launch {
            viewModel.addVeg()
        }
    })
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