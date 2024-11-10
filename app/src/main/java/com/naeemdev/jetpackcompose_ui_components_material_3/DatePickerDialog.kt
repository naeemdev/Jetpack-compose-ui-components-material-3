package com.naeemdev.jetpackcompose_ui_components_material_3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CalendarLocale
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.naeemdev.jetpackcompose_ui_components_material_3.ui.theme.JetpackComposeUiComponentsMaterial3Theme
import com.naeemdev.jetpackcompose_ui_components_material_3.util.toFormattedDateWithDay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerDialog(
    modifier: Modifier,
    initialDate: Long,
    onDateSelected: (Long) -> Unit,
    title: String = "Select date",
    initialDisplayMode: DisplayMode = DisplayMode.Picker,
    onCancel: () -> Unit
) {
    val calendarLocale = CalendarLocale.getDefault()
    val datePickerState = remember {
        DatePickerState(
            locale = calendarLocale,
            initialDisplayMode = initialDisplayMode,
            initialSelectedDateMillis = initialDate,
            initialDisplayedMonthMillis = initialDate
        )

    }
    val dateText = remember(initialDate) {
        initialDate.toFormattedDateWithDay()

    }
    //showing the dialog
    Dialog(
        onDismissRequest = onCancel,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Surface(
            shape = RoundedCornerShape(28.dp),
            color = Color.White,
            modifier = Modifier.wrapContentSize()
        ) {
            Column(
                modifier = Modifier
                    .wrapContentSize()
            ) {
                //date picker UI
                DatePicker(
                    state = datePickerState,
                    modifier = modifier,
                    title = {
                        Text(
                            text = title,
                            color = Color.Black,
                            modifier = Modifier.padding(16.dp)
                        )
                    },
                    headline = {
                        Text(
                            text = dateText, // display formated date
                            modifier = Modifier.padding(start = 16.dp),
                            color = Color.DarkGray
                        )
                    },
                    showModeToggle = true,
                    //customise the color
                    colors = DatePickerDefaults.colors().copy(
                        containerColor = Color.White,
                        titleContentColor = Color.Red,
                        // add more color if you want to customise UI
                        // lets change the text color of cal UI
                        dateTextFieldColors = TextFieldDefaults.colors(
                            focusedTextColor = Color.Blue,
                            //you can add more here
                        )

                    ),
                )
                Spacer(modifier = Modifier.height(16.dp)) //add space
                //lets add button
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(onClick = onCancel) {
                        Text(text = "Cancel")
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    TextButton(onClick = {
                        datePickerState.selectedDateMillis?.let { onDateSelected(it) }
                        onCancel()
                    }) {
                        Text(text = "Ok")
                    }

                }
            }
        }

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun DisplayDatePreview() {
    //add preview
    JetpackComposeUiComponentsMaterial3Theme {
        DatePickerDialog(
            initialDate = System.currentTimeMillis(),
            modifier = Modifier,
            onDateSelected = {},
            onCancel = {}
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun DisplayDatePreviewWithinput() {
    //add preview
    JetpackComposeUiComponentsMaterial3Theme {
        DatePickerDialog(
            initialDate = System.currentTimeMillis(),
            modifier = Modifier,
            onDateSelected = {},
            onCancel = {},
            initialDisplayMode = DisplayMode.Input
        )
    }
}