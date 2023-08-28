package kr.toongether.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import kr.toongether.designsystem.utils.NoRippleInteractionSource
import kr.toongether.model.ShortsList

fun LazyListScope.shortsCardItems(
    items: List<ShortsList>,
    modifier: Modifier = Modifier,
    onItemClick: (shorts: ShortsList) -> Unit
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
            writer = shorts.author.name,
            createdDate = shorts.createdDate,
            profileImage = shorts.author.profileImage,
        )
    }
)
