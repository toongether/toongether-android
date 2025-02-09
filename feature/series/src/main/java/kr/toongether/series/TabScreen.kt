package kr.toongether.series

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import kr.toongether.model.Series
import kr.toongether.ui.seriesCardItems

@Composable
internal fun TabScreen(
    modifier: Modifier = Modifier,
    seriesList: LazyPagingItems<Series>,
    onComicClick: (Series) -> Unit
) {
    val configuration = LocalConfiguration.current

    LazyVerticalGrid(
        modifier = modifier
            .fillMaxSize(),
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
