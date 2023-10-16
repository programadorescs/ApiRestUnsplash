package pe.pcs.apirestunsplash.data.remote.api

import pe.pcs.apirestunsplash.data.remote.model.PhotoModel
import retrofit2.http.GET

interface UnsplashApi {

    @GET("photos/?")
    suspend fun getPhotos(): List<PhotoModel>

}