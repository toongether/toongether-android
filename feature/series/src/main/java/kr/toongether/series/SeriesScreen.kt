package kr.toongether.series

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.IconButton
import androidx.compose.material.pullrefresh.PullRefreshState
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kr.toongether.designsystem.component.ToongetherScrollableTabRow
import kr.toongether.designsystem.component.ToongetherTabRow
import kr.toongether.designsystem.component.ToongetherTopAppBar
import kr.toongether.designsystem.theme.pretendard
import kr.toongether.episode.navigatoin.navigateToEpisode
import kr.toongether.model.DayOfWeek
import kr.toongether.model.Series
import kr.toongether.series.tabs.AllScreen
import kr.toongether.series.tabs.FridayScreen
import kr.toongether.series.tabs.MondayScreen
import kr.toongether.series.tabs.SaturdayScreen
import kr.toongether.series.tabs.SundayScreen
import kr.toongether.series.tabs.ThursdayScreen
import kr.toongether.series.tabs.TuesdayScreen
import kr.toongether.series.tabs.WednesdayScreen
import kr.toongether.ui.LoadingScreen
import kr.toongether.ui.seriesCardItems
import org.orbitmvi.orbit.compose.collectAsState

@OptIn(ExperimentalPagerApi::class, ExperimentalMaterialApi::class)
@Composable
internal fun SeriesRoute(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: SeriesViewModel = hiltViewModel(),
) {
    val state by viewModel.collectAsState()
    val pagerState = rememberPagerState(/* initialPage = LocalDate.now().dayOfWeek.value */)

    val coroutineScope = rememberCoroutineScope()

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

    val swipeRefreshState = rememberPullRefreshState(
        state.isLoading,
        { viewModel.fetchPagingSeries(pageToDayOfWeek(pagerState.currentPage)) }
    )
    val scrollState = rememberScrollState()

    SeriesScreen(
        modifier = modifier,
        allSeriesList = state.allSeries.collectAsLazyPagingItems(),
        mondaySeriesList = state.mondaySeries.collectAsLazyPagingItems(),
        tuesdaySeriesList = state.tuesdaySeries.collectAsLazyPagingItems(),
        wednesdaySeriesList = state.wednesdaySeries.collectAsLazyPagingItems(),
        thursdaySeriesList = state.thursdaySeries.collectAsLazyPagingItems(),
        fridaySeriesList = state.fridaySeries.collectAsLazyPagingItems(),
        saturdaySeriesList = state.saturdaySeries.collectAsLazyPagingItems(),
        sundaySeriesList = state.sundaySeries.collectAsLazyPagingItems(),
        onTabClick = {
            coroutineScope.launch {
                pagerState.scrollToPage(it)
            }
        },
        onComicClick = { navController.navigateToEpisode(id = it.id) },
        pagerState = pagerState,
        scrollState = scrollState,
        refreshState = swipeRefreshState,
        isRefresh = state.isLoading
    )
}

@OptIn(ExperimentalPagerApi::class, ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
internal fun SeriesScreen(
    modifier: Modifier = Modifier,
    allSeriesList: LazyPagingItems<Series>,
    mondaySeriesList: LazyPagingItems<Series>,
    tuesdaySeriesList: LazyPagingItems<Series>,
    wednesdaySeriesList: LazyPagingItems<Series>,
    thursdaySeriesList: LazyPagingItems<Series>,
    fridaySeriesList: LazyPagingItems<Series>,
    saturdaySeriesList: LazyPagingItems<Series>,
    sundaySeriesList: LazyPagingItems<Series>,
    onTabClick: (tabIndex: Int) -> Unit,
    onComicClick: (Series) -> Unit,
    pagerState: PagerState,
    scrollState: ScrollState,
    refreshState: PullRefreshState,
    isRefresh: Boolean
) {
    val configuration = LocalConfiguration.current

    Surface(
        modifier = modifier
            .fillMaxSize()
            .statusBarsPadding(),
        color = Color.Black
    ) {

        Column(
            modifier = modifier
                .fillMaxSize()
                .pullRefresh(refreshState)
                .verticalScroll(scrollState)
        ) {
            ToongetherTopAppBar(
                title = {
                    Text(
                        text = "연재 웹툰",
                        fontFamily = pretendard,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                    )
                },
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

            Box(
                modifier = modifier
                    .fillMaxSize()
            ) {

                HorizontalPager(
                    modifier = modifier.fillMaxSize(),
                    count = 8,
                    state = pagerState
                ) {
                    when (it) {
                        0 -> AllScreen(seriesList = allSeriesList, onComicClick = onComicClick)
                        1 -> MondayScreen(
                            seriesList = mondaySeriesList,
                            onComicClick = onComicClick
                        )

                        2 -> TuesdayScreen(
                            seriesList = tuesdaySeriesList,
                            onComicClick = onComicClick
                        )

                        3 -> WednesdayScreen(
                            seriesList = wednesdaySeriesList,
                            onComicClick = onComicClick
                        )

                        4 -> ThursdayScreen(
                            seriesList = thursdaySeriesList,
                            onComicClick = onComicClick
                        )

                        5 -> FridayScreen(
                            seriesList = fridaySeriesList,
                            onComicClick = onComicClick
                        )

                        6 -> SaturdayScreen(
                            seriesList = saturdaySeriesList,
                            onComicClick = onComicClick
                        )

                        7 -> SundayScreen(
                            seriesList = sundaySeriesList,
                            onComicClick = onComicClick
                        )
                    }
                }
            }
        }
    }
}
