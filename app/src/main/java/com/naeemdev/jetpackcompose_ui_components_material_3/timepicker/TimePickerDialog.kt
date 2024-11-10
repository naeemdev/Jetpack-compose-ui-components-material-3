package com.naeemdev.jetpackcompose_ui_components_material_3.timepicker

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerDefaults
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.naeemdev.jetpackcompose_ui_components_material_3.R
import com.naeemdev.jetpackcompose_ui_components_material_3.ui.theme.JetpackComposeUiComponentsMaterial3Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimePickerDialog(
    title: String = "Select Time",
    onCancel: () -> Unit,
    onConfirm: () -> Unit,
    content: @Composable (DisplayMode) -> Unit,
) {
    val displayModeState = remember { mutableStateOf(DisplayMode.Input) }
    Dialog(
        onDismissRequest = onCancel,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Surface(
            shape = RoundedCornerShape(28.dp),
            color = Color.White,
            modifier = Modifier.padding(horizontal = 24.dp)
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                )
                content(displayModeState.value)
                Row(
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .height(48.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    DisplayModeToggleButton(displayModeState = displayModeState)
                    Spacer(modifier = Modifier.weight(1f))
                    TextButton(
                        modifier = Modifier
                            .padding(end = 11.dp)
                            .width(94.dp)
                            .height(40.dp),
                        onClick = onCancel,
                    ) {
                        Text(
                            text = "cancel",
                            color = Color.Red,
                        )
                    }

                    TextButton(
                        modifier = Modifier
                            .width(44.dp)
                            .height(40.dp),
                        onClick = onConfirm,
                    ) {
                        Text(
                            text = "Ok",
                            color = Color.Red,
                            textAlign = TextAlign.Center,
                        )
                    }
                }
            }

        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DisplayModeToggleButton(
    displayModeState: MutableState<DisplayMode>,
    modifier: Modifier = Modifier
) {
    when (displayModeState.value) {
        DisplayMode.Picker -> IconButton(
            onClick = { displayModeState.value = DisplayMode.Input },
            modifier = modifier
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_enter_time),
                contentDescription = "pick the time "
            )

        }

        DisplayMode.Input -> IconButton(
            onClick = { displayModeState.value = DisplayMode.Picker },
            modifier = modifier
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_enter_time),
                contentDescription = "enter the time "
            )

        }
    }


}

// all done lets preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun TimePreview() {
    val timePickerState = rememberTimePickerState(is24Hour = false)

    JetpackComposeUiComponentsMaterial3Theme {
        TimePicker(
            state = timePickerState,
            colors = TimePickerDefaults.colors().copy(
                clockDialColor = Color.White,
                //ad more color if you wanna change
            )
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showBackground = true)
fun DisplayModePickerPreview() {
    val displayModeState = remember { mutableStateOf(DisplayMode.Picker) }
    JetpackComposeUiComponentsMaterial3Theme {
        DisplayModeToggleButton(
            displayModeState = displayModeState,
            modifier = Modifier
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun DisplayModeInputPreview() {
    val displayModeState = remember { mutableStateOf(DisplayMode.Input) }
    JetpackComposeUiComponentsMaterial3Theme {
        DisplayModeToggleButton(
            displayModeState = displayModeState,
            modifier = Modifier
        )
    }
}