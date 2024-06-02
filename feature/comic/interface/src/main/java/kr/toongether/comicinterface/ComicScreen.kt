package kr.toongether.comicinterface

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import kr.toongether.designsystem.R
import kr.toongether.designsystem.icon.ToongetherIcons
import kr.toongether.designsystem.theme.ToongetherColors
import kr.toongether.designsystem.theme.ToongetherTypography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComicScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    uiState: ComicUiState,
    onLikeClick: (Long) -> Unit,
    navigateToComic: (Long) -> Unit,
) {
    var showInteractionUI by remember { mutableStateOf(true) }

    val lazyListState = rememberLazyListState()
    val isScrollInProgress by remember { derivedStateOf { lazyListState.isScrollInProgress } }
    val canScrollForward by remember { derivedStateOf { lazyListState.canScrollForward } }

    val firstVisibleItemScrollOffset by remember { derivedStateOf { lazyListState.firstVisibleItemScrollOffset } }
    var maxVisibleItemScrollOffset by remember { mutableIntStateOf(0) }

    var scrollbarPosition by remember { mutableIntStateOf(0) }
    val animateScrollbarPosition by animateIntAsState(targetValue = scrollbarPosition, label = "")

    when (uiState) {
        is ComicUiState.Loading -> {
            Box(
                modifier = modifier
                    .fillMaxSize()
                    .background(ToongetherColors.BackgroundNormal),
                contentAlignment = Alignment.Center
            ) {
                val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.toonie_running_rottie))
                LottieAnimation(
                    modifier = Modifier.width(70.dp),
                    composition = composition,
                    iterations = LottieConstants.IterateForever
                )
            }
        }

        is ComicUiState.Success -> {
            LaunchedEffect(key1 = firstVisibleItemScrollOffset) {
                val viewportHeight = lazyListState.layoutInfo.viewportSize.height
                val viewportWidth = lazyListState.layoutInfo.viewportSize.width
                val height = uiState.episode.height
                val lastHeight = uiState.episode.lastHeight
                val width = uiState.episode.width
                val totalItemCount = lazyListState.layoutInfo.totalItemsCount

                if (maxVisibleItemScrollOffset < firstVisibleItemScrollOffset) {
                    maxVisibleItemScrollOffset = firstVisibleItemScrollOffset
                }

                if (width > 0 && height > 0) {
                    val totalHeight =
                        (viewportWidth * height / width) * (totalItemCount - 1) + (viewportWidth * lastHeight / width)
                    scrollbarPosition =
                        (firstVisibleItemScrollOffset + maxVisibleItemScrollOffset * lazyListState.firstVisibleItemIndex) * viewportHeight / totalHeight
                }
            }

            LaunchedEffect(key1 = isScrollInProgress) {
                if (isScrollInProgress) showInteractionUI = false
            }

            Box(
                modifier = modifier
                    .fillMaxSize()
                    .background(ToongetherColors.BackgroundNormal)
                    .safeDrawingPadding()
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null,
                        onClick = { showInteractionUI = !showInteractionUI }
                    )
            ) {
                LazyColumn(
                    state = lazyListState
                ) {
                    itemsIndexed(
                        items = uiState.episode.imageURL,
                    ) { index, imageUrl ->
                        AsyncImage(
                            modifier = Modifier
                                .then(
                                    if (index != uiState.episode.endIndex) {
                                        Modifier
                                            .fillMaxWidth()
                                            .aspectRatio(uiState.episode.width.toFloat() / uiState.episode.height)
                                    } else {
                                        Modifier
                                            .fillMaxWidth()
                                            .aspectRatio(uiState.episode.width.toFloat() / uiState.episode.lastHeight)
                                    }
                                ),
                            model = imageUrl,
                            contentDescription = null,
                            contentScale = ContentScale.FillWidth
                        )
                    }
                }

                AnimatedVisibility(
                    visible = showInteractionUI || !canScrollForward,
                    enter = slideInVertically(initialOffsetY = { -it }) + fadeIn(),
                    exit = slideOutVertically(targetOffsetY = { -it }) + fadeOut()
                ) {
                    TopAppBar(
                        title = {
                            Text(
                                text = uiState.episode.episodeTitle,
                                style = ToongetherTypography.Body2,
                                color = ToongetherColors.LabelNormal,
                            )
                        },
                        navigationIcon = {
                            IconButton(onClick = onBackClick) {
                                Icon(
                                    modifier = Modifier.size(24.dp),
                                    imageVector = ToongetherIcons.Bold.ArrowLeft,
                                    tint = ToongetherColors.LabelNormal,
                                    contentDescription = "Back"
                                )
                            }
                        },
                        actions = {
                            IconButton(onClick = { /*TODO: Navigate To Search*/ }) {
                                Icon(
                                    modifier = Modifier.size(24.dp),
                                    imageVector = ToongetherIcons.Bold.DotsThree,
                                    tint = ToongetherColors.LabelNormal,
                                    contentDescription = "ETC"
                                )
                            }
                        },
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = ToongetherColors.BackgroundNormal,
                        ),
                    )
                }

                AnimatedVisibility(
                    modifier = Modifier.align(Alignment.BottomCenter),
                    visible = showInteractionUI || !canScrollForward,
                    enter = slideInVertically(initialOffsetY = { it }) + fadeIn(),
                    exit = slideOutVertically(targetOffsetY = { it }) + fadeOut()
                ) {
                    Row(
                        modifier = modifier
                            .fillMaxWidth()
                            .height(64.dp)
                            .background(ToongetherColors.BackgroundNormal)
                            .padding(horizontal = 4.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Row {
                            Column(
                                modifier = Modifier
                                    .height(48.dp)
                                    .padding(horizontal = 12.dp)
                                    .clickable(
                                        interactionSource = remember { MutableInteractionSource() },
                                        indication = null,
                                        onClick = { onLikeClick(uiState.episode.id) }
                                    ),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.spacedBy(4.dp)
                            ) {
                                Icon(
                                    modifier = Modifier.size(24.dp),
                                    imageVector = ToongetherIcons.Fill.ThumbsUp,
                                    contentDescription = "Like",
                                    tint = if (uiState.episode.liked) ToongetherColors.PrimaryNormal else ToongetherColors.White,
                                )

                                Text(
                                    text = uiState.episode.likeCount.toString(),
                                    style = ToongetherTypography.Label2,
                                    color = ToongetherColors.LabelNormal,
                                )
                            }
                            Column(
                                modifier = Modifier
                                    .height(48.dp)
                                    .padding(horizontal = 12.dp)
                                    .clickable(
                                        interactionSource = remember { MutableInteractionSource() },
                                        indication = null,
                                        onClick = { /* TODO : Show Comment */ }
                                    ),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.spacedBy(4.dp)
                            ) {
                                Icon(
                                    modifier = Modifier.size(24.dp),
                                    imageVector = ToongetherIcons.Fill.ChatDots,
                                    contentDescription = "Chats",
                                    tint = ToongetherColors.White,
                                )

                                Text(
                                    text = uiState.episode.commentCount.toString(),
                                    style = ToongetherTypography.Label2,
                                    color = ToongetherColors.LabelNormal,
                                )
                            }
                        }

                        Row {
                            IconButton(
                                onClick = { navigateToComic(uiState.episode.beforeEpisode!!)  },
                                modifier = Modifier.size(48.dp),
                                enabled = uiState.episode.beforeEpisode != null,
                            ) {
                                Icon(
                                    modifier = Modifier.size(24.dp),
                                    imageVector = ToongetherIcons.Fill.CaretCircleLeft,
                                    contentDescription = "Previous",
                                    tint = if (uiState.episode.beforeEpisode != null)
                                        ToongetherColors.White
                                    else ToongetherColors.White.copy(alpha = 0.6f),
                                )
                            }

                            IconButton(
                                onClick = { /*TODO: Share*/ },
                                modifier = Modifier.size(48.dp),
                            ) {
                                Icon(
                                    modifier = Modifier.size(24.dp),
                                    imageVector = ToongetherIcons.Bold.List,
                                    contentDescription = "List",
                                    tint = ToongetherColors.White,
                                )
                            }

                            IconButton(
                                onClick = { navigateToComic(uiState.episode.nextEpisode!!) },
                                modifier = Modifier.size(48.dp),
                                enabled = uiState.episode.nextEpisode != null,
                            ) {
                                Icon(
                                    modifier = Modifier.size(24.dp),
                                    imageVector = ToongetherIcons.Fill.CaretCircleRight,
                                    contentDescription = "Next",
                                    tint = if (uiState.episode.nextEpisode != null)
                                        ToongetherColors.White
                                    else ToongetherColors.White.copy(alpha = 0.6f),
                                )
                            }
                        }
                    }
                }

                AnimatedVisibility(
                    modifier = Modifier
                        .offset { IntOffset(0, animateScrollbarPosition) }
                        .align(Alignment.TopEnd),
                    visible = showInteractionUI || !canScrollForward,
                    enter = slideInHorizontally(initialOffsetX = { it }) + fadeIn(),
                    exit = slideOutHorizontally(targetOffsetX = { it }) + fadeOut()
                ) {
                    Box(
                        modifier = Modifier
                            .padding(vertical = 64.dp)
                            .padding(end = 4.dp)
                            .size(28.dp, 48.dp)
                            .background(
                                ToongetherColors.BackgroundNormal,
                                RoundedCornerShape(4.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            modifier = Modifier.size(18.dp),
                            imageVector = ToongetherIcons.Bold.List,
                            contentDescription = null,
                            tint = ToongetherColors.White
                        )
                    }
                }
            }
        }

        is ComicUiState.Error -> TODO()
    }
}
