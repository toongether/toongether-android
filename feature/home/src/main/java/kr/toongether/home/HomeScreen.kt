package kr.toongether.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
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
import kr.toongether.designsystem.theme.ToongetherColors
import kr.toongether.designsystem.theme.TransparentBlack80
import kr.toongether.designsystem.theme.pretendard
import kr.toongether.designsystem.utils.NoRippleInteractionSource
import kr.toongether.episode.navigatoin.navigateToEpisode
import kr.toongether.model.ComicView
import kr.toongether.model.Series
import kr.toongether.model.ViewType
import kr.toongether.ui.SeriesCard
import kr.toongether.ui.TitleImageCard
import kr.toongether.ui.ToongetherLottie
import org.orbitmvi.orbit.compose.collectAsState

@Composable
internal fun HomeRoute(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel(),
    alert: (@Composable () -> Unit) -> Unit,
) {
    val state by viewModel.collectAsState()

    HomeScreen(
        modifier = modifier,
        viewList = state.viewList,
        onClickShorts = {
            navController.navigateToComic(shortsId = it)
        },
        onClickSeries = {
            navController.navigateToEpisode(id = it)
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun HomeScreen(
    modifier: Modifier = Modifier,
    viewList: List<ComicView>,
    onClickShorts: (shortsId: Long) -> Unit,
    onClickSeries: (seriesId: Long) -> Unit,
) {
    val scrollBehavior =
        TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        containerColor = ToongetherColors.Black,
        topBar = {
            ToongetherTopAppBar(
                title = {
                    ToongetherLottie(isPlaying = true)
                },
                scrollBehavior = scrollBehavior
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            viewList.forEach {
                when (it.viewType!!) {
                    ViewType.SERIES_BANNER -> {
                        item {
                            val series = it.children!![0]
                            SeriesBanner(
                                modifier = modifier
                                    .clickable { onClickSeries(series.id!!) },
                                thumbnailImage = series.titleInfo!!.thumbnailImage,
                                color = series.titleInfo!!.color,
                                titleImage = series.titleInfo!!.titleImage,
                                titleWidth = series.titleInfo!!.titleWidth,
                                author = series.author!!.name
                            )
                        }
                    }

                    ViewType.SERIES_CONTAINER -> {
                        item {
                            SeriesContainer(viewList = it.children!!, onClickSeries = onClickSeries)
                        }
                    }

                    ViewType.SHORTS_CONTAINER -> {
                        items(
                            items = it.children!!,
                            key = { shorts -> shorts.id!! }
                        ) { shorts ->
                            ShortsContainer(
                                modifier = modifier.padding(horizontal = 12.dp)
                                    .clickable { onClickShorts(shorts.id!!) },
                                profileImage = shorts.author?.profileImage,
                                thumbnailImage = shorts.thumbnail!!,
                                title = shorts.title!!,
                                author = shorts.author?.name!!,
                                likeCount = shorts.likeCount!!
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun SeriesBanner(
    modifier: Modifier = Modifier,
    thumbnailImage: String,
    color: String,
    titleImage: String,
    titleWidth: Float,
    author: String,
) {
    var width by remember { mutableStateOf(1.dp) }
    val localDensity = LocalDensity.current

    Column(
        modifier = modifier.padding(horizontal = 12.dp)
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
        ) {
            AsyncImage(
                modifier = Modifier
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
                modifier = Modifier
                    .fillMaxWidth()
                    .height(width * 103 / 120)
                    .align(Alignment.BottomCenter)
                    .background(
                        brush = Brush.verticalGradient(
                            listOf(
                                Color.Transparent,
                                Color(color.toColorInt()).copy(alpha = 0.9f)
                            )
                        )
                    )
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
            ) {
                AsyncImage(
                    modifier = Modifier
                        .width(titleWidth.dp * 2)
                        .align(Alignment.CenterHorizontally),
                    model = titleImage,
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    text = author,
                    fontFamily = pretendard,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    color = ToongetherColors.Gray80
                )

                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
private fun SeriesContainer(
    modifier: Modifier = Modifier,
    viewList: List<ComicView>,
    onClickSeries: (seriesId: Long) -> Unit,
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 12.dp)
    ) {
        items(
            items = viewList,
            key = { it.id!! }
        ) {
            Box(
                modifier = Modifier
                    .clip(Shape.medium)
                    .clickable { onClickSeries(it.id!!) }
            ) {
                AsyncImage(
                    modifier = Modifier
                        .width(120.dp)
                        .height(160.dp)
                        .align(Alignment.BottomCenter),
                    model = it.titleInfo!!.thumbnailImage,
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )

                Box(
                    modifier = Modifier
                        .width(120.dp)
                        .height(103.dp)
                        .align(Alignment.BottomCenter)
                        .background(
                            brush = Brush.verticalGradient(
                                listOf(
                                    Color.Transparent,
                                    Color(it.titleInfo!!.color.toColorInt()).copy(alpha = 0.9f)
                                )
                            )
                        )
                )

                Box(
                    modifier = Modifier
                        .width(120.dp)
                        .height(63.dp)
                        .align(Alignment.BottomCenter)
                ) {
                    AsyncImage(
                        modifier = Modifier
                            .width(it.titleInfo!!.titleWidth.dp)
                            .align(Alignment.Center),
                        model = it.titleInfo!!.titleImage,
                        contentDescription = null,
                        contentScale = ContentScale.FillWidth
                    )
                }
            }
        }
    }
}

@Composable
private fun ShortsContainer(
    modifier: Modifier = Modifier,
    profileImage: String?,
    thumbnailImage: String,
    title: String,
    author: String,
    likeCount: Int,
) {
    var width by remember { mutableStateOf(1.dp) }
    val localDensity = LocalDensity.current

    Column(modifier) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned {
                    with(localDensity) {
                        width = it.size.width.toDp()
                    }
                }
                .height(width * 5 / 8)
                .clip(Shape.medium),
            model = thumbnailImage,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                modifier = Modifier
                    .size(30.dp)
                    .clip(RoundedCornerShape(100)),
                model = profileImage ?: kr.toongether.designsystem.R.drawable.ic_default_profile,
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = title,
                    fontFamily = pretendard,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    color = ToongetherColors.White
                )

                Spacer(modifier = Modifier.height(1.dp))

                Text(
                    text = "$author  ·  조회수 ${likeCount}회",
                    fontFamily = pretendard,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    color = ToongetherColors.Gray60
                )
            }
        }
    }
}
