package com.naeemdev.jetpackcompose_ui_components_material_3.chip

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.naeemdev.jetpackcompose_ui_components_material_3.R

@Composable
fun Chip(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = MaterialTheme.colorScheme.primary,
    borderColor: Color = MaterialTheme.colorScheme.onSurface,

    ) {
    Card(
        elevation = CardDefaults.cardElevation(1.dp),
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent,
            contentColor = color
        ),
        border = BorderStroke(1.dp, color = borderColor)
    ) {
        Row(
            modifier = Modifier.padding(start = 8.dp, top = 4.dp, end = 8.dp, bottom = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(8.dp, 8.dp)
                    .clip(CircleShape)
                    .background(color = color)
            )
            Spacer(Modifier.width(4.dp))
            Text(text = text)
        }
    }
}

@Composable
fun CustomChip(
    modifier: Modifier = Modifier,
    text: String,
    cancelable: Boolean = false,
    color: Color = MaterialTheme.colorScheme.primary,
    onChipClicked: (() -> Unit) = {}
) {
    Surface(
        modifier = modifier,
        color = color,
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = text,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(end = 8.dp)
            )

            if (cancelable) {
                CircleCloseButton(
                    Modifier
                        .padding(end = 8.dp)
                        .clickable { onChipClicked })
            }
        }
    }
}

@Composable
fun CircleCloseButton(modifier: Modifier = Modifier, onClick: (() -> Unit)? = null) {
    Surface(color = Color.DarkGray, modifier = modifier, shape = CircleShape) {
        IconButton(
            onClick = { onClick?.invoke() },
            modifier = Modifier
                .size(16.dp)
                .padding(1.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.Close,
                tint = Color(0xFFE0E0E0),
                contentDescription = null
            )
        }
    }
}

@Composable
fun CustomOutlinedChip(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.primary,
    @DrawableRes icon: Int = -1,
    text: String,
    closable: Boolean = false,
    onChipClicked: (() -> Unit) = {}
) {
    Surface(
        modifier = modifier,
        color = color,
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            if (icon != -1) {
                Image(
                    painter = painterResource(id = icon),
                    contentDescription = null,
                    modifier = Modifier.padding(8.dp)
                )
            }

            Text(
                text = text,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(end = 8.dp)
            )

            if (closable) {
                CircleCloseButton(
                    Modifier
                        .padding(end = 8.dp)
                        .clickable { onChipClicked })
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun CustomChipPreview() {
    CustomChip(
        modifier = Modifier.padding(8.dp),
        text = "Custom Chip",
        cancelable = true
    )
}

@Composable
@Preview(showBackground = true)
fun CustomOutlinedChipPreview() {
    CustomOutlinedChip(
        modifier = Modifier.padding(8.dp),
        text = "Custom Outlined Chip",
        closable = true
    )
}

@Composable
@Preview(showBackground = true)
fun CustomOutlinedChipWithIconPreview() {
    CustomOutlinedChip(
        text = "Custom Outlined Chip with Icon",
        closable = true,
        icon = R.drawable.ic_warning_24

    )
}

@Composable
@Preview(showBackground = true)
fun ChipPreview() {
    Chip(text = "Chip")
}