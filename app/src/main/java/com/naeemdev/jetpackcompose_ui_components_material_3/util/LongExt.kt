package com.naeemdev.jetpackcompose_ui_components_material_3.util

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun Long.toFormattedDateWithDay(): String {
    val dateFormatter = SimpleDateFormat("yyyy/MM/dd (E)", Locale.getDefault())
    return dateFormatter.format(Date(this))
}

fun Long.toTime(is24Hours: Boolean, locale: Locale = Locale.getDefault()): String {
    val timeFormat = if (is24Hours) {
        SimpleDateFormat("HH:mm", locale)

    } else {
        SimpleDateFormat("h:mm a", locale)
    }
    return try {
        timeFormat.format(this)
    } catch (t: Throwable) {
        t.printStackTrace()
        ""
    }
}