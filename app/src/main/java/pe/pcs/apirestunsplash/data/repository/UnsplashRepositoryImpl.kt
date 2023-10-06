package pe.pcs.apirestunsplash.data.repository

import pe.pcs.apirestunsplash.data.api.UnsplashApi
import pe.pcs.apirestunsplash.domain.model.Photo
import pe.pcs.apirestunsplash.domain.model.toDomain
import pe.pcs.apirestunsplash.domain.repository.UnsplashRepository
import javax.inject.Inject

class UnsplashRepositoryImpl @Inject constructor(
    private val api: UnsplashApi
) : UnsplashRepository {

    override suspend fun getList(): List<Photo> {
        return api.getPhotos().map {
            it.toDomain()
        }
    }

}