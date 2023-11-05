package kr.toongether.series

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import kr.toongether.designsystem.theme.ToongetherColors
import kr.toongether.model.Series
import kr.toongether.ui.ToonieRunningIndicator
import kr.toongether.ui.seriesCardItems

@OptIn(ExperimentalMaterialApi::class)
@Composable
internal fun TabScreen(
    modifier: Modifier = Modifier,
    seriesList: LazyPagingItems<Series>,
    onComicClick: (Series) -> Unit,
    onRefresh: () -> Unit
) {
    val configuration = LocalConfiguration.current

    var refreshing by remember { mutableStateOf(false) }
    val swipeRefreshState = rememberPullRefreshState(refreshing, onRefresh)

    LazyVerticalGrid(
        modifier = modifier
            .fillMaxSize()
            .pullRefresh(swipeRefreshState),
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
        item(span = { GridItemSpan(3) }) {
            Box(
                modifier = modifier
                    .background(ToongetherColors.Black)
                    .fillMaxWidth()
                    .height(
                        if (refreshing) 100.dp
                        else lerp(0.dp, 100.dp, swipeRefreshState.progress.coerceIn(0f..1f))
                    ),
                contentAlignment = Alignment.Center
            ) {
                ToonieRunningIndicator(isPlaying = swipeRefreshState.progress.coerceIn(0f..1f) == 1f || refreshing)
            }
        }
        when (seriesList.loadState.refresh) {
            LoadState.Loading -> {
                refreshing = true
            }
            else -> {
                refreshing = false
                seriesCardItems(
                    items = seriesList,
                    onItemClick = onComicClick
                )
            }
        }
    }

}