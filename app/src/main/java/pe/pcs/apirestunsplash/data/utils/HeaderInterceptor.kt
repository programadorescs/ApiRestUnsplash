package pe.pcs.apirestunsplash.data.utils

import okhttp3.Interceptor
import okhttp3.Response
import pe.pcs.apirestunsplash.data.utils.Constants
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HeaderInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val request = chain.request()
        // Obtiene la url original (https://api.unsplash.com/photos/?), antes de agregar la api key
        val originalUrl = request.url

        // Crea la nueva url (https://api.unsplash.com/photos/?&client_id=AQUI_ESTARA_TU_API_KEY),
        // tomando los datos de la url original mas los datos de la api key
        val newUrl = originalUrl.newBuilder()
            .addQueryParameter("client_id", Constants.API_KEY)
            .build()

        // Finalmente, construye la nueva url indicando el metodo, en este caso el GET y la url
        val newRequest = request.newBuilder()
            .url(newUrl)
            .build()

        return chain.proceed(newRequest)
    }

}