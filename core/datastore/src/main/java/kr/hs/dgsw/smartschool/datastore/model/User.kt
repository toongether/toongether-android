package kr.hs.dgsw.smartschool.datastore.model

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: String = "",
    val pw: String = "",
    val accessToken: String = "",
    val refreshToken: String = "",
)
