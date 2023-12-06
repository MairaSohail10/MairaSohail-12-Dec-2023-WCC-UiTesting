package com.example.uitesting

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController


@Composable
fun CustomSwitch(text: String, toggle: Boolean) {
    // State to track the checked state of the switch
    var checked by remember { mutableStateOf(toggle) }

    // Outer Row to hold the switch and its label
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        // Inner Row to hold the label
        Row(
            modifier = Modifier.size(width = 260.dp, height = 40.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Normal)
            )
        }

        // Spacer to create some space between the label and the switch
        Spacer(Modifier.width(40.dp))

        // Switch component with customization for colors and a test tag
        Switch(
            checked = checked,
            onCheckedChange = {
                checked = it
            },
            colors = SwitchDefaults.colors(
                checkedThumbColor = MaterialTheme.colorScheme.primary,
                checkedTrackColor = MaterialTheme.colorScheme.primaryContainer,
                uncheckedThumbColor = MaterialTheme.colorScheme.secondary,
                uncheckedTrackColor = MaterialTheme.colorScheme.secondaryContainer,
            ),
            modifier = Modifier.testTag(text) // Add a unique test tag for each switch
        )
    }
}

@Composable
fun Heading(text: String) {
    // Text with a specific style for headings
    Text(
        text = text,
        style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Bold),
        modifier = Modifier.padding(bottom = 10.dp)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(navController: NavHostController) {
    // Top App Bar with a title and navigation icon
    TopAppBar(title = {
        Text("Settings")
    }, navigationIcon = {
        IconButton(onClick = { navController.popBackStack() }) {
            Icon(Icons.Filled.ArrowBack, contentDescription = "BackArrow")
        }
    })

    // Column to hold the content of the settings screen
    Column(
        Modifier
            .padding(top = 60.dp, start = 20.dp, end = 20.dp, bottom = 20.dp)
            .fillMaxSize()
    ) {
        // General Settings Section
        Heading("General")
        CustomSwitch("Use 24 hour clock", false)

        // Spacer for visual separation
        Spacer(Modifier.height(30.dp))

        // Privacy Settings Section
        Heading("Privacy")
        CustomSwitch("Hide My Age", true)
        CustomSwitch("Hide my Profile Picture", false)

        // Spacer for visual separation
        Spacer(Modifier.height(30.dp))

        // Notifications Settings Section
        Heading("Notifications")
        CustomSwitch("Get Notified Each Time you receive a review", true)
        CustomSwitch("Get Notified when a voice message you record is approved", true)
        CustomSwitch("Get Reminders about reviewing people who left you voice messages", true)
    }
}