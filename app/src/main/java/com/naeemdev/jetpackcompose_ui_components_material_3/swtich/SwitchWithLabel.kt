package com.naeemdev.jetpackcompose_ui_components_material_3.swtich

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// lets make the switch with liable
@Composable
fun SwitchWithLabel(
    modifier: Modifier = Modifier,
    title: String = String(),
    initialSwitchState: Boolean = false,
    isLoading: Boolean = false,
    isEnable: Boolean = false,
    checkedThumbColor: Color = Color.White,
    uncheckedThumbColor: Color = Color.Gray,
    checkedTrackColor: Color = Color.Red,
    uncheckedTrackColor: Color = Color.Red,
    uncheckedBorderColor: Color = Color.LightGray,
    disabledCheckedBorderColor: Color = Color.DarkGray,
    disabledUncheckedTrackColor: Color = Color.White,
    disabledCheckedTrackColor: Color = Color.LightGray,
    disabledUncheckedBorderColor: Color = Color.DarkGray,
    disabledCheckedThumbColor: Color = Color.White,
    disabledUncheckedIconColor: Color = Color.LightGray,
    disabledUncheckedThumbColor: Color = Color.LightGray,
    onCheckChanged: (Boolean, (Boolean) -> Unit) -> Unit

) {
    var isChecked by remember { mutableStateOf(initialSwitchState) }
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            color = if (isEnable) Color.Gray else Color.LightGray
        )
        Spacer(modifier = Modifier.weight(1f))
        if (isLoading) {
            CircularProgressIndicator(
                color = Color.Red,
                modifier = Modifier.size(32.dp)
            )
        } else {
            Switch(
                checked = isChecked,
                onCheckedChange = {
                    onCheckChanged(it) { success ->
                        isChecked = success && it
                    }
                },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = checkedThumbColor,
                    uncheckedThumbColor = uncheckedThumbColor,
                    checkedTrackColor = checkedTrackColor,
                    uncheckedTrackColor = uncheckedTrackColor,
                    uncheckedBorderColor = uncheckedBorderColor,
                    disabledCheckedThumbColor = disabledCheckedThumbColor,
                    disabledCheckedTrackColor = disabledCheckedTrackColor,
                    disabledCheckedBorderColor = disabledCheckedBorderColor,
                    disabledUncheckedThumbColor = disabledUncheckedThumbColor,
                    disabledUncheckedTrackColor = disabledUncheckedTrackColor,
                    disabledUncheckedBorderColor = disabledUncheckedBorderColor,
                    disabledUncheckedIconColor = disabledUncheckedIconColor,

                    ),
                modifier = Modifier
                    .height(32.dp),
                enabled = isEnable
            )
        }
    }
}

//lets preview
@Composable
@Preview(showBackground = true)
fun PreviewCustomWithSwitchAndApi() {
    SwitchWithLabel(
        title = "Notification",
        initialSwitchState = true,
        isLoading = false,
        onCheckChanged = { isChecked, callback ->
        }
    )
}

@Composable
@Preview(showBackground = true)
fun PreviewCustomWithSwitchWithFase() {
    SwitchWithLabel(
        title = "Notification",
        initialSwitchState = false,
        isLoading = false,
        onCheckChanged = { isChecked, callback ->
        }
    )
}

@Composable
@Preview(showBackground = true)
fun PreviewShowLoading() {
    SwitchWithLabel(
        title = "Notification with loading",
        initialSwitchState = false,
        isLoading = true,
        onCheckChanged = { isChecked, callback ->
        }
    )
}

@Composable
@Preview(showBackground = true)
fun PreviewShowDisbale() {
    SwitchWithLabel(
        title = "Notification disable",
        initialSwitchState = false,
        isEnable = false,
        isLoading = false,
        onCheckChanged = { isChecked, callback ->
        }
    )
}