package com.naeemdev.jetpackcompose_ui_components_material_3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun CustomDialog(
    modifier: Modifier = Modifier,
    title: String = String(),
    message: String = String(),
    icon: Int = R.drawable.ic_warning_24,
    confirmText: String = String(),
    dismissText: String = String(),
    titleColor: Color = Color.Black,
    messageColor: Color = Color.Black,
    tintColor: Color = Color.Red,
    confirmTextColor: Color = Color.Black,
    dismissTextColor: Color = Color.Black,
    titleStyle: TextStyle = MaterialTheme.typography.titleMedium,
    messageStyle: TextStyle = MaterialTheme.typography.bodyMedium,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit

) {
    Dialog(onDismissRequest = onDismiss) {
        Surface(
            modifier = modifier,
            tonalElevation = 4.dp,
            shape = RoundedCornerShape(8.dp),
            color = Color.White
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.Center
            )
            {
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = "Icon",
                    tint = tintColor,
                    modifier = Modifier
                        .padding(
                            top = 16.dp,
                            bottom = 8.dp
                        )
                        .size(50.dp)
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally)
                )
                Text(
                    text = title,
                    style = titleStyle,
                    color = titleColor,
                    modifier = Modifier.padding(bottom = 8.dp, top = 16.dp)
                )
                Text(
                    text = message,
                    style = messageStyle,
                    color = messageColor,
                    modifier = Modifier.padding(top = 8.dp)
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(onDismiss) {
                        Text(
                            text = dismissText,
                            style = MaterialTheme.typography.bodyMedium,
                            color = dismissTextColor
                        )
                    }
                    TextButton(onConfirm) {
                        Text(
                            text = confirmText,
                            style = MaterialTheme.typography.bodyMedium,
                            color = confirmTextColor
                        )

                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CustomDialogPreview() {
    CustomDialog(
        title = "Title",
        message = "Message",
        confirmText = "Confirm",
        dismissText = "Dismiss",
        onDismiss = {},
        onConfirm = {}
    )
}