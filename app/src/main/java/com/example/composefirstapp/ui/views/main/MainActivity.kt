package com.example.composefirstapp.ui.views.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composefirstapp.ui.composable.SimpleDialog
import com.example.composefirstapp.ui.data.DialogContent
import com.example.composefirstapp.ui.theme.ComposeFirstAppTheme

class MainActivity : ComponentActivity() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        // Handle the splash screen transition.
        val splashScreen = installSplashScreen()

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        splashScreen.setKeepOnScreenCondition { mainViewModel.starting.value }

        super.onCreate(savedInstanceState)
        setContent {
            ComposeFirstAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Counter(mainViewModel, "Android")
                }
            }
        }
    }
}

@Composable
fun Counter(mainViewModel: MainViewModel, name: String) {
    val counter = mainViewModel.counter
    val showDialog = mainViewModel.showDialog
    Box(modifier = Modifier.fillMaxSize(), Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Contador -> ${counter.value}", style = TextStyle(fontSize = 40.sp))
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = mainViewModel::showAlert
            ) {
                Text(text = "Incrementar")
            }
        }

        if (showDialog.value){
            val dataDialog = DialogContent(
                title = "¿Incrementar valor del contador?",
                content = "El nuevo valor del contador será ${counter.value + 1}"
            )
            SimpleDialog(
                data = dataDialog,
                onCancel = mainViewModel::hideAlert,
                onAccept = mainViewModel::increaseCounter
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val mainViewModel : MainViewModel = viewModel()
    ComposeFirstAppTheme {
        Counter(mainViewModel,"Android")
    }
}