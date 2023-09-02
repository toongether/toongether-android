package kr.toongether.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import kr.toongether.designsystem.theme.Shape

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun SeriesCard(
    modifier: Modifier = Modifier,
    titleImage: String,
    thumbnailImage: String,
    backgroundColor: String,
    titleWidth: Float,
) {
    Box(
        modifier = modifier
            .padding(4.dp)
            .clip(Shape.medium)
    ) {
        GlideImage(
            modifier = modifier
                .fillMaxWidth()
                .height(160.dp)
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
                            Color(backgroundColor.toColorInt()),
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
            GlideImage(
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
