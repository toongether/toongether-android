package kr.toongether.shortsinterface

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
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
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import kotlinx.coroutines.launch
import kr.toongether.designsystem.icon.ToongetherIcons
import kr.toongether.designsystem.theme.GangwonEduPower
import kr.toongether.designsystem.theme.ToongetherColors
import kr.toongether.designsystem.theme.ToongetherTypography
import kr.toongether.model.Shorts
import kr.toongether.shorts.R
import my.nanihadesuka.compose.LazyColumnScrollbar
import my.nanihadesuka.compose.ScrollbarSettings


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShortsScreen(
    modifier: Modifier = Modifier,
    onClickLike: (Long, Int) -> Unit,
    uiState: ShortsUiState,
) {
    val scope = rememberCoroutineScope()

    var showInteractionUI by remember { mutableStateOf(true) }

    val lazyListState = rememberLazyListState()
    val isScrollInProgress by remember { derivedStateOf { lazyListState.isScrollInProgress } }
    val canScrollForward by remember { derivedStateOf { lazyListState.canScrollForward } }

    val firstVisibleItemScrollOffset by remember { derivedStateOf { lazyListState.firstVisibleItemScrollOffset } }
    var maxVisibleItemScrollOffset by remember { mutableIntStateOf(0) }

    var scrollbarPosition by remember { mutableIntStateOf(0) }
    val animateScrollbarPosition by animateIntAsState(targetValue = scrollbarPosition, label = "")

    when (uiState) {
        is ShortsUiState.Loading -> {
            Box(
                modifier = modifier
                    .fillMaxSize()
                    .background(ToongetherColors.BackgroundNormal),
                contentAlignment = Alignment.Center
            ) {
                val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(kr.toongether.designsystem.R.raw.toonie_running_rottie))
                LottieAnimation(
                    modifier = Modifier.width(70.dp),
                    composition = composition,
                    iterations = LottieConstants.IterateForever
                )
            }
        }

        is ShortsUiState.Success -> {
            val pagerState = rememberPagerState { uiState.shorts.size }

            LaunchedEffect(key1 = firstVisibleItemScrollOffset) {
                val viewportHeight = lazyListState.layoutInfo.viewportSize.height
                val viewportWidth = lazyListState.layoutInfo.viewportSize.width
                val height = uiState.shorts[pagerState.currentPage].height
                val lastHeight = uiState.shorts[pagerState.currentPage].lastHeight
                val width = uiState.shorts[pagerState.currentPage].width
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

            LaunchedEffect(key1 = pagerState.currentPage) {
                lazyListState.scrollToItem(0)
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
                HorizontalPager(state = pagerState) {
                    LazyColumn(
                        state = lazyListState
                    ) {
                        itemsIndexed(
                            items = uiState.shorts[it].imageURL,
                        ) { index, imageUrl ->
                            AsyncImage(
                                modifier = Modifier
                                    .then(
                                        if (index != uiState.shorts[it].endIndex) {
                                            Modifier
                                                .fillMaxWidth()
                                                .aspectRatio(uiState.shorts[it].width.toFloat() / uiState.shorts[it].height)
                                        } else {
                                            Modifier
                                                .fillMaxWidth()
                                                .aspectRatio(uiState.shorts[it].width.toFloat() / uiState.shorts[it].lastHeight)
                                        }
                                    ),
                                model = imageUrl,
                                contentDescription = null,
                                contentScale = ContentScale.FillWidth
                            )
                        }
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
                                text = "Shortoon",
                                fontFamily = GangwonEduPower,
                                style = ToongetherTypography.Title1,
                                color = ToongetherColors.LabelNormal,
                            )
                        },
                        actions = {
                            IconButton(onClick = { /*TODO: Navigate To Search*/ }) {
                                Icon(
                                    modifier = Modifier.size(24.dp),
                                    imageVector = ToongetherIcons.Bold.MagnifyingGlass,
                                    tint = ToongetherColors.LabelNormal,
                                    contentDescription = "Search"
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
                    BottomBar(
                        profileImage = uiState.shortsList[pagerState.currentPage].author.profileImage,
                        author = uiState.shortsList[pagerState.currentPage].author.name,
                        title = uiState.shorts[pagerState.currentPage].title,
                        liked = uiState.shorts[pagerState.currentPage].liked,
                        likeCount = uiState.shorts[pagerState.currentPage].likeCount,
                        commentCount = uiState.shorts[pagerState.currentPage].commentCount,
                        onLikeClick = {
                            onClickLike(
                                uiState.shorts[pagerState.currentPage].id,
                                pagerState.currentPage
                            )
                        }
                    )
                }

                AnimatedVisibility(
                    modifier = Modifier.align(Alignment.CenterStart),
                    visible = showInteractionUI || !canScrollForward,
                    enter = slideInHorizontally(initialOffsetX = { -it }) + fadeIn(),
                    exit = slideOutHorizontally(targetOffsetX = { -it }) + fadeOut()
                ) {
                    Icon(
                        modifier = Modifier
                            .size(70.dp)
                            .padding(start = 16.dp)
                            .drawBehind {
                                drawCircle(ToongetherColors.White, size.minDimension / 2.5f)
                            }
                            .clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = null,
                                onClick = {
                                    scope.launch {
                                        pagerState.animateScrollToPage(
                                            pagerState.currentPage.minus(1),
                                            animationSpec = tween(delayMillis = 250, durationMillis = 500)
                                        )
                                    }
                                },
                                enabled = pagerState.currentPage > 0
                            ),
                        imageVector = ToongetherIcons.Fill.CaretCircleLeft,
                        contentDescription = "Previous",
                        tint = if (pagerState.currentPage > 0) ToongetherColors.BackgroundNormal else ToongetherColors.BackgroundNormal.copy(
                            0.5f
                        ),
                    )
                }

                AnimatedVisibility(
                    modifier = Modifier.align(Alignment.CenterEnd),
                    visible = showInteractionUI || !canScrollForward,
                    enter = slideInHorizontally(initialOffsetX = { it }) + fadeIn(),
                    exit = slideOutHorizontally(targetOffsetX = { it }) + fadeOut()
                ) {
                    Icon(
                        modifier = Modifier
                            .size(70.dp)
                            .padding(end = 16.dp)
                            .drawBehind {
                                drawCircle(ToongetherColors.White, size.minDimension / 2.5f)
                            }
                            .clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = null,
                                onClick = {
                                    scope.launch {
                                        pagerState.animateScrollToPage(
                                            page = pagerState.currentPage.plus(1),
                                            animationSpec = tween(delayMillis = 250, durationMillis = 500)
                                        )
                                    }
                                },
                                enabled = pagerState.currentPage < uiState.shorts.size - 1
                            ),
                        imageVector = ToongetherIcons.Fill.CaretCircleRight,
                        contentDescription = "Next",
                        tint = if (pagerState.currentPage < uiState.shorts.size - 1) ToongetherColors.BackgroundNormal else ToongetherColors.BackgroundNormal.copy(
                            0.5f
                        ),
                    )
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

        is ShortsUiState.Error -> TODO()
    }
}

@Composable
private fun BottomBar(
    modifier: Modifier = Modifier,
    profileImage: String? = null,
    author: String,
    title: String,
    liked: Boolean,
    likeCount: Int,
    commentCount: Int,
    onLikeClick: () -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(64.dp)
            .background(ToongetherColors.BackgroundNormal)
            .padding(start = 20.dp, end = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                AsyncImage(
                    modifier = Modifier
                        .size(24.dp)
                        .clip(CircleShape),
                    model = profileImage ?: kr.toongether.designsystem.R.drawable.ic_toonie_default,
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )

                Text(
                    text = author,
                    style = ToongetherTypography.Label2,
                    color = ToongetherColors.LabelNormal.copy(0.6f),
                )
            }

            Text(
                text = title,
                style = ToongetherTypography.Label1,
                color = ToongetherColors.LabelNormal,
            )
        }

        Row {
            Column(
                modifier = Modifier
                    .size(48.dp)
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null,
                        onClick = onLikeClick
                    ),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    imageVector = ToongetherIcons.Fill.ThumbsUp,
                    contentDescription = "Like",
                    tint = if (liked) ToongetherColors.PrimaryNormal else ToongetherColors.White,
                )

                Text(
                    text = likeCount.toString(),
                    style = ToongetherTypography.Label2,
                    color = ToongetherColors.LabelNormal,
                )
            }
            Column(
                modifier = Modifier.size(48.dp),
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
                    text = commentCount.toString(),
                    style = ToongetherTypography.Label2,
                    color = ToongetherColors.LabelNormal,
                )
            }
        }
    }
}
