package com.naeemdev.jetpackcompose_ui_components_material_3.toolbar

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomCenterAlignedTopAppBar(
    title: String = String(),
    titleColor: Color = Color.Black,
    backgroundColor: Color = Color.White,
    titleStyle: TextStyle = MaterialTheme.typography.titleMedium,
    navigationIcon: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {}
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                color = titleColor,
                style = titleStyle
            )
        },
        navigationIcon = navigationIcon,
        actions = actions,
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = backgroundColor
        )
    )
}


@Composable
@Preview(showBackground = true)
fun CustomCenterAlignedTopAppBarPreview() {
    CustomCenterAlignedTopAppBar(
        title = "Title",
        titleColor = Color.Black,
        backgroundColor = Color.White,
        titleStyle = MaterialTheme.typography.titleMedium,
        navigationIcon = {
            // Navigation icon
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back"
            )
        },
        actions = {
            // Actions you can pass text view or any icon
            Text("Action 1")
            Text("Action 2")
        },

        )
}
