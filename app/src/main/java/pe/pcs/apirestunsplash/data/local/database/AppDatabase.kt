package pe.pcs.apirestunsplash.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import pe.pcs.apirestunsplash.data.local.dao.PhotoDao
import pe.pcs.apirestunsplash.data.local.dao.UserDao
import pe.pcs.apirestunsplash.data.local.entity.PhotoEntity
import pe.pcs.apirestunsplash.data.local.entity.UrlsEntity
import pe.pcs.apirestunsplash.data.local.entity.UserEntity


@Database(
    entities = [
        PhotoEntity::class,
        UrlsEntity::class,
        UserEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase: RoomDatabase() {

    abstract fun photoDao(): PhotoDao

    abstract fun userDao(): UserDao

}