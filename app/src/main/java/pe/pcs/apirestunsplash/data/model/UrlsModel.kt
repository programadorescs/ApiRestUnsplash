package pe.pcs.apirestunsplash.data.model

import com.google.gson.annotations.SerializedName

data class UrlsModel(
    @SerializedName("regular") val regular: String="",
    @SerializedName("small") val small: String=""
)
