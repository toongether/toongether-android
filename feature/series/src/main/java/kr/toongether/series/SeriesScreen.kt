package kr.toongether.series

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshIndicator
import com.google.accompanist.swiperefresh.SwipeRefreshState
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import kotlinx.coroutines.launch
import kr.toongether.designsystem.component.ToongetherScrollableTabRow
import kr.toongether.designsystem.component.ToongetherTabRow
import kr.toongether.designsystem.component.ToongetherTopAppBar
import kr.toongether.episode.navigatoin.navigateToEpisode
import kr.toongether.model.DayOfWeek
import kr.toongether.model.Series
import kr.toongether.ui.LoadingScreen
import kr.toongether.ui.seriesCardItems
import org.orbitmvi.orbit.compose.collectAsState
import java.time.LocalDate

@OptIn(ExperimentalPagerApi::class)
@Composable
internal fun SeriesRoute(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: SeriesViewModel = hiltViewModel()
) {
    val state by viewModel.collectAsState()
    val pagerState = rememberPagerState(initialPage = LocalDate.now().dayOfWeek.value)
    val coroutineScope = rememberCoroutineScope()

    val swipeRefreshState = rememberSwipeRefreshState(isRefreshing = state.isLoading)
    val pageToDayOfWeek = { page: Int ->
        when (page) {
            1 -> DayOfWeek.MONDAY
            2 -> DayOfWeek.TUESDAY
            3 -> DayOfWeek.WEDNESDAY
            4 -> DayOfWeek.THURSDAY
            5 -> DayOfWeek.FRIDAY
            6 -> DayOfWeek.SATURDAY
            7 -> DayOfWeek.SUNDAY
            else -> null
        }
    }

    SeriesScreen(
        modifier = modifier,
        seriesList = when (pagerState.currentPage) {
            1 -> state.mondaySeries
            2 -> state.tuesdaySeries
            3 -> state.wednesdaySeries
            4 -> state.thursdaySeries
            5 -> state.fridaySeries
            6 -> state.saturdaySeries
            7 -> state.sundaySeries
            else -> state.allSeries
        }.collectAsLazyPagingItems(),
        onTabClick = {
            coroutineScope.launch {
                pagerState.scrollToPage(it)
            }
        },
        onComicClick = { navController.navigateToEpisode(id = it.id) },
        pagerState = pagerState,
        onRefresh = { viewModel.fetchPagingSeries(pageToDayOfWeek(pagerState.currentPage)) },
        swipeRefreshState = swipeRefreshState
    )
}

@OptIn(ExperimentalPagerApi::class)
@Composable
internal fun SeriesScreen(
    modifier: Modifier = Modifier,
    seriesList: LazyPagingItems<Series>,
    onTabClick: (tabIndex: Int) -> Unit,
    onComicClick: (Series) -> Unit,
    pagerState: PagerState,
    onRefresh: () -> Unit,
    swipeRefreshState: SwipeRefreshState
) {
    val configuration = LocalConfiguration.current

    Surface(
        modifier = modifier
            .fillMaxSize()
            .statusBarsPadding(),
        color = Color.Black
    ) {
        Box(
            modifier = modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = modifier
                    .fillMaxSize()
            ) {
                ToongetherTopAppBar(
                    title = "연재 웹툰"
                )

                if (configuration.screenWidthDp < 412) {
                    ToongetherScrollableTabRow(
                        modifier = modifier.fillMaxWidth(),
                        tabs = listOf("전체", "월", "화", "수", "목", "금", "토", "일"),
                        selectedTabIndex = pagerState.currentPage,
                        onTabClick = onTabClick
                    )
                } else {
                    ToongetherTabRow(
                        modifier = modifier.fillMaxWidth(),
                        tabs = listOf("전체", "월", "화", "수", "목", "금", "토", "일"),
                        selectedTabIndex = pagerState.currentPage,
                        onTabClick = onTabClick
                    )
                }

                HorizontalPager(
                    modifier = modifier.fillMaxSize(),
                    count = 8,
                    state = pagerState
                ) {
                    when (seriesList.loadState.refresh) {
                        is LoadState.Loading -> {
                            LoadingScreen()
                        }
                        is LoadState.Error -> {
                            // TODO : Error 처리
                        }
                        else -> {
                            SwipeRefresh(
                                state = swipeRefreshState,
                                onRefresh = onRefresh,
                                indicator = { state, refreshTrigger ->
                                    SwipeRefreshIndicator(
                                        state = state,
                                        refreshTriggerDistance = refreshTrigger,
                                        backgroundColor = Color.Black,
                                        contentColor = Color.White
                                    )
                                }
                            ) {
                                LazyVerticalGrid(
                                    modifier = modifier.fillMaxSize(),
                                    columns = if (configuration.screenWidthDp < 400) {
                                        GridCells.Fixed(3)
                                    } else {
                                        GridCells.Adaptive(120.dp)
                                    },
                                    contentPadding = PaddingValues(
                                        horizontal = 8.dp,
                                        vertical = 10.dp
                                    )
                                ) {
                                    seriesCardItems(
                                        items = seriesList,
                                        onItemClick = onComicClick
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
