package kr.toongether.seriesinterface

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import kotlinx.coroutines.launch
import kr.toongether.designsystem.component.tab.ToongetherTab
import kr.toongether.designsystem.component.tab.ToongetherTabRow
import kr.toongether.designsystem.icon.ToongetherIcons
import kr.toongether.designsystem.theme.ToongetherColors
import kr.toongether.designsystem.theme.ToongetherTypography
import kr.toongether.model.Series
import java.nio.ByteBuffer


@OptIn(ExperimentalMaterial3Api::class,
    ExperimentalSharedTransitionApi::class
)
@Composable
fun SeriesScreen(
    modifier: Modifier = Modifier,
    uiState: SeriesUiState,
    onSeriesClick: (Series) -> Unit,
    sharedTransitionScope: SharedTransitionScope,
    animatedContentScope: AnimatedContentScope,
) {
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    val lazyGridState = rememberLazyGridState()
    val scope = rememberCoroutineScope()

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = ToongetherColors.BackgroundNormal,
        topBar = {
            TopAppBar(
                title = {
                    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(kr.toongether.designsystem.R.raw.toongether_idle_dark_lottie))
                    LottieAnimation(
                        modifier = Modifier.width(100.dp),
                        composition = composition,
                        iterations = LottieConstants.IterateForever
                    )
                },
                actions = {
                    IconButton(onClick = { /*TODO: Navigate To Search*/ }) {
                        Icon(
                            modifier = Modifier.size(24.dp),
                            imageVector = ToongetherIcons.Bold.MagnifyingGlass,
                            tint = ToongetherColors.LabelNormal,
                            contentDescription = "Search"
                        )
                    }

                    IconButton(onClick = { /*TODO: Navigate To Profile*/ }) {
                        Icon(
                            modifier = Modifier.size(24.dp),
                            imageVector = ToongetherIcons.Bold.List,
                            tint = ToongetherColors.LabelNormal,
                            contentDescription = "List"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = ToongetherColors.BackgroundNormal,
                ),
                scrollBehavior = scrollBehavior
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
        ) {
            val tabs = listOf("신작", "월", "화", "수", "목", "금", "토", "일", "완결")
            val pagerState = rememberPagerState { tabs.size }

            ToongetherTabRow(
                selectedTabIndex = pagerState.currentPage
            ) {
                tabs.forEachIndexed { index, title ->
                    ToongetherTab(
                        selected = pagerState.currentPage == index,
                        onClick = { scope.launch { pagerState.scrollToPage(index) } },
                    ) {
                        Text(
                            text = title,
                            style = ToongetherTypography.Body3,
                        )
                    }
                }
            }

            val genres = listOf("전체", "드라마", "액션", "로맨스", "일상", "개그", "미스터리", "스포츠", "스릴러", "무협", "학원", "공포", "스토리")
            var selectedIndex by remember { mutableIntStateOf(0) }

            GenreTabRow(
                selectedIndex = selectedIndex,
                genres = genres,
                onTabClick = {
                    selectedIndex = it
                }
            )

            Spacer(modifier = Modifier.height(12.dp))

            HorizontalPager(
                state = pagerState,
            ) {
                LazyVerticalGrid(
                    columns = GridCells.Adaptive(110.dp),
                    modifier = Modifier.fillMaxSize(),
                    state = lazyGridState,
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp)
                ) {
                    when (uiState) {
                        is SeriesUiState.Success -> {
                            items(
                                items = uiState.seriesList[it],
                                key = { it.id }
                            ) { series ->
                                with(sharedTransitionScope) {
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .aspectRatio(0.75f)
                                            .background(
                                                Color(series.titleMaker.color.toColorInt()),
                                                RoundedCornerShape(4.dp)
                                            )
                                            .clickable(
                                                interactionSource = remember { MutableInteractionSource() },
                                                indication = null,
                                                onClick = { onSeriesClick(series) }
                                            ),
                                        contentAlignment = Alignment.BottomCenter
                                    ) {
                                        AsyncImage(
                                            modifier = Modifier
                                                .sharedElement(
                                                    sharedTransitionScope.rememberSharedContentState(key = "backgroundImage-${series.id}"),
                                                    animatedVisibilityScope = animatedContentScope
                                                )
                                                .clip(RoundedCornerShape(4.dp))
                                                .fillMaxSize(),
                                            model = series.titleMaker.backgroundImage,
                                            contentDescription = null,
                                            contentScale = ContentScale.Crop
                                        )

                                        Box(
                                            modifier = Modifier
                                                .sharedElement(
                                                    sharedTransitionScope.rememberSharedContentState(key = "backgroundColor-${series.id}"),
                                                    animatedVisibilityScope = animatedContentScope
                                                )
                                                .fillMaxWidth()
                                                .fillMaxHeight(0.7f)
                                                .background(
                                                    brush = Brush.verticalGradient(
                                                        colors = listOf(
                                                            Color(series.titleMaker.color.toColorInt()).copy(
                                                                0f
                                                            ),
                                                            Color(series.titleMaker.color.toColorInt()).copy(
                                                                0.9f
                                                            )
                                                        )
                                                    ),
                                                    RoundedCornerShape(4.dp)
                                                )
                                        )

                                        Box(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .height(55.dp)
                                                .padding(horizontal = 20.dp, vertical = 8.dp),
                                        ) {
                                            AsyncImage(
                                                modifier = Modifier
                                                    .fillMaxSize()
                                                    .align(Alignment.Center),
                                                model = ImageRequest.Builder(LocalContext.current)
                                                    .data(ByteBuffer.wrap(series.titleMaker.alignCenterTitleSvg.toByteArray()))
                                                    .decoderFactory(SvgDecoder.Factory())
                                                    .build(),
                                                contentDescription = null,
                                                contentScale = ContentScale.Fit
                                            )
                                        }
                                    }
                                }
                            }
                        }

                        is SeriesUiState.Loading -> {}

                        is SeriesUiState.Error -> TODO()
                    }
                }
            }
        }
    }
}

@Composable
private fun GenreTabRow(
    selectedIndex: Int,
    modifier: Modifier = Modifier,
    genres: List<String>,
    onTabClick: (Int) -> Unit
) {
    LazyRow(
        modifier = modifier
            .fillMaxWidth()
            .selectableGroup(),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 4.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        itemsIndexed(items = genres) { index, genre ->
            val selected = selectedIndex == index
            Box(
                modifier = Modifier
                    .selectable(
                        selected = selectedIndex == index,
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null,
                        role = Role.Tab,
                        onClick = {
                            onTabClick(index)
                        }
                    )
                    .background(
                        color = if (selected) ToongetherColors.White else ToongetherColors.ComponentNormal,
                        shape = RoundedCornerShape(4.dp)
                    )
                    .padding(horizontal = 10.dp, vertical = 6.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = genre,
                    style = ToongetherTypography.Body4,
                    color = if (selected) ToongetherColors.Black else ToongetherColors.LabelNormal.copy(0.28f),
                )
            }
        }
    }
}
