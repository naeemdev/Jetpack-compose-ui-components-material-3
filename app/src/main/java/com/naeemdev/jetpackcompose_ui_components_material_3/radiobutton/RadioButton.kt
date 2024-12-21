package com.naeemdev.jetpackcompose_ui_components_material_3.radiobutton

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class RadioButtonTags(
    val parentTag: String = "RadioButton",
)

@Composable
fun RadioButton(
    modifier: Modifier = Modifier,
    selected: Boolean = false,
    enabled: Boolean = true,
    tags: RadioButtonTags = RadioButtonTags(),
    boarderSelectedColor: Color = Color.Transparent,
    boarderUnSelectedColor: Color = Color.Red,
    backgroundUnSelectedColor: Color = Color.Transparent,
    backgroundSelectedColor: Color = Color.Blue,
    shape: Shape = RoundedCornerShape(24.dp),
    onOptionSelected: (() -> Unit)? = null
) {
    val borderColor = if (selected) {
        boarderSelectedColor
    } else boarderUnSelectedColor
    val backgroundColor = if (selected) {
        backgroundUnSelectedColor
    } else {
        backgroundSelectedColor
    }

    Box(
        modifier = modifier
            .size(24.dp)
            .background(
                if (enabled) backgroundColor else Color.Gray,
                shape = shape
            )
            .border(width = 1.dp, color = borderColor, shape = shape)
            .then(
                if (onOptionSelected == null) Modifier else
                    Modifier.selectable(
                        selected = selected,
                        role = Role.RadioButton,
                        onClick = { if (enabled) onOptionSelected.invoke() },
                        enabled = enabled
                    )
            )
            .testTag(tags.parentTag)

    ) {
        if (selected) {
            val color = if (enabled) Color.White else Color.Gray
            Circle(modifier = Modifier.align(Alignment.Center), color)
        }
    }

}

@Composable
fun Circle(
    modifier: Modifier,
    color: Color,
) {
    Canvas(
        modifier = modifier
            .width(8.dp)
            .height(8.dp)
    ) {
        val canvasWidth = size.width
        val canvasHeight = size.height
        drawCircle(
            color = color,
            center = Offset(x = canvasWidth / 2, y = canvasHeight / 2),
            radius = size.minDimension / 2
        )
    }
}

@Composable
@Preview(showBackground = true)
fun RadioButtonPreview() {
    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()
            .padding(10.dp)
            .background(color = Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            RadioButton(selected = false, enabled = true) {
            }
            Spacer(Modifier.padding(top = 20.dp))
            RadioButton(selected = true, enabled = true) {
            }
            Spacer(Modifier.padding(top = 20.dp))
            RadioButton(selected = false, enabled = false) {
            }
            Spacer(Modifier.padding(top = 20.dp))
            RadioButton(selected = true, enabled = false) {
            }
        }

    }

}