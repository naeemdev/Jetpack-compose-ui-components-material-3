package com.naeemdev.jetpackcompose_ui_components_material_3.bottombar

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomBarItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int? = null
)
