package kr.toongether.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
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
import kr.toongether.designsystem.icon.ToongetherIcons
import kr.toongether.designsystem.icon.icons.FilledHeart
import kr.toongether.designsystem.icon.icons.FilledMessage
import kr.toongether.designsystem.theme.Gray
import kr.toongether.designsystem.theme.Shape
import kr.toongether.designsystem.theme.pretendard

@Composable
fun EpisodeCard(
    modifier: Modifier = Modifier,
    thumbnailImage: String,
    title: String,
    createdDate: LocalDateTime,
    likeCount: Int,
    commentCount: Int
) {
    Row(
        modifier = modifier.fillMaxWidth()
    ) {
        AsyncImage(
            modifier = Modifier
                .size(120.dp, 75.dp)
                .clip(Shape.medium),
            model = thumbnailImage,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.width(10.dp))

        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.CenterVertically)
        ) {
            Text(
                text = title,
                fontSize = 16.sp,
                fontFamily = pretendard,
                fontWeight = FontWeight.Medium,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(3.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = createdDate.toSimpleDate(),
                    fontSize = 12.sp,
                    fontFamily = pretendard,
                    fontWeight = FontWeight.Normal,
                    color = Gray
                )

                Spacer(modifier = Modifier.width(10.dp))

                Icon(
                    modifier = Modifier.size(14.dp),
                    imageVector = ToongetherIcons.FilledHeart,
                    contentDescription = null,
                    tint = Gray
                )

                Spacer(modifier = Modifier.width(3.dp))

                Text(
                    text = likeCount.toString(),
                    fontSize = 12.sp,
                    fontFamily = pretendard,
                    fontWeight = FontWeight.Normal,
                    color = Gray
                )
                /*
                Spacer(modifier = Modifier.width(8.dp))

                Icon(
                    modifier = Modifier.size(14.dp),
                    imageVector = ToongetherIcons.FilledMessage,
                    contentDescription = null,
                    tint = Gray
                )

                Spacer(modifier = Modifier.width(3.dp))

                Text(
                    text = commentCount.toString(),
                    fontSize = 12.sp,
                    fontFamily = pretendard,
                    fontWeight = FontWeight.Normal,
                    color = Gray
                )*/
            }
        }
    }
}
