package com.example.uitesting

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.uitesting.ui.theme.UiTestingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Setting the content of the activity using the UiTestingTheme
        setContent {
            UiTestingTheme {
                // Creating a NavController to handle navigation
                val navController = rememberNavController()
                // Setting up the navigation graph
                SetupNavGraph(navController = navController)
            }
        }
    }
}

@Composable
fun HomeScreen(navController: NavHostController) {
    // Button to navigate to the Settings screen when clicked
    Button(
        modifier = Modifier.wrapContentSize(),
        onClick = { navController.navigate("SettingsScreen") }
    ) {
        Text("Settings")
    }
}