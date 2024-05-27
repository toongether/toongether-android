package kr.toongether.episodeinterface

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import kotlinx.coroutines.Dispatchers
import kr.toongether.designsystem.icon.ToongetherIcons
import kr.toongether.designsystem.icon.icons.ArrowLeft
import kr.toongether.designsystem.theme.ToongetherColors
import kr.toongether.designsystem.theme.pretendard
import kr.toongether.designsystem.utils.NoRippleInteractionSource
import kr.toongether.model.Episode
import kr.toongether.ui.LoadingScreen
import kr.toongether.ui.seriesCardItems
import java.nio.ByteBuffer

@ExperimentalMaterial3Api
@Composable
fun EpisodeScreen(
    modifier: Modifier = Modifier,
    uiState: EpisodeState,
    onItemClick: (Episode) -> Unit,
    onClickBack: () -> Unit,
) {
    when (uiState) {
        is EpisodeState.Loading -> {
           LoadingScreen()
        }

        is EpisodeState.Success -> {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                containerColor = Color(uiState.data.titleMaker.color.toColorInt()),
                topBar = {
                    TopAppBar(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        title = {
                            Text(
                                text = uiState.data.title.replace("\n", " "),
                                fontFamily = pretendard,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Medium,
                                color = ToongetherColors.White
                            )
                        },
                        navigationIcon = {
                            Icon(
                                modifier = modifier
                                    .padding(end = 4.dp)
                                    .clickable(
                                        interactionSource = NoRippleInteractionSource(),
                                        indication = null,
                                        onClick = onClickBack
                                    ),
                                imageVector = ToongetherIcons.ArrowLeft,
                                contentDescription = null,
                                tint = ToongetherColors.White
                            )
                        },
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = Color(uiState.data.titleMaker.color.toColorInt())
                        )
                    )
                }
            ) { paddingValues ->
                LazyColumn(
                    modifier = modifier
                        .fillMaxSize()
                        .background(Color(uiState.data.titleMaker.color.toColorInt()))
                        .padding(horizontal = 12.dp)
                        .padding(paddingValues),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    item {
                        Column {
                            Box {
                                AsyncImage(
                                    modifier = modifier
                                        .fillMaxWidth()
                                        .clip(RoundedCornerShape(10.dp))
                                        .aspectRatio(1f),
                                    model = uiState.data.titleMaker.backgroundImage,
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop
                                )

                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .aspectRatio(1f)
                                        .background(
                                            Brush.verticalGradient(
                                                listOf(
                                                    Color(uiState.data.titleMaker.color.toColorInt()).copy(
                                                        0f
                                                    ),
                                                    Color(uiState.data.titleMaker.color.toColorInt()).copy(
                                                        0.8f
                                                    )
                                                )
                                            )
                                        )
                                )

                                AsyncImage(
                                    modifier = Modifier
                                        .width(140.dp)
                                        .align(Alignment.BottomCenter)
                                        .padding(bottom = 12.dp),
                                    model = ImageRequest.Builder(LocalContext.current)
                                        .data(ByteBuffer.wrap(uiState.data.titleMaker.titleSvg.toByteArray()))
                                        .decoderFactory(SvgDecoder.Factory())
                                        .decoderDispatcher(Dispatchers.IO)
                                        .build(),
                                    contentDescription = null
                                )
                            }

                            Spacer(modifier = Modifier.height(12.dp))

                            Text(
                                text = uiState.data.description,
                                fontFamily = pretendard,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Medium,
                                color = ToongetherColors.Gray80
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            Text(
                                text = uiState.data.genre.joinToString("  ·  "),
                                fontFamily = pretendard,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium,
                                color = ToongetherColors.Gray80
                            )

                            Spacer(modifier = Modifier.height(12.dp))
                        }
                    }
                    seriesCardItems(
                        items = uiState.data.episodeList,
                        onItemClick = onItemClick
                    )
                }
            }
        }
    }
}
