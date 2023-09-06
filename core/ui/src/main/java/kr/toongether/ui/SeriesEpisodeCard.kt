package kr.toongether.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import kotlinx.datetime.LocalDateTime
import kr.toongether.common.toSimpleDate
import kr.toongether.designsystem.theme.Gray
import kr.toongether.designsystem.theme.Shape
import kr.toongether.designsystem.theme.pretendard

@Composable
fun EpisodeCard(
    modifier: Modifier = Modifier,
    thumbnailImage: String,
    title: String,
    createdDate: LocalDateTime
) {
    Row(
        modifier = modifier.fillMaxWidth()
    ) {
        AsyncImage(
            modifier = Modifier
                .size(160.dp, 100.dp)
                .clip(Shape.medium),
            model = thumbnailImage,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column(
            modifier = Modifier
                .align(Alignment.CenterVertically)
        ) {
            Text(
                text = title,
                fontSize = 16.sp,
                fontFamily = pretendard,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(3.dp))

            Text(
                text = createdDate.toSimpleDate(),
                fontSize = 16.sp,
                fontFamily = pretendard,
                fontWeight = FontWeight.SemiBold,
                color = Gray
            )
        }
    }
}
