package chistousov.ilya.data.mapper

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun Int.formatTimeToString(): String {
    val date = Date(this * 1000L)
    val format = SimpleDateFormat("dd.MM, hh:mm", Locale.getDefault())
    return format.format(date)
}