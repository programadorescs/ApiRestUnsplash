package pe.pcs.apirestunsplash.domain.model

import pe.pcs.apirestunsplash.data.model.PhotoModel

data class Photo(
    val id: String = "",
    val createdAt: String = "",
    val updatedAt: String = "",
    val description: String? = "",
    val likes: Int,
    val urls: Urls? = Urls()
)

fun PhotoModel.toDomain() = Photo(
    id = id,
    createdAt = created_at,
    updatedAt = updated_at,
    description = description,
    likes = likes,
    urls = urls?.toDomain()
)