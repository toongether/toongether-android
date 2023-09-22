package kr.toongether.home

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import kr.toongether.comic.navigation.navigateToComic
import kr.toongether.designsystem.component.ToongetherTopAppBar
import kr.toongether.designsystem.icon.ToongetherIcons
import kr.toongether.designsystem.icon.icons.Toongether
import kr.toongether.designsystem.theme.Gray50
import kr.toongether.designsystem.theme.Shape
import kr.toongether.designsystem.theme.TransparentBlack80
import kr.toongether.designsystem.theme.pretendard
import kr.toongether.designsystem.utils.NoRippleInteractionSource
import kr.toongether.episode.navigatoin.navigateToEpisode
import kr.toongether.ui.LoadingScreen
import kr.toongether.ui.SeriesCard
import kr.toongether.ui.TitleImageCard
import org.orbitmvi.orbit.compose.collectAsState

@Composable
internal fun HomeRoute(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel(),
    alert: (@Composable () -> Unit) -> Unit,
) {
    val scrollState = rememberScrollState()
    val state by viewModel.collectAsState()

    LaunchedEffect(state.isLoading) {
        alert {
            if (state.isLoading) {
                Box(
                    modifier = modifier
                        .fillMaxSize()
                        .background(Color.Black),
                ) {
                    Image(
                        modifier = modifier.align(Alignment.Center),
                        painter = painterResource(id = kr.toongether.designsystem.R.drawable.ic_toongether),
                        contentDescription = null
                    )
                }
            }
        }
    }


    HomeScreen(
        modifier = modifier,
        state = state,
        scrollState = scrollState,
        onClickShorts = {
            navController.navigateToComic(shortsId = it)
        },
        onClickSeries = {
            navController.navigateToEpisode(id = it)
        },
    )
}

@Composable
internal fun HomeScreen(
    modifier: Modifier = Modifier,
    state: HomeState,
    scrollState: ScrollState,
    onClickShorts: (shortsId: Long) -> Unit,
    onClickSeries: (seriesId: Long) -> Unit,
) {
    Box {
        Column(
            modifier = modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {
            Box {
                if (state.titleBanner != null) {
                    TitleImageCard(
                        thumbnailImage = state.titleBanner.titleInfo.thumbnailImage,
                        titleImage = state.titleBanner.titleInfo.titleImage,
                        titleWidth = state.titleBanner.titleInfo.titleWidth,
                        author = state.titleBanner.author.name,
                        dayOfWeek = state.titleBanner.dayOfWeek.title,
                        cycle = state.titleBanner.cycle.title,
                        genre = state.titleBanner.genre
                    )

                    Box(
                        modifier = modifier
                            .fillMaxWidth()
                            .height(95.dp)
                            .background(
                                Brush.verticalGradient(
                                    listOf(
                                        TransparentBlack80,
                                        Color.Transparent
                                    )
                                )
                            )
                    )
                }

                ToongetherTopAppBar(
                    modifier = modifier
                        .statusBarsPadding(),
                    titleIcon = ToongetherIcons.Toongether,
                    backgroundColor = Color.Transparent
                )
            }

            Column(modifier = modifier.padding(horizontal = 12.dp)) {
                Spacer(modifier = modifier.height(10.dp))

                Text(
                    text = "인기 단편 웹툰",
                    fontFamily = pretendard,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    color = Color.White
                )
                Spacer(modifier = modifier.height(8.dp))

                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    items(
                        items = state.shortsList,
                    ) {
                        ShortsItem(
                            modifier = modifier
                                .clickable(
                                    interactionSource = NoRippleInteractionSource(),
                                    indication = null,
                                    onClick = { onClickShorts(it.id) }
                                ),
                            thumbnail = it.thumbnail,
                            title = it.title,
                        )
                    }
                }

                Spacer(modifier = modifier.height(16.dp))

                Text(
                    text = "최신 연재 웹툰",
                    fontFamily = pretendard,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    color = Color.White
                )
                Spacer(modifier = modifier.height(8.dp))

                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    items(
                        items = state.seriesList,
                    ) {
                        SeriesItem(
                            modifier = modifier
                                .clickable(
                                    interactionSource = NoRippleInteractionSource(),
                                    indication = null,
                                    onClick = { onClickSeries(it.id) }
                                ),
                            titleImage = it.titleInfo.titleImage,
                            thumbnailImage = it.titleInfo.thumbnailImage,
                            backgroundColor = it.titleInfo.color,
                            titleWidth = it.titleInfo.titleWidth
                        )
                    }
                }

                Spacer(modifier = modifier.height(20.dp))

                Text(
                    modifier = modifier.align(Alignment.CenterHorizontally),
                    text = "Copyright © 2023 Progress. All rights reserved.",
                    fontFamily = pretendard,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 8.sp,
                    color = Gray50
                )

                Spacer(modifier = modifier.height(20.dp))
            }
        }
    }
}

@Composable
private fun ShortsItem(
    modifier: Modifier = Modifier,
    thumbnail: String,
    title: String,
) {
    Box(
        modifier = modifier
            .width(200.dp)
            .height(125.dp)
            .clip(Shape.medium)
    ) {
        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            model = thumbnail,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = modifier
                .fillMaxWidth()
                .height(75.dp)
                .background(
                    Brush.verticalGradient(
                        listOf(
                            Color.Transparent,
                            TransparentBlack80
                        )
                    )
                )
                .align(Alignment.BottomCenter)
        )
        Text(
            modifier = modifier
                .align(Alignment.BottomStart)
                .fillMaxWidth()
                .padding(bottom = 6.dp)
                .padding(horizontal = 6.dp),
            text = title,
            fontFamily = pretendard,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp,
            color = Color.White
        )
    }
}

@Composable
private fun SeriesItem(
    modifier: Modifier = Modifier,
    titleImage: String,
    thumbnailImage: String,
    backgroundColor: String,
    titleWidth: Float,
) {
    Box(
        modifier = modifier
            .height(160.dp)
            .width(120.dp)
            .clip(Shape.medium)
    ) {
        AsyncImage(
            modifier = modifier
                .fillMaxSize()
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
                            Color(backgroundColor.toColorInt())
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
