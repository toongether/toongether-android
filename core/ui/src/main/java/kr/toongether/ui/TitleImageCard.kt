package kr.toongether.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import kr.toongether.designsystem.theme.Shape
import kr.toongether.designsystem.theme.pretendard

@Composable
fun TitleImageCard(
    modifier: Modifier = Modifier,
    thumbnailImage: String,
    titleImage: String,
    titleWidth: Float,
    author: String,
    cycle: String,
    genre: String,
    dayOfWeek: String
) {
    var width by remember { mutableStateOf(1.dp) }
    val localDensity = LocalDensity.current

    Column {
        Box(
            modifier = modifier
                .padding(4.dp)
                .clip(Shape.medium)
        ) {
            AsyncImage(
                modifier = modifier
                    .fillMaxWidth()
                    .onGloballyPositioned {
                        with(localDensity) {
                            width = it.size.width.toDp()
                        }
                    }
                    .height(width * 4 / 3)
                    .align(Alignment.BottomCenter),
                model = thumbnailImage,
                contentDescription = null,
                contentScale = ContentScale.Crop
            )

            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .height(width * 103 / 120)
                    .align(Alignment.BottomCenter)
                    .background(
                        brush = Brush.verticalGradient(
                            listOf(
                                Color.Transparent,
                                Color.Black
                            )
                        )
                    )
            )

            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
            ) {
                Text(
                    modifier = modifier.align(Alignment.CenterHorizontally),
                    text = "$author 작가의",
                    fontFamily = pretendard,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Color.White
                )

                AsyncImage(
                    modifier = modifier
                        .width(titleWidth.dp * 3)
                        .align(Alignment.CenterHorizontally),
                    model = titleImage,
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth
                )

                Spacer(modifier = modifier.height(14.dp))

                Text(
                    modifier = modifier.align(Alignment.CenterHorizontally),
                    text = "$genre · $dayOfWeek $cycle",
                    fontFamily = pretendard,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    color = Color.White
                )
            }
        }
    }
}
