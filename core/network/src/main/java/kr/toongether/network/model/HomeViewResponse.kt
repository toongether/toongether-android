package kr.toongether.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HomeViewResponse<T>(
    @SerialName("type") val type: String,
    @SerialName("children") val children: T,
)

@Serializable
open class ChildrenResponse
