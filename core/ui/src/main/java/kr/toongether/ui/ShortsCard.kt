package kr.toongether.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import kr.toongether.designsystem.theme.Gray
import kr.toongether.designsystem.theme.Shape
import kr.toongether.designsystem.theme.pretendard

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ShortsCard(
    thumbnail: String,
    title: String,
    writer: String,
    createdDate: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(horizontal = 12.dp)
    ) {
        GlideImage(
            modifier = modifier
                .size(160.dp, 100.dp)
                .clip(Shape.medium),
            model = thumbnail,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = modifier.width(8.dp))

        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(vertical = 2.dp)
        ) {
            Column(
                modifier = modifier.align(Alignment.TopStart)
            ) {
                Text(
                    text = title,
                    fontFamily = pretendard,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                )
                Text(
                    text = writer,
                    fontFamily = pretendard,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.White,
                )
            }

            Text(
                modifier = modifier.align(Alignment.BottomStart),
                text = createdDate,
                fontFamily = pretendard,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = Gray,
            )
        }
    }
}