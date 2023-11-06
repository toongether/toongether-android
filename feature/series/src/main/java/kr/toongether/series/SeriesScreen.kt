package kr.toongether.series

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kr.toongether.designsystem.component.ToongetherScrollableTabRow
import kr.toongether.designsystem.component.ToongetherTabRow
import kr.toongether.designsystem.component.ToongetherTopAppBar
import kr.toongether.designsystem.theme.ToongetherColors
import kr.toongether.designsystem.theme.pretendard
import kr.toongether.episode.navigatoin.navigateToEpisode
import kr.toongether.model.DayOfWeek
import kr.toongether.model.Series
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

    val allSeriesList = state.allSeries.collectAsLazyPagingItems()

    SeriesScreen(
        modifier = modifier,
        allSeriesList = allSeriesList,
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
    )
}

@OptIn(ExperimentalPagerApi::class, ExperimentalMaterial3Api::class)
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
) {
    val configuration = LocalConfiguration.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .statusBarsPadding()
            .background(ToongetherColors.Black),
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

        Column(
            modifier = modifier
                .background(ToongetherColors.Black)
                .fillMaxSize()
        ) {

            HorizontalPager(
                modifier = modifier.fillMaxSize(),
                count = 8,
                state = pagerState
            ) {
                TabScreen(
                    seriesList = when (it) {
                        1 -> mondaySeriesList
                        2 -> tuesdaySeriesList
                        3 -> wednesdaySeriesList
                        4 -> thursdaySeriesList
                        5 -> fridaySeriesList
                        6 -> saturdaySeriesList
                        7 -> sundaySeriesList
                        else -> allSeriesList
                    },
                    onComicClick = onComicClick,
                )
            }
        }
    }
}
