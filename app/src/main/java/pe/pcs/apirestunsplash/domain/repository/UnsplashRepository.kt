package pe.pcs.apirestunsplash.domain.repository

import pe.pcs.apirestunsplash.domain.model.Photo

interface UnsplashRepository {

    suspend fun getList(): List<Photo>

    suspend fun getUrlList(): List<Photo>

}