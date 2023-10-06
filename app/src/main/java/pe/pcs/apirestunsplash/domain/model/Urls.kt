package pe.pcs.apirestunsplash.domain.model

import pe.pcs.apirestunsplash.data.model.UrlsModel

data class Urls(
    val regular: String = "",
    val small: String = ""
)

fun UrlsModel.toDomain() = Urls(
    regular = regular,
    small = small
)
