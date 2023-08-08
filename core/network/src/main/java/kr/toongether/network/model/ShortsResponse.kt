package kr.toongether.network.model

import com.google.gson.annotations.SerializedName

data class ShortsResponse(
    @field:SerializedName("id")
    val id: Long,
    @field:SerializedName("title")
    val title: String,
    @field:SerializedName("writer")
    val writer: String,
    @field:SerializedName("thumbnail")
    val thumbnail: String,
    @field:SerializedName("createdDate")
    val createdDate: String,
)
