package com.naeemdev.jetpackcompose_ui_components_material_3.util

import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Locale


fun getCurrentTime(is24HourFormat: Boolean): String {
    val current = LocalDateTime.now()
    val dateFormat = if (is24HourFormat) "HH:mm" else "hh:mm a"
    val formatter = DateTimeFormatter.ofPattern(dateFormat, Locale.getDefault())
    return current.format(formatter)
}

fun getParsedTime(initialTime: String, is24HourFormat: Boolean): Calendar {
    val calendar = Calendar.getInstance()
    val inputFormat =
        SimpleDateFormat(if (is24HourFormat) "HH:mm" else "hh:mm a", Locale.getDefault())

    return try {
        val date = inputFormat.parse(initialTime)
        if (date != null) {
            calendar.time = date
        }
        calendar
    } catch (e: Exception) {
        e.printStackTrace() // Optionally log the exception for debugging
        calendar // Return current time if parsing fails
    }
}