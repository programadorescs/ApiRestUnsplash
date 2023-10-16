package pe.pcs.apirestunsplash.data.local.entity

import androidx.room.Embedded
import androidx.room.Relation

data class PhotoAndUrls(
    @Embedded val photo: PhotoEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "idphoto"
    )
    val urls: UrlsEntity
)
