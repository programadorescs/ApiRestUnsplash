package pe.pcs.apirestunsplash.presentation.common

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object UtilsDate {

    fun formatearFecha(fecha: Date): String {
        return SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(fecha)
    }

    fun formatearFecha(fecha: String): String {
        val date = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ROOT).parse(fecha)
        return SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(date!!)
    }

}