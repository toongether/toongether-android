package kr.toongether.data.repository

import kr.toongether.model.Shorts

interface ComicRepository {
    suspend fun getShortsList(): List<Shorts>
}
