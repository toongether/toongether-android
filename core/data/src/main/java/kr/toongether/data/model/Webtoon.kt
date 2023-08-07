package kr.toongether.data.model

import kr.toongether.model.Webtoon
import kr.toongether.network.model.WebtoonResponse
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun WebtoonResponse.asModel(): Webtoon = Webtoon(
    createDate = createDate.toLocalDateTime(),
    id = id,
    title = title,
    writer = writer,
    thumbnail = thumbnail,
)

private fun String.toLocalDateTime(): LocalDateTime =
    LocalDateTime.parse(this, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))