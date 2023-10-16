package pe.pcs.apirestunsplash.domain.model

import pe.pcs.apirestunsplash.data.local.entity.UrlsEntity
import pe.pcs.apirestunsplash.data.remote.model.UrlsModel

data class Urls(
    val regular: String = "",
    val small: String = ""
)

fun UrlsModel.toDomain() = Urls(
    regular = regular,
    small = small
)

fun UrlsEntity.toDomain() = Urls(
    regular = regular,
    small = small
)
