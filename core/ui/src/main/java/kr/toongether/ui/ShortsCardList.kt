package kr.toongether.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.itemKey
import kr.toongether.designsystem.utils.NoRippleInteractionSource
import kr.toongether.model.Shorts

fun LazyListScope.shortsCardItems(
    items: LazyPagingItems<Shorts>,
    modifier: Modifier = Modifier,
    onItemClick: (shorts: Shorts) -> Unit,
    /* onClickComment: () -> Unit, */
    onClickLike: () -> Unit
) = items(
    count = items.itemCount,
    key = items.itemKey { it.id },
    itemContent = { index ->
        items[index]?.let { shorts ->
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
                /* commentCount = shorts.commentCount, */
                isLiked = shorts.liked,
                likeCount = shorts.likeCount,
                /* nClickComment = onClickComment, */
                onClickLike = onClickLike
            )
        }
    }
)
