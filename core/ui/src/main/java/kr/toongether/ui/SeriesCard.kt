package kr.toongether.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
import androidx.core.graphics.toColorInt
import coil.compose.AsyncImage
import kr.toongether.designsystem.theme.Shape

@Composable
fun SeriesCard(
    modifier: Modifier = Modifier,
    titleImage: String,
    thumbnailImage: String,
    backgroundColor: String,
    titleWidth: Float
) {
    var width by remember { mutableStateOf(1.dp) }
    val localDensity = LocalDensity.current

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
                .height(103.dp)
                .align(Alignment.BottomCenter)
                .background(
                    brush = Brush.verticalGradient(
                        listOf(
                            Color.Transparent,
                            Color(backgroundColor.toColorInt()).copy(alpha = 0.9f)
                        )
                    )
                )
        )

        Box(
            modifier = modifier
                .fillMaxWidth()
                .height(63.dp)
                .align(Alignment.BottomCenter)
        ) {
            AsyncImage(
                modifier = modifier
                    .width(titleWidth.dp)
                    .align(Alignment.Center),
                model = titleImage,
                contentDescription = null,
                contentScale = ContentScale.FillWidth
            )
        }
    }
}
