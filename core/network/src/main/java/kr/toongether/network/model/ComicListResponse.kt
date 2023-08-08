package kr.toongether.network.model

import com.google.gson.annotations.SerializedName

data class ComicListResponse(
    @field:SerializedName("imageURL")
    val imageUrl: List<String>,
    @field:SerializedName("width")
    val width: Int,
    @field:SerializedName("height")
    val height: Int,
    @field:SerializedName("lastHeight")
    val lastHeight: Int,
    @field:SerializedName("endIndex")
    val endIndex: Int,
)
