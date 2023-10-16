package pe.pcs.apirestunsplash.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import pe.pcs.apirestunsplash.data.local.entity.PhotoAndUrls
import pe.pcs.apirestunsplash.data.local.entity.PhotoEntity
import pe.pcs.apirestunsplash.data.local.entity.UrlsEntity

@Dao
interface PhotoDao {

    @Query("SELECT Count(id) FROM photo")
    suspend fun countPhoto(): Int

    @Insert
    suspend fun insert(entity: PhotoEntity)

    @Insert
    suspend fun insertUrl(entity: UrlsEntity)

    @Query("DELETE FROM photo")
    suspend fun deleteAll()

    @Query("DELETE FROM urls")
    suspend fun deleteUrlAll()

    @Transaction
    suspend fun insertPhotoWithUrl(photo: PhotoEntity, url: UrlsEntity) {
        insert(photo)
        url.idPhoto = photo.id
        insertUrl(url)
    }

    @Transaction
    suspend fun insertPhotosWithUrls(photos: List<PhotoAndUrls>) {
        for (photoWithUrl in photos) {
            insert(photoWithUrl.photo)

            photoWithUrl.urls.idPhoto = photoWithUrl.photo.id
            insertUrl(photoWithUrl.urls)
        }
    }

    @Transaction
    @Query("SELECT * FROM photo")
    suspend fun getPhotoAndUrls(): List<PhotoAndUrls>

}