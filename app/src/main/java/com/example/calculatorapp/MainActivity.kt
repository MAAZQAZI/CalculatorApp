package com.example.calculatorapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.example.calculatorapp.ui.theme.CalculatorAppTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ktorapicallpersonaldata.network.ApiFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        fetchUser(1)
        setContent {
            CalculatorAppTheme {
                val viewModel= viewModel<CalculatorViewModel>()
                val state = viewModel.state
                val buttonspacing=8.dp
                Calculator(state = state , onAction = viewModel::onAction, modifier = Modifier
                    .fillMaxSize()
                    .background(Color.DarkGray)
                    .padding(16.dp),
                    btnSpacing = buttonspacing)

            }
        }
    }


}

private fun fetchUser(userId: Int) {
    // Use the IO dispatcher for network operations
    CoroutineScope(Dispatchers.IO).launch {
        try {
            val apiService = ApiFactory.createApiService()
            val user = apiService.getUser(userId)

            Log.d("Result", "User: $user")
            // Switch to the Main dispatcher to update the UI

        } catch (e: Exception) {
            Log.e("Result-Error", "Error fetching user: ${e.message}", e)
        }
    }
}