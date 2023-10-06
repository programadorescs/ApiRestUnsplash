package pe.pcs.apirestunsplash.data.api

import pe.pcs.apirestunsplash.data.model.PhotoModel
import retrofit2.http.GET

interface UnsplashApi {

    @GET("photos/?")
    suspend fun getPhotos(): List<PhotoModel>

}