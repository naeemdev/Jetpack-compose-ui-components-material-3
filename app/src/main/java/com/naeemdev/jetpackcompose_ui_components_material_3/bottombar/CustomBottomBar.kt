package com.naeemdev.jetpackcompose_ui_components_material_3.bottombar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CustomBottomBar(
    items: List<BottomBarItem>,
    selectedItemIndex: Int,
    onItemSelected: (Int) -> Unit
) {
    NavigationBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItemIndex == index,
                onClick = { onItemSelected(index) },
                label = {
                    Text(text = item.title)
                },
                alwaysShowLabel = false,
                icon = {
                    BadgedBox(
                        badge = {
                            if (item.badgeCount != null) {
                                Badge {
                                    Text(text = item.badgeCount.toString())
                                }
                            } else if (item.hasNews) {
                                Badge()
                            }
                        }
                    ) {
                        Icon(
                            imageVector = if (index == selectedItemIndex) {
                                item.selectedIcon
                            } else item.unselectedIcon,
                            contentDescription = item.title
                        )
                    }
                }
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun CustomBottomBarPreview() {
    CustomBottomBar(
        items = listOf(
            BottomBarItem(
                title = "Home",
                selectedIcon = Icons.Default.Home,
                unselectedIcon = Icons.Outlined.Home,
                hasNews = false,
                badgeCount = 0
            ),
            BottomBarItem(
                title = "Home",
                selectedIcon = Icons.Default.Favorite,
                unselectedIcon = Icons.Outlined.Favorite,
                hasNews = false,
                badgeCount = 0
            ),
            BottomBarItem(
                title = "Home",
                selectedIcon = Icons.Default.Email,
                unselectedIcon = Icons.Outlined.Email,
                hasNews = true,
                badgeCount = 45
            ),
            BottomBarItem(
                title = "Home",
                selectedIcon = Icons.Default.Settings,
                unselectedIcon = Icons.Outlined.Settings,
                hasNews = true,
                badgeCount = 1
            )
        ),
        selectedItemIndex = 0,
        onItemSelected = {}
    )

}