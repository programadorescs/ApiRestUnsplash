package pe.pcs.apirestunsplash.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import pe.pcs.apirestunsplash.data.remote.model.PhotoModel

@Entity(
    tableName = "photo"
)
data class PhotoEntity(
    @PrimaryKey
    @ColumnInfo("id") var id: String = "",
    @ColumnInfo("createdAt") var createdAt: String = "",
    @ColumnInfo("updatedAt") var updatedAt: String = "",
    @ColumnInfo("description") var description: String? = "",
    @ColumnInfo("likes") val likes: Int = 0
)

fun PhotoModel.toDatabase() = PhotoEntity(
    id = id,
    createdAt = created_at,
    updatedAt = updated_at,
    description = description,
    likes = likes
)