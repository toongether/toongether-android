package kr.toongether.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import kotlinx.datetime.LocalDateTime
import kr.toongether.common.toRelativeDateTime
import kr.toongether.designsystem.theme.Gray
import kr.toongether.designsystem.theme.pretendard

@Composable
fun ShortsCard(
    profileImage: String?,
    thumbnail: String,
    title: String,
    writer: String,
    createdDate: LocalDateTime,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Box(
            modifier = modifier
                .fillMaxWidth()
        ) {
            Row(
                modifier = modifier
                    .align(Alignment.CenterStart)
            ) {
                Spacer(modifier = modifier.width(12.dp))

                if (profileImage.isNullOrBlank()) {
                    Image(
                        modifier = modifier.size(35.dp),
                        painter = painterResource(id = kr.toongether.designsystem.R.drawable.ic_default_profile),
                        contentDescription = null
                    )
                } else {
                    AsyncImage(
                        modifier = modifier.size(35.dp),
                        model = profileImage,
                        contentDescription = null
                    )
                }

                Spacer(modifier = modifier.width(8.dp))

                Column {
                    Text(
                        text = writer,
                        fontFamily = pretendard,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.White
                    )

                    Text(
                        text = title,
                        fontFamily = pretendard,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White
                    )
                }
            }

            Text(
                modifier = modifier
                    .align(Alignment.CenterEnd),
                text = createdDate.toRelativeDateTime(),
                fontFamily = pretendard,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = Gray
            )
        }

        Spacer(modifier = modifier.height(8.dp))

        AsyncImage(
            modifier = modifier.fillMaxWidth(),
            model = thumbnail,
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )
    }
}
