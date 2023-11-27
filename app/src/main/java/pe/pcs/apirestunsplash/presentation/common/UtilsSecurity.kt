package pe.pcs.apirestunsplash.presentation.common

import android.util.Base64
import java.security.MessageDigest

object UtilsSecurity {
    fun createSHAHash512(cadena: String): String {
        return try {
            val digest = MessageDigest.getInstance("SHA-512")
            val hash = digest.digest(cadena.toByteArray(charset("UTF-8")))
            Base64.encodeToString(hash, 0).replace("[\n\r]".toRegex(), "")
        } catch (ex: Exception) {
            throw RuntimeException(ex)
        }
    }
}