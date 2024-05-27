package kr.toongether.homeinterface

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import androidx.paging.compose.LazyPagingItems
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import kotlinx.coroutines.Dispatchers
import kr.toongether.designsystem.component.ToongetherTopAppBar
import kr.toongether.designsystem.theme.ToongetherColors
import kr.toongether.designsystem.theme.pretendard
import kr.toongether.model.HomeView
import kr.toongether.model.Series
import kr.toongether.model.Shorts
import kr.toongether.model.ViewType
import kr.toongether.ui.ToongetherLottie
import java.nio.ByteBuffer


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    homeViews: List<HomeView>,
    onClickShorts: (Long) -> Unit,
    onClickSeries: (Long) -> Unit
) {
    Scaffold(
        topBar = {
            ToongetherTopAppBar(
                title = {
                    ToongetherLottie(isPlaying = true)
                },
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .padding(paddingValues)
                .padding(horizontal = 12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(
                items = homeViews,
            ) { homeView ->
                when (homeView.type) {
                    ViewType.SERIES_BANNER -> {
                        val banner = (homeView.children as List<*>).map { it as Series }.first()

                        
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(10.dp))
                                .fillMaxWidth()
                                .clickable {
                                    onClickSeries(banner.id)
                                }
                                .aspectRatio(0.75f)
                        ) {
                            AsyncImage(
                                model = banner.titleMaker.backgroundImage,
                                contentDescription = null,
                                contentScale = ContentScale.Crop
                            )

                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(
                                        Brush.verticalGradient(
                                            listOf(
                                                Color(banner.titleMaker.color.toColorInt()).copy(
                                                    0f
                                                ),
                                                Color(banner.titleMaker.color.toColorInt()).copy(
                                                    0.8f
                                                )
                                            )
                                        )
                                    )
                            )

                            Column(
                                modifier = Modifier.align(Alignment.BottomCenter),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                AsyncImage(
                                    modifier = Modifier.width(140.dp),
                                    model = ImageRequest.Builder(LocalContext.current)
                                        .data(ByteBuffer.wrap(banner.titleMaker.titleSvg.toByteArray()))
                                        .decoderFactory(SvgDecoder.Factory())
                                        .decoderDispatcher(Dispatchers.IO)
                                        .build(),
                                    contentDescription = null
                                )

                                Text(
                                    text = banner.author.name,
                                    fontFamily = pretendard,
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 14.sp,
                                    color = ToongetherColors.Gray60
                                )

                                Spacer(modifier = Modifier.height(8.dp))
                            }
                        }
                    }

                    ViewType.SERIES_CONTAINER -> {
                        val seriesList = (homeView.children as List<*>).map { it as Series }
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            seriesList.forEach { series ->
                                Box(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(4.dp))
                                        .weight(1f)
                                        .clickable {
                                            onClickSeries(series.id)
                                        }
                                        .aspectRatio(0.75f)
                                ) {
                                    AsyncImage(
                                        model = series.titleMaker.backgroundImage,
                                        contentDescription = null,
                                        contentScale = ContentScale.Crop
                                    )

                                    Box(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .background(
                                                Brush.verticalGradient(
                                                    listOf(
                                                        Color(series.titleMaker.color.toColorInt()).copy(
                                                            0f
                                                        ),
                                                        Color(series.titleMaker.color.toColorInt()).copy(
                                                            0.8f
                                                        )
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
                                            .data(ByteBuffer.wrap(series.titleMaker.titleSvg.toByteArray()))
                                            .decoderFactory(SvgDecoder.Factory())
                                            .decoderDispatcher(Dispatchers.IO)
                                            .build(),
                                        contentDescription = null
                                    )
                                }
                            }
                        }
                    }

                    ViewType.SHORTS_CONTAINER -> {
                        val shortsList = (homeView.children as List<*>).map { it as Shorts }

                        LazyVerticalGrid(
                            modifier = Modifier.heightIn(max = 1000.dp),
                            columns = GridCells.Fixed(2),
                            verticalArrangement = Arrangement.spacedBy(8.dp),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            items(
                                items = shortsList,
                                key = { it.id }
                            ) { shorts ->
                                Column(
                                    modifier = Modifier
                                        .clickable {
                                            onClickShorts(shorts.id)
                                        }
                                ) {
                                    AsyncImage(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .clip(RoundedCornerShape(4.dp))
                                            .aspectRatio(1.6f),
                                        model = shorts.thumbnail,
                                        contentDescription = null,
                                        contentScale = ContentScale.Crop
                                    )

                                    Spacer(modifier = Modifier.height(4.dp))

                                    Text(
                                        text = shorts.title,
                                        fontFamily = pretendard,
                                        fontWeight = FontWeight.Medium,
                                        fontSize = 16.sp,
                                        color = Color.White,
                                    )

                                    Text(
                                        text = shorts.author.name,
                                        fontFamily = pretendard,
                                        fontWeight = FontWeight.Normal,
                                        fontSize = 12.sp,
                                        color = ToongetherColors.Gray60
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
