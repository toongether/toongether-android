package kr.toongether.series

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import kr.toongether.designsystem.component.ToongetherScrollableTabRow
import kr.toongether.designsystem.component.ToongetherTabRow
import kr.toongether.designsystem.component.ToongetherTopAppBar
import kr.toongether.episode.navigatoin.navigateToEpisode
import kr.toongether.model.DayOfWeek
import kr.toongether.model.Series
import kr.toongether.ui.seriesCardItems
import org.orbitmvi.orbit.compose.collectAsState
import java.time.LocalDate

@Composable
internal fun SeriesRoute(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: SeriesViewModel = hiltViewModel()
) {
    val today by remember { mutableStateOf(LocalDate.now().dayOfWeek.value) }
    val selectedDayOfWeek = { tabIndex: Int ->
        when (tabIndex) {
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

    var dayOfWeek: DayOfWeek? by remember {
        mutableStateOf(selectedDayOfWeek(today))
    }
//    var cycle: Cycle? by remember { mutableStateOf(null) }

    val state by viewModel.collectAsState()

    LaunchedEffect(dayOfWeek) {
        viewModel.getPagingSeries(dayOfWeek = dayOfWeek)
    }

    var selectedIndex by remember { mutableStateOf(today) }

    SeriesScreen(
        modifier = modifier,
        seriesList = state.seriesList.collectAsLazyPagingItems(),
        selectedIndex = selectedIndex,
        onTabClick = {
            selectedIndex = it
            dayOfWeek = selectedDayOfWeek(it)
        },
        onComicClick = { navController.navigateToEpisode(id = it.id) }
    )
}

@Composable
internal fun SeriesScreen(
    modifier: Modifier = Modifier,
    seriesList: LazyPagingItems<Series>,
    selectedIndex: Int,
    onTabClick: (tabIndex: Int) -> Unit,
    onComicClick: (Series) -> Unit
) {
    val configuration = LocalConfiguration.current

    Surface(
        modifier = modifier
            .fillMaxSize(),
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
                        selectedTabIndex = selectedIndex,
                        onTabClick = onTabClick
                    )
                } else {
                    ToongetherTabRow(
                        modifier = modifier.fillMaxWidth(),
                        tabs = listOf("전체", "월", "화", "수", "목", "금", "토", "일"),
                        selectedTabIndex = selectedIndex,
                        onTabClick = onTabClick
                    )
                }

                LazyVerticalGrid(
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
