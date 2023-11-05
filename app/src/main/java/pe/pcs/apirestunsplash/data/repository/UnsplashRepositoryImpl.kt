package pe.pcs.apirestunsplash.data.repository

import pe.pcs.apirestunsplash.data.local.dao.PhotoDao
import pe.pcs.apirestunsplash.data.local.entity.PhotoAndUrls
import pe.pcs.apirestunsplash.data.local.entity.toDatabase
import pe.pcs.apirestunsplash.data.remote.api.UnsplashApi
import pe.pcs.apirestunsplash.domain.model.Photo
import pe.pcs.apirestunsplash.domain.model.toDomain
import pe.pcs.apirestunsplash.domain.repository.UnsplashRepository
import javax.inject.Inject

class UnsplashRepositoryImpl @Inject constructor(
    private val api: UnsplashApi,
    private val dao: PhotoDao
) : UnsplashRepository {

    override suspend fun getList(): List<Photo> {
        //dao.deleteUrlAll()
        //dao.deleteAll()

        if (dao.countPhoto() == 0) {
            val listPhotoAndUrls = mutableListOf<PhotoAndUrls>()

            api.getPhotos().forEach {
                listPhotoAndUrls.add(
                    PhotoAndUrls(
                        it.toDatabase(),
                        it.urls!!.toDatabase()
                    )
                )
            }

            dao.insertPhotosWithUrls(listPhotoAndUrls)
        }

        val listPhoto = mutableListOf<Photo>()

        // Obtener todas las fotos con sus URLs
        dao.getPhotoAndUrls().forEach {
            val entity = it.photo.toDomain()
            entity.urls = it.urls.toDomain()
            listPhoto.add(entity)
        }

        return listPhoto
    }

    override suspend fun getUrlList(): List<Photo> {
        // Usado para trabajar unicamente con la api (sin almacenar los datos en room)
        return api.getPhotos().map {
            it.toDomain()
        }
    }

}