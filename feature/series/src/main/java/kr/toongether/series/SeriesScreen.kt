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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import kr.toongether.designsystem.component.ToongetherScrollableTabRow
import kr.toongether.designsystem.component.ToongetherTabRow
import kr.toongether.designsystem.component.ToongetherTopAppBar
import kr.toongether.model.Cycle
import kr.toongether.model.DayOfWeek
import kr.toongether.model.Series
import kr.toongether.ui.seriesCardItems

@Composable
internal fun SerialRoute(
    modifier: Modifier = Modifier,
    viewModel: SeriesViewModel = hiltViewModel()
) {
    var dayOfWeek: DayOfWeek? by remember { mutableStateOf(null) }
    var cycle: Cycle? by remember { mutableStateOf(null) }
    val seriesList =
        viewModel.getPagingShorts(dayOfWeek, cycle).collectAsLazyPagingItems()

    var selectedIndex by remember { mutableStateOf(0) }
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

    SerialScreen(
        modifier = modifier,
        seriesList = seriesList,
        selectedIndex = selectedIndex,
        onTabClick = {
            selectedIndex = it
            dayOfWeek = selectedDayOfWeek(it)
        },
        onComicClick = { }
    )
}

@Composable
internal fun SerialScreen(
    modifier: Modifier = Modifier,
    seriesList: LazyPagingItems<Series>,
    selectedIndex: Int,
    onTabClick: (tabIndex: Int) -> Unit,
    onComicClick: (Series) -> Unit
) {
    val configuration = LocalConfiguration.current
    val density = LocalDensity.current.density

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
