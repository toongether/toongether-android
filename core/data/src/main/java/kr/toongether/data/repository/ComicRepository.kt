package kr.toongether.data.repository

import kr.toongether.model.ComicList
import kr.toongether.model.Shorts

interface ComicRepository {
    suspend fun getShortsList(): List<Shorts>
    suspend fun getComicList(id: Long): ComicList
}
