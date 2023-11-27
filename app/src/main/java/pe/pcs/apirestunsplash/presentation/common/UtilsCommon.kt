package pe.pcs.apirestunsplash.presentation.common

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import pe.pcs.apirestunsplash.ApiUnsplashApp

object UtilsCommon {
    fun hideKeyboard(view: View) {
        val imm = ApiUnsplashApp.getContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}