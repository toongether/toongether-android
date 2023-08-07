package kr.toongether.network.model

import com.google.gson.annotations.SerializedName

data class WebtoonResponse(
    @field:SerializedName("createDate")
    val createDate: String,
    @field:SerializedName("id")
    val id: Long,
    @field:SerializedName("title")
    val title: String,
    @field:SerializedName("writer")
    val writer: String,
    @field:SerializedName("thumbnail")
    val thumbnail: String,
)
