package kr.toongether.model

data class Signup(
    val userId: String,
    val password: String,
    val name: String,
    val email: String,
    val code: String,
)
