package com.naeemdev.jetpackcompose_ui_components_material_3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TimeInput
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerDefaults
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.naeemdev.jetpackcompose_ui_components_material_3.bottombar.BottomBarItem
import com.naeemdev.jetpackcompose_ui_components_material_3.bottombar.CustomBottomBar
import com.naeemdev.jetpackcompose_ui_components_material_3.timepicker.TimePickerDialog
import com.naeemdev.jetpackcompose_ui_components_material_3.toolbar.CustomCenterAlignedTopAppBar
import com.naeemdev.jetpackcompose_ui_components_material_3.ui.theme.JetpackComposeUiComponentsMaterial3Theme
import com.naeemdev.jetpackcompose_ui_components_material_3.util.getCurrentTime
import com.naeemdev.jetpackcompose_ui_components_material_3.util.getParsedTime
import com.naeemdev.jetpackcompose_ui_components_material_3.util.toFormattedDateWithDay
import com.naeemdev.jetpackcompose_ui_components_material_3.util.toTime
import java.util.Calendar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeUiComponentsMaterial3Theme {
                var selectedItemIndex by rememberSaveable { mutableStateOf(0) }
                Scaffold(modifier = Modifier.fillMaxSize(),
                    topBar = {
                        CustomCenterAlignedTopAppBar(
                            title = "Testing Tool bar",
                            titleColor = Color.Black,
                            backgroundColor = Color.White,
                            titleStyle = MaterialTheme.typography.titleMedium,
                            navigationIcon = {
                                // Navigation icon
                                IconButton(
                                    onClick = {}
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.ArrowBack,
                                        contentDescription = "Back"
                                    )
                                }
                            },
                            actions = {
                                // Actions you can pass text view or any icon
                                IconButton(
                                    onClick = {}
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Delete,
                                        contentDescription = "Back"
                                    )
                                }
                            },

                            )
                    },
                    bottomBar = {
                        CustomBottomBar(
                            items = listOf(
                                BottomBarItem(
                                    title = "Home",
                                    selectedIcon = Icons.Default.Home,
                                    unselectedIcon = Icons.Outlined.Home,
                                    hasNews = false,

                                    ),
                                BottomBarItem(
                                    title = "Favorite",
                                    selectedIcon = Icons.Default.Favorite,
                                    unselectedIcon = Icons.Outlined.Favorite,
                                    hasNews = false,
                                    badgeCount = 0
                                ),
                                BottomBarItem(
                                    title = "Email",
                                    selectedIcon = Icons.Default.Notifications,
                                    unselectedIcon = Icons.Outlined.Notifications,
                                    hasNews = false,
                                    badgeCount = 45
                                ),
                                BottomBarItem(
                                    title = "Setting",
                                    selectedIcon = Icons.Default.Settings,
                                    unselectedIcon = Icons.Outlined.Settings,
                                    hasNews = true
                                )
                            ),
                            selectedItemIndex = selectedItemIndex,
                            onItemSelected = {
                                selectedItemIndex = it
                            }
                        )
                    }

                ) { innerPadding ->
                    MainContent(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainContent(modifier: Modifier = Modifier) {
    var dateResult by remember { mutableStateOf("Date Picker") }
    var timeResult by remember { mutableStateOf("Time Picker 24 hours") }
    val openDialog = remember { mutableStateOf(false) }
    val openCustomDialog = remember { mutableStateOf(false) }
    val openTimePicker = remember { mutableStateOf(false) }
    val is24HourFormat = true
    val selectedTime = remember { mutableStateOf(getCurrentTime(is24HourFormat)) }

    Column(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                openCustomDialog.value = true
            }
        ) {
            Text("Show dialog")
        }


        OutlinedButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                openDialog.value = true
            }
        ) {
            Text(dateResult)
        }

        OutlinedButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                openTimePicker.value = true
            }
        ) {
            Text(timeResult)
        }
    }
    if (openCustomDialog.value) {
        CustomDialog(
            modifier = Modifier.padding(16.dp),
            title = "Title",
            message = "Message",
            confirmText = "Confirm",
            icon = R.drawable.ic_warning_24,
            dismissText = "Dismiss",
            onDismiss = {
                openCustomDialog.value = false
            },
            onConfirm = {
                openCustomDialog.value = false
            }
        )
    }
    if (openTimePicker.value) {

        val calendar = getParsedTime(selectedTime.value, is24HourFormat)
        val timePickerState = rememberTimePickerState(
            initialHour = calendar.get(Calendar.HOUR_OF_DAY),
            initialMinute = calendar.get(Calendar.MINUTE),
            is24Hour = is24HourFormat
        )
        TimePickerDialog(
            title = "Select time",
            onCancel = { openTimePicker.value = false },
            onConfirm = {
                openTimePicker.value = false
                calendar.set(Calendar.HOUR_OF_DAY, timePickerState.hour)
                calendar.set(Calendar.MINUTE, timePickerState.minute)
                selectedTime.value = calendar.time.time.toTime(is24HourFormat)
                timeResult = calendar.time.time.toTime(is24HourFormat)
            },
            content = { displayMode ->
                val commonColors = TimePickerDefaults.colors(
                    clockDialColor = Color.White
                )

                AnimatedContent(
                    targetState = displayMode == DisplayMode.Input,
                    label = "Time picker animation"
                ) { isInputMode ->
                    if (isInputMode) {
                        TimeInput(
                            state = timePickerState,
                            colors = commonColors.copy(
                                timeSelectorSelectedContentColor = Color.Red
                            )
                        )
                    } else {
                        TimePicker(
                            state = timePickerState,
                            colors = commonColors
                        )
                    }
                }
            }
        )

    }
    if (openDialog.value) {
        DatePickerDialog(
            initialDate = System.currentTimeMillis(),
            modifier = Modifier,
            onDateSelected = {
                dateResult = it.toFormattedDateWithDay()
                openDialog.value = false
            },
            onCancel = {
                openDialog.value = false
            }
        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeUiComponentsMaterial3Theme {
        MainContent(modifier = Modifier)
    }
}