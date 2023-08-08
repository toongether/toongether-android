package kr.toongether.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import kr.toongether.designsystem.utils.NoRippleInteractionSource
import kr.toongether.model.Shorts

fun LazyListScope.shortsCardItems(
    items: List<Shorts>,
    modifier: Modifier = Modifier,
    onItemClick: (shorts: Shorts) -> Unit
) = items(
    items = items,
    key = { it.id },
    itemContent = { shorts ->
        ShortsCard(
            modifier = modifier
                .clickable(
                    interactionSource = remember { NoRippleInteractionSource() },
                    indication = null
                ) { onItemClick(shorts) },
            thumbnail = shorts.thumbnail,
            title = shorts.title,
            writer = shorts.writer,
            createdDate = shorts.createdDate
        )
    }
)
