package kr.toongether.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.paging.compose.LazyPagingItems
import kr.toongether.designsystem.utils.NoRippleInteractionSource
import kr.toongether.model.Series

fun LazyGridScope.seriesCardItems(
    items: LazyPagingItems<Series>,
    modifier: Modifier = Modifier,
    onItemClick: (series: Series) -> Unit
) = items(
    count = items.itemCount,
    key = { items[it]!!.id },
    itemContent = { index ->
        SeriesCard(
            modifier = modifier
                .clickable(
                    interactionSource = remember { NoRippleInteractionSource() },
                    indication = null
                ) { onItemClick(items[index]!!) },
            title = items[index]!!.titleMaker.titleSvg,
            backgroundImage = items[index]!!.titleMaker.backgroundImage,
            gradientColor = items[index]!!.titleMaker.color,
        )
    }
)
