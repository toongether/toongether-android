package kr.toongether.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Modifier
import kr.toongether.designsystem.utils.NoRippleInteractionSource

fun LazyListScope.seriesCardItems(
    items: SeriesEpisodeList,
    modifier: Modifier = Modifier,
    onItemClick: (episode: Episode) -> Unit
) = items(
    items = items.episodeList,
    key = { it.episodeId },
    itemContent = { episode ->
        EpisodeCard(
            modifier = modifier
                .clickable(
                    interactionSource = NoRippleInteractionSource(),
                    indication = null,
                    onClick = { onItemClick(episode) }
                ),
            thumbnailImage = episode.thumbnail,
            title = episode.title,
            createdDate = episode.createdDate,
            likeCount = episode.likeCount,
            liked = episode.liked
            /* commentCount = episode.commentCount */
        )
    }
)
