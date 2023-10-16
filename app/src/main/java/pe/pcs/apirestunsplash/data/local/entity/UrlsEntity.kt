package pe.pcs.apirestunsplash.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import pe.pcs.apirestunsplash.data.remote.model.UrlsModel

@Entity(
    tableName = "urls"
)
data class UrlsEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") var id: Int = 0,
    @ColumnInfo("idphoto") var idPhoto: String = "",
    @ColumnInfo("regular") val regular: String = "",
    @ColumnInfo("small") val small: String = ""
)

fun UrlsModel.toDatabase() = UrlsEntity(
    regular = regular,
    small = small
)