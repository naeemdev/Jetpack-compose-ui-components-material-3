package com.naeemdev.jetpackcompose_ui_components_material_3.clicksurfacesandclicks

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.naeemdev.jetpackcompose_ui_components_material_3.ui.theme.JetpackComposeUiComponentsMaterial3Theme


@Composable
fun TutorialContent() {
    LazyColumn(Modifier.fillMaxSize()) {
        item {
            TutorialHeader("Clickable")
            StyleableTutorialText(
                "Adding clickable to modifier make it clickable" +
                        "\n before clickable add Modifier.clickable"
            )
            ClickableModifierExample()
        }
        item {
            TutorialHeader("Surface")
            StyleableTutorialText(" 1 Surface can clips its children to selected shape")
            SurfaceShapeExample()
        }
        item {
            StyleableTutorialText("2 Surface can set z index and border of its children")
            SurfaceZIndexExample()
        }
        item {
            StyleableTutorialText(text = "4-) Surface can set content color for Text and Image.")
            SurfaceContentColorExample()
        }
        item {
            StyleableTutorialText(
                text = "5-) Components can have offset in both x and y axes. Surface inside" +
                        " another surface gets clipped when it overflows from it's parent."
            )
            SurfaceClickPropagationExample()
        }

    }

}

@Composable
fun SurfaceZIndexExample() {
    Row {
        val modifier = Modifier
            .aspectRatio(1f)
            .weight(1f) // make sure that we use the width
            .padding(12.dp)

        Surface(
            shape = RectangleShape,
            modifier = modifier,
            color = Color.Red,
            shadowElevation = 5.dp,
            tonalElevation = 10.dp,
            border = BorderStroke(5.dp, color = Color(0xFFFF6F00))
        ) { }

        //Rounded corner Shape
        Surface(
            shape = RoundedCornerShape(5.dp),
            modifier = modifier,
            color = Color.Green,
            shadowElevation = 5.dp,
            tonalElevation = 10.dp,
            border = BorderStroke(5.dp, color = Color(0xFF4CAF50))
        ) { }
        // Circle Shape
        Surface(
            shape = CircleShape,
            modifier = modifier,
            color = (Color(0xFF26C6DA)),
            border = BorderStroke(2.dp, color = Color(0xFF004D40))
        ) {}

        // Rectangle with cut corner on top left
        Surface(
            shape = CutCornerShape(topStartPercent = 20),
            modifier = modifier,
            color = (Color(0xFFB2FF59)),
            border = BorderStroke(2.dp, color = Color(0xFFd50000))
        ) {}
    }

}

/*
* 1) Clipping: Surface clips its children to the shape specified by [shape]
*
* 2) Elevation: Surface elevates its children on the Z axis by [elevation] pixels,
* and draws the appropriate shadow.*/
@Composable
fun SurfaceShapeExample() {
    Row {
        // set Aspect ratio to 1:1 to have same width and height
        val modifier = Modifier
            .aspectRatio(1f)
            .weight(1f) // make sure that we use the width
            .padding(12.dp)
        //Rectangle Shape
        Surface(
            shape = RectangleShape,
            modifier = modifier,
            color = Color.Red
        ) { }
        //Rounded corner Shape
        Surface(
            shape = RoundedCornerShape(5.dp),
            modifier = modifier,
            color = Color.Green
        ) { }

        //Circle Shape
        Surface(
            shape = CircleShape,
            modifier = modifier,
            color = Color.Blue
        ) { }
        // CutCornerShape
        Surface(
            shape = CutCornerShape(10.dp),
            modifier = modifier,
            color = (Color(0xFF7E57C2))
        ) {}
    }
}
@Composable
fun SurfaceContentColorExample() {
    // Padding on Surface is padding for background and Text. Padding on Text is padding
    // between font and Surface
    Surface(
        modifier = Modifier.padding(12.dp),
        shape = RoundedCornerShape(10.dp),
        color = (Color(0xFFFDD835)),
        contentColor = (Color(0xFF26C6DA))
    ) {
        Text(
            text = "Text inside Surface uses Surface's content color as a default color.",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(8.dp)
        )
    }
}
@Composable
fun SurfaceClickPropagationExample() {

    // Provides a Context that can be used by Android applications
    val context = LocalContext.current
  Box (
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable(onClick = {
                Toast
                    .makeText(context, "Box Clicked", Toast.LENGTH_SHORT)
                    .show()
            })
    ) {

        Surface(
            shape = RoundedCornerShape(10.dp),
            color = (Color(0xFFFDD835)),
            modifier = Modifier
                .size(150.dp)
                .padding(12.dp)
                .clickable(onClick = {
                    Toast
                        .makeText(
                            context,
                            "Surface(Left) inside Box is clicked!",
                            Toast.LENGTH_SHORT
                        )
                        .show()
                })
        ) {

            Surface(
                shape = CircleShape,
                modifier = Modifier
                    .size(80.dp)
                    .offset(x = 50.dp, y = (-20).dp)
                    .clickable(onClick = {
                        Toast
                            .makeText(
                                context,
                                "Surface inside Surface is clicked!",
                                Toast.LENGTH_SHORT
                            )
                            .show()
                    }),
                shadowElevation = 12.dp,
                color = (Color(0xFF26C6DA))
            ) {}

        }

        Surface(
            shape = CutCornerShape(10.dp),
            modifier = Modifier
                .size(110.dp)
                .padding(12.dp)
                .offset(x = 110.dp, y = 20.dp)
                .clickable(onClick = {
                    Toast
                        .makeText(
                            context,
                            "Surface(Right) inside Box is clicked!",
                            Toast.LENGTH_SHORT
                        )
                        .show()

                }),
            color = (Color(0xFFF4511E)),
            shadowElevation = 8.dp
        ) {}
    }
}
@Composable
fun ClickableModifierExample() {
    val context = LocalContext.current
    Row(Modifier.height(120.dp)) {
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()
                .background(Color.Blue)
                .clickable {
                    Toast
                        .makeText(context, "Clicked", Toast.LENGTH_SHORT)
                        .show()
                },
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                color = Color.White,
                fontSize = 24.sp,
                text = "Click Me"
            )
        }
        // clickable now have padding
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()
                .background(Color.Green)
                .padding(15.dp)
                .clickable {
                    Toast
                        .makeText(context, "Clicked", Toast.LENGTH_SHORT)
                        .show()
                },
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                color = Color.White,
                fontSize = 24.sp,
                text = "Click Me"
            )
        }
    }

}

@Composable
fun StyleableTutorialText(text: String) {
    Text(text = text)

}

@Preview(showBackground = true)
@Composable
fun TutorialContentPreview() {
    JetpackComposeUiComponentsMaterial3Theme {
        TutorialContent()
    }

}
