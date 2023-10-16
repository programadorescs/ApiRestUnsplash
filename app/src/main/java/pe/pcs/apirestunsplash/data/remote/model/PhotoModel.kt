package pe.pcs.apirestunsplash.data.remote.model

import com.google.gson.annotations.SerializedName

data class PhotoModel(
    @SerializedName("id") var id: String = "",
    @SerializedName("created_at") var created_at: String = "",
    @SerializedName("updated_at") var updated_at: String = "",
    @SerializedName("alt_description") var description: String? = "",
    @SerializedName("likes") var likes: Int,
    @SerializedName("urls") var urls: UrlsModel? = UrlsModel()
)
