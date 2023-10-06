package pe.pcs.apirestunsplash

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ApiUnsplashApp : Application() {

    companion object {
        private var instancia: ApiUnsplashApp? = null

        fun getContext(): Context {
            return instancia!!.applicationContext
        }
    }

    init {
        instancia = this
    }

}