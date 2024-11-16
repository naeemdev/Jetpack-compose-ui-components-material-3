package com.naeemdev.jetpackcompose_ui_components_material_3

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.naeemdev.jetpackcompose_ui_components_material_3.ui.theme.JetpackComposeUiComponentsMaterial3Theme

@Composable
fun TextFieldWithLabel(
    modifier: Modifier = Modifier,
    title: String = String(),
    initialText: String = String(),
    placeholderText: String = String(),
    errorText: String = "Please enter valid text",
    titleColor: Color = Color.Black,
    errorColor: Color = Color.Red,
    trailingTintColor: Color = Color.Gray,
    trailingIcon: Int = R.drawable.ic_warning_24,
    isError: Boolean = false,
    isShowClearIcon: Boolean = true,
    onTextChange: (String) -> Unit,
    onClearClick: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        if (title.isNotEmpty()) {
            Text(
                text = title,
                color = if (isError) errorColor else titleColor
            )

        }
        Spacer(modifier = Modifier.height(4.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .border(
                    width = 1.dp,
                    color = if (isError) errorColor else titleColor,
                    shape = RoundedCornerShape(4.dp)
                )

        ) {
            TextField(
                modifier = Modifier.weight(1f),
                value = initialText,
                onValueChange = {
                    onTextChange(it)
                },
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                ),
                maxLines = 5,
                minLines = 1,
                placeholder = {
                    Text(
                        text = placeholderText,
                        color = Color.Gray
                    )
                },
                trailingIcon = {
                    if (isError) {
                        Icon(
                            modifier = Modifier
                                .padding(end = 16.dp, top = 12.dp)
                                .size(20.dp),
                            painter = painterResource(id = trailingIcon),
                            contentDescription = "Error",
                            tint = errorColor
                        )
                    } else if (isShowClearIcon && initialText.isNotEmpty()) {
                        Icon(
                            modifier = Modifier
                                .padding(end = 16.dp, top = 12.dp)
                                .size(20.dp)
                                .clickable {
                                    onClearClick()
                                },
                            painter = painterResource(id = R.drawable.baseline_clear_24),
                            contentDescription = "Clear ",
                            tint = trailingTintColor
                        )
                    }

                }
            )
        }

        if (isError) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier.padding(
                    horizontal = 16.dp,
                    vertical = 4.dp
                )
            ) {
                Icon(
                    modifier = Modifier
                        .padding(end = 4.dp)
                        .size(12.dp),
                    painter = painterResource(id = trailingIcon),
                    contentDescription = "Error",
                    tint = errorColor
                )
                Text(
                    text = errorText,
                    style = MaterialTheme.typography.bodySmall,
                    color = errorColor
                )
            }
        }
    }
}

@Composable
@Preview
fun TextFieldWithLabelPreview() {
    JetpackComposeUiComponentsMaterial3Theme {
        TextFieldWithLabel(
            title = "Title",
            initialText = "Initial Text",
            placeholderText = "Placeholder Text",
            onTextChange = {},
            onClearClick = {}
            )
    }
}
@Composable
@Preview(showBackground = true)
fun TextFieldWithLabelErrorPreview() {
    JetpackComposeUiComponentsMaterial3Theme {
        TextFieldWithLabel(
            title = "Title",
            initialText = "Initial Text",
            isError = true,
            placeholderText = "Placeholder Text",
            onTextChange = {},
            onClearClick = {}
        )
    }
}