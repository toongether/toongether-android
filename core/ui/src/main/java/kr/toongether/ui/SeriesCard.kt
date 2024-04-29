package kr.toongether.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
import androidx.core.graphics.toColorInt
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import kotlinx.coroutines.Dispatchers
import kr.toongether.designsystem.theme.Shape
import java.nio.ByteBuffer

@Composable
fun SeriesCard(
    modifier: Modifier = Modifier,
    title: String,
    backgroundImage: String,
    gradientColor: String,
) {
    Box(
        modifier = modifier
            .padding(4.dp)
            .clip(Shape.medium)
    ) {
        AsyncImage(
            modifier = modifier
                .fillMaxWidth()
                .aspectRatio(0.75f)
                .align(Alignment.BottomCenter),
            model = backgroundImage,
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
                            Color(gradientColor.toColorInt())
                        )
                    )
                )
        )

        AsyncImage(
            modifier = Modifier
                .width(65.dp)
                .padding(bottom = 8.dp)
                .align(Alignment.BottomCenter),
            model = ImageRequest.Builder(LocalContext.current)
                .data(ByteBuffer.wrap(title.toByteArray()))
                .decoderFactory(SvgDecoder.Factory())
                .decoderDispatcher(Dispatchers.IO)
                .build(),
            contentDescription = null
        )
    }
}
