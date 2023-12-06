package com.example.uitesting

import androidx.compose.ui.test.assertIsOff
import androidx.compose.ui.test.assertIsOn
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.navigation.compose.rememberNavController
import org.junit.Rule
import org.junit.Test

class SettingsScreenTest {

    // Creating a ComposeTestRule for testing Compose components
    @get:Rule
    val composeTestRule = createComposeRule()

    // Test function for the SettingsScreen
    @Test
    fun settingsScreenTest() {
        // Launch the SettingsScreen
        composeTestRule.setContent {
            // Creating the SettingsScreen with a NavController
            SettingsScreen(navController = rememberNavController())
        }

        // Assertions for the state of different switches in the SettingsScreen

        // Asserting that the "Use 24 hour clock" switch is in the off state
        composeTestRule.onNodeWithTag("Use 24 hour clock")
            .assertIsOff()

        // Asserting that the "Hide My Age" switch is in the on state
        composeTestRule.onNodeWithTag("Hide My Age")
            .assertIsOn()

        // Asserting that the "Hide my Profile Picture" switch is in the off state
        composeTestRule.onNodeWithTag("Hide my Profile Picture")
            .assertIsOff()

        // Asserting that the "Get Notified Each Time you receive a review" switch is in the on state
        composeTestRule.onNodeWithTag("Get Notified Each Time you receive a review")
            .assertIsOn()

        // Asserting that the "Get Notified when a voice message you record is approved" switch is in the on state
        composeTestRule.onNodeWithTag("Get Notified when a voice message you record is approved")
            .assertIsOn()

        // Asserting that the "Get Reminders about reviewing people who left you voice messages" switch is in the on state
        composeTestRule.onNodeWithTag("Get Reminders about reviewing people who left you voice messages")
            .assertIsOn()
    }
}