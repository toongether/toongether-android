package kr.toongether.model

data class User(
    val id: Long,
    val userId: String,
    val password: String,
    val email: String,
    val name: String,
    val profileImage: String,
)
