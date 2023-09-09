package kr.toongether.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import kr.toongether.designsystem.utils.NoRippleInteractionSource
import kr.toongether.model.Shorts

fun LazyListScope.shortsCardItems(
    items: LazyPagingItems<Shorts>,
    modifier: Modifier = Modifier,
    onItemClick: (shorts: Shorts) -> Unit,
    onClickComment: () -> Unit,
    onClickLike: () -> Unit
) = items(
    items = items,
    key = { it.id },
    itemContent = { shorts ->
        ShortsCard(
            modifier = modifier
                .clickable(
                    interactionSource = remember { NoRippleInteractionSource() },
                    indication = null
                ) { onItemClick(shorts!!) },
            thumbnail = shorts!!.thumbnail,
            title = shorts.title,
            writer = shorts.author.name,
            createdDate = shorts.createdDate,
            profileImage = shorts.author.profileImage,
            commentCount = shorts.commentCount,
            isLiked = shorts.isLiked,
            likeCount = shorts.likeCount,
            onClickComment = onClickComment,
            onClickLike = onClickLike
        )
    }
)
