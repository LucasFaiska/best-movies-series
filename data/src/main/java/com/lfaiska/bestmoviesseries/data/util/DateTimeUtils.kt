package com.lfaiska.bestmoviesseries.data.util

import java.text.SimpleDateFormat
import java.util.*

//@TODO Move This Utilitary to View
object DateTimeUtils {
    private const val DATE_BR = "dd 'de' MMMM 'de' yyyy"
    private const val ISO8601 = "yyyy-MM-dd'T'HH:mm"

    fun formatDate(dateTime: String): String {
        val original = SimpleDateFormat(ISO8601, Locale.getDefault())
        val target = SimpleDateFormat(DATE_BR, Locale.getDefault())
        return original.parse(dateTime)?.let { target.format(it) } ?: ""
    }
}