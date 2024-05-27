package kr.toongether.comicinterface

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import kr.toongether.designsystem.component.ToongetherScrollbar
import kr.toongether.designsystem.icon.ToongetherIcons
import kr.toongether.designsystem.icon.icons.ArrowLeft
import kr.toongether.designsystem.icon.icons.ChevronLeft
import kr.toongether.designsystem.icon.icons.ChevronRight
import kr.toongether.designsystem.icon.icons.FilledHeart
import kr.toongether.designsystem.icon.icons.Heart
import kr.toongether.designsystem.icon.icons.Message
import kr.toongether.designsystem.theme.Red
import kr.toongether.designsystem.theme.ToongetherColors
import kr.toongether.designsystem.theme.TransparentBlack80
import kr.toongether.designsystem.theme.pretendard
import kr.toongether.designsystem.utils.NoRippleInteractionSource
import kr.toongether.ui.LoadingScreen

@Composable
fun ComicScreen(
    modifier: Modifier = Modifier,
    lazyListState: LazyListState,
    onBackClick: () -> Unit,
    uiState: ComicState,
    onLikeClick: (Long) -> Unit,
    onNextClick: (Long) -> Unit,
    onBeforeClick: (Long) -> Unit,
    isShowTabs: Boolean,
    isLiked: Boolean,
) {
    val density = LocalDensity.current

    when (uiState) {
        is ComicState.Success -> {
            ToongetherScrollbar(
                modifier = Modifier
                    .safeDrawingPadding()
                    .padding(top = 20.dp),
                listState = lazyListState, isShow = true) {
                Box(
                    modifier = modifier
                        .fillMaxSize()
                ) {
                    val height = with(density) {
                        (uiState.shorts?.height ?: uiState.episode!!.height).toDp()
                    }
                    val lastHeight = with(density) {
                        (uiState.shorts?.lastHeight ?: uiState.episode!!.lastHeight).toDp()
                    }
                    LazyColumn(
                        state = lazyListState
                    ) {
                        itemsIndexed(
                            items = uiState.shorts?.imageURL ?: uiState.episode!!.imageURL
                        ) { index, imageUrl ->
                            if (index < (uiState.shorts?.endIndex ?: uiState.episode!!.endIndex)) {
                                ComicItem(height = height, imageUrl = imageUrl)
                            } else if (index == (uiState.shorts?.endIndex
                                    ?: uiState.episode!!.endIndex)
                            ) {
                                ComicItem(height = lastHeight, imageUrl = imageUrl)
                            }
                        }
                    }

                    AnimatedVisibility(
                        visible = isShowTabs,
                        enter = fadeIn(),
                        exit = fadeOut()
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(TransparentBlack80)
                                .statusBarsPadding()
                                .padding(horizontal = 16.dp, vertical = 8.dp),
                            horizontalArrangement = Arrangement.spacedBy(12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                modifier = modifier
                                    .clickable(
                                        interactionSource = NoRippleInteractionSource(),
                                        indication = null,
                                        onClick = onBackClick
                                    ),
                                imageVector = ToongetherIcons.ArrowLeft,
                                contentDescription = null,
                                tint = ToongetherColors.White
                            )

                            Text(
                                text = uiState.shorts?.title ?: uiState.episode!!.episodeTitle,
                                fontFamily = pretendard,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Normal,
                                color = Color.White
                            )
                        }
                    }

                    AnimatedVisibility(
                        modifier = Modifier.align(Alignment.BottomCenter),
                        visible = isShowTabs,
                        enter = fadeIn(),
                        exit = fadeOut()
                    ) {
                        Row(
                            modifier = modifier
                                .align(Alignment.BottomCenter)
                                .fillMaxWidth()
                                .background(TransparentBlack80)
                                .navigationBarsPadding()
                                .padding(vertical = 8.dp, horizontal = 16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Icon(
                                modifier = modifier
                                    .size(24.dp)
                                    .clickable(
                                        interactionSource = NoRippleInteractionSource(),
                                        indication = null,
                                        onClick = {
                                            onLikeClick(uiState.shorts?.id ?: uiState.episode!!.id)
                                        }
                                    ),
                                imageVector = if (!(uiState.shorts?.liked ?: uiState.episode!!.liked))
                                    ToongetherIcons.Heart else ToongetherIcons.FilledHeart,
                                contentDescription = null,
                                tint = if (!(uiState.shorts?.liked ?: uiState.episode!!.liked))
                                    ToongetherColors.White else Red
                            )

                            Spacer(modifier = Modifier.width(5.dp))

                            Text(
                                text = "${uiState.shorts?.likeCount ?: uiState.episode!!.likeCount}",
                                fontFamily = pretendard,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Normal,
                                color = Color.White
                            )

                            Spacer(modifier = Modifier.width(16.dp))

                            Icon(
                                modifier = modifier
                                    .size(24.dp)
                                    .clickable(
                                        interactionSource = NoRippleInteractionSource(),
                                        indication = null,
                                        onClick = { }
                                    ),
                                imageVector = ToongetherIcons.Message,
                                contentDescription = null,
                                tint = ToongetherColors.White
                            )

                            Spacer(modifier = Modifier.width(5.dp))

                            Text(
                                text = "${uiState.shorts?.commentCount ?: uiState.episode!!.commentCount}",
                                fontFamily = pretendard,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Normal,
                                color = ToongetherColors.White
                            )

                            Spacer(modifier = Modifier.weight(1f))

                            val beforeEpisode = if (uiState.shorts != null) uiState.shorts.beforeEpisode
                            else uiState.episode!!.beforeEpisode

                            Icon(
                                modifier = modifier
                                    .size(24.dp)
                                    .clickable(
                                        interactionSource = NoRippleInteractionSource(),
                                        indication = null,
                                        onClick = { beforeEpisode?.let { onBeforeClick(it) } },
                                        enabled = beforeEpisode != null
                                    ),
                                imageVector = ToongetherIcons.ChevronLeft,
                                contentDescription = null,
                                tint = if (beforeEpisode != null) ToongetherColors.White
                                else ToongetherColors.Gray60
                            )

                            Spacer(modifier = Modifier.width(40.dp))

                            val nextEpisode = if (uiState.shorts != null) uiState.shorts.nextEpisode
                            else uiState.episode!!.nextEpisode

                            Icon(
                                modifier = modifier
                                    .size(24.dp)
                                    .clickable(
                                        interactionSource = NoRippleInteractionSource(),
                                        indication = null,
                                        onClick = { nextEpisode?.let { onNextClick(it) } },
                                        enabled = nextEpisode != null
                                    ),
                                imageVector = ToongetherIcons.ChevronRight,
                                contentDescription = null,
                                tint = if (nextEpisode != null) ToongetherColors.White
                                else ToongetherColors.Gray60
                            )

                        }
                    }
                }
            }
        }

        is ComicState.Loading -> {
            LoadingScreen()
        }
    }
}

@Composable
private fun ComicItem(
    modifier: Modifier = Modifier,
    height: Dp,
    imageUrl: String
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .defaultMinSize(minHeight = height)
            .background(Color.Black)
    ) {
        AsyncImage(
            modifier = modifier
                .fillMaxWidth(),
            model = imageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    }
}
