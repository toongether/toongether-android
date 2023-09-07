package kr.toongether.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import kotlinx.datetime.LocalDateTime
import kr.toongether.common.toRelativeDateTime
import kr.toongether.designsystem.theme.Gray
import kr.toongether.designsystem.theme.TransparentBlack80
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
    var width by remember { mutableStateOf(1.dp) }
    val localDensity = LocalDensity.current

    Box(
        modifier = modifier
            .fillMaxWidth()
    ) {
        AsyncImage(
            modifier = modifier
                .fillMaxWidth()
                .onGloballyPositioned {
                    with(localDensity) {
                        width = it.size.width.toDp()
                    }
                }
                .height(width * 5 / 8),
            model = thumbnail,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = modifier
                .fillMaxWidth()
                .height(width * 3 / 8)
                .align(Alignment.BottomCenter)
                .background(
                    brush = Brush.verticalGradient(
                        listOf(
                            Color.Transparent,
                            TransparentBlack80
                        )
                    )
                )
        )

        Column(
            modifier = modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(12.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (profileImage.isNullOrBlank()) {
                    Image(
                        modifier = modifier.size(30.dp),
                        painter = painterResource(id = kr.toongether.designsystem.R.drawable.ic_default_profile),
                        contentDescription = null
                    )
                } else {
                    AsyncImage(
                        modifier = modifier.size(30.dp),
                        model = profileImage,
                        contentDescription = null
                    )
                }

                Spacer(modifier = modifier.width(8.dp))

                Text(
                    text = "$writer • ${createdDate.toRelativeDateTime()}",
                    fontFamily = pretendard,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.White
                )
            }
            Spacer(modifier = modifier.height(8.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = title,
                    fontFamily = pretendard,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
            }
        }
    }
}
