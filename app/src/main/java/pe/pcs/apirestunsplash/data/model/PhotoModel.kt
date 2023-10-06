package pe.pcs.apirestunsplash.data.model

import com.google.gson.annotations.SerializedName

data class PhotoModel(
    @SerializedName("id") val id: String="",
    @SerializedName("created_at") val created_at: String="",
    @SerializedName("updated_at") val updated_at: String="",
    @SerializedName("alt_description") val description: String? = "",
    @SerializedName("likes") val likes: Int,
    @SerializedName("urls") val urls: UrlsModel? = UrlsModel()
)
