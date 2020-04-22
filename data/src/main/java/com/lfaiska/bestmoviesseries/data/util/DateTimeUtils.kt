package com.lfaiska.bestmoviesseries.data.util

import org.threeten.bp.Instant
import org.threeten.bp.LocalDateTime
import org.threeten.bp.ZoneId
import java.text.SimpleDateFormat
import java.util.*

object DateTimeUtils {
    private const val DATE_BR = "dd 'de' MMMM 'de' yyyy"
    private const val TIME_SHORT = "HH:mm"

    private const val ISO8601 = "yyyy-MM-dd'T'HH:mm"

    fun formatDate(dateTime: String): String {
        val original = SimpleDateFormat(ISO8601, Locale.getDefault())
        val target = SimpleDateFormat(DATE_BR, Locale.getDefault())
        return original.parse(dateTime)?.let { target.format(it) } ?: ""
    }

    fun parseMilliseconds(dateTime: String): Long {
        val original = SimpleDateFormat(ISO8601, Locale.getDefault())
        return original.parse(dateTime)?.time ?: 0
    }

    fun stringToLocalDateTime(dateTime: String): LocalDateTime {
        val original = SimpleDateFormat(ISO8601, Locale.getDefault())
        val timestamp = original.parse(dateTime)?.time ?: 0
        return longToLocalDateTime(timestamp)
    }

    fun longToLocalDateTime(timestamp: Long): LocalDateTime {
        return Instant.ofEpochMilli(timestamp).atZone(ZoneId.systemDefault()).toLocalDateTime()
    }
}