//package kr.toongether.comic
//
//import androidx.compose.animation.AnimatedVisibility
//import androidx.compose.animation.fadeIn
//import androidx.compose.animation.fadeOut
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.defaultMinSize
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.navigationBarsPadding
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.layout.statusBarsPadding
//import androidx.compose.foundation.layout.systemBarsPadding
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.layout.wrapContentSize
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.LazyListState
//import androidx.compose.foundation.lazy.itemsIndexed
//import androidx.compose.foundation.lazy.rememberLazyListState
//import androidx.compose.material3.Icon
//import androidx.compose.material3.Surface
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.platform.LocalConfiguration
//import androidx.compose.ui.platform.LocalDensity
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.Dp
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.hilt.navigation.compose.hiltViewModel
//import androidx.navigation.NavController
//import androidx.navigation.navOptions
//import coil.compose.AsyncImage
//import kr.toongether.comic.navigation.navigateToComic
//import kr.toongether.designsystem.component.ToongetherScrollbar
//import kr.toongether.designsystem.component.ToongetherTopAppBarWithBack
//import kr.toongether.designsystem.icon.ToongetherIcons
//import kr.toongether.designsystem.icon.icons.FilledHeart
//import kr.toongether.designsystem.icon.icons.LeftArrow
//import kr.toongether.designsystem.icon.icons.OutlinedHeart
//import kr.toongether.designsystem.icon.icons.RightArrow
//import kr.toongether.designsystem.theme.Red
//import kr.toongether.designsystem.theme.TransparentBlack
//import kr.toongether.designsystem.theme.pretendard
//import kr.toongether.designsystem.utils.NoRippleInteractionSource
//import kr.toongether.ui.AlertScreen
//import org.orbitmvi.orbit.compose.collectAsState
//import org.orbitmvi.orbit.compose.collectSideEffect
//import java.time.LocalTime
//import kotlin.concurrent.timer
//
//@Composable
//internal fun ComicRoute(
//    episodeNumber: Long,
//    seriesId: Long,
//    navController: NavController,
//    modifier: Modifier = Modifier,
//    viewModel: ComicViewModel = hiltViewModel(),
//    alert: (@Composable () -> Unit) -> Unit
//) {
//    val comicState by viewModel.collectAsState()
//    val lazyListState = rememberLazyListState()
//
//    var isShowAlert by remember { mutableStateOf(false) }
//
//    var isShowTabs by remember { mutableStateOf(true) }
//    var toggledTime: LocalTime? by remember { mutableStateOf(null) }
//    var isTopOrBottom by remember { mutableStateOf(true) }
//
//    viewModel.collectSideEffect {
//        when (it) {
//            is ComicSideEffect.Toast -> {
//                isShowAlert = true
//                alert {
//                    AlertScreen(
//                        isShowAlert = isShowAlert,
//                        text = it.text,
//                        buttonText = "확인"
//                    ) {
//                        isShowAlert = false
//                    }
//                }
//            }
//            is ComicSideEffect.LoginToast -> {
//                isShowAlert = true
//                alert {
//                    AlertScreen(
//                        isShowAlert = isShowAlert,
//                        text = "로그인이 필요해요.",
//                        firstButtonText = "로그인",
//                        onClickFirstButton = {
//                            isShowAlert = false
//                            navController.navigate("login_route")
//                        },
//                        secondButtonText = "취소",
//                        onClickSecondButton = { isShowAlert = false }
//                    )
//                }
//            }
//        }
//    }
//
//    fun showTabs() {
//        if (toggledTime != null) {
//            toggledTime = null
//            isShowTabs = false
//        } else {
//            toggledTime = LocalTime.now().plusSeconds(PlusSecond)
//            isShowTabs = true
//            timer(period = 500) {
//                if (toggledTime == null) {
//                    isShowTabs = false
//                } else {
//                    if (LocalTime.now() > toggledTime) {
//                        isShowTabs = false
//                        toggledTime = null
//                    }
//                }
//            }
//        }
//    }
//
//    LaunchedEffect(Unit) {
//        if (seriesId == -1L) {
//            viewModel.getComic(episodeNumber)
//        } else {
//            viewModel.getComic(seriesId = seriesId, episodeId = episodeNumber)
//        }
//        showTabs()
//    }
//
//    ComicScreen(
//        modifier = modifier,
//        lazyListState = lazyListState,
//        onClickBack = navController::popBackStack,
//        comicState = comicState,
//        onClick = ::showTabs,
//        isShowTabs = isShowTabs || isTopOrBottom,
//        recomposition = {
//            isTopOrBottom = lazyListState.layoutInfo.visibleItemsInfo.firstOrNull()?.index == 0 ||
//                lazyListState.layoutInfo.visibleItemsInfo.lastOrNull()?.index ==
//                lazyListState.layoutInfo.totalItemsCount - 1
//        },
//        onClickLike = {
//            if (seriesId == -1L) {
//                viewModel.likeShorts(episodeNumber)
//            } else {
//                viewModel.likeSeries(comicState.comic.id)
//            }
//        },
//        /* onClickComment = { }, */
//        liked = comicState.liked,
//        likeCount = comicState.likeCount,
//        /* commentCount = comicState.comic.commentCount, */
//        onClickAfter = {
//            navController.navigateToComic(
//                seriesId = seriesId,
//                episodeNumber = comicState.comic.nextEpisode!!,
//                navOptions {
//                    this.popUpTo(kr.toongether.comic.navigation.ComicRoute) {
//                        inclusive = true
//                    }
//                }
//            )
//        },
//        onClickBefore = {
//            navController.navigateToComic(
//                seriesId = seriesId,
//                episodeNumber = comicState.comic.beforeEpisode!!,
//                navOptions {
//                    this.popUpTo(kr.toongether.comic.navigation.ComicRoute) {
//                        inclusive = true
//                    }
//                }
//            )
//        },
//        isNext = comicState.comic.nextEpisode != null,
//        isBefore = comicState.comic.beforeEpisode != null
//    )
//}
//
//@Composable
//internal fun ComicScreen(
//    modifier: Modifier = Modifier,
//    lazyListState: LazyListState,
//    onClickBack: () -> Unit,
//    comicState: ComicState,
//    onClick: () -> Unit,
//    isShowTabs: Boolean,
//    recomposition: () -> Unit,
//    onClickLike: () -> Unit,
//    /* onClickComment: () -> Unit, */
//    liked: Boolean,
//    likeCount: Int,
//    /* commentCount: Int, */
//    onClickBefore: () -> Unit,
//    onClickAfter: () -> Unit,
//    isNext: Boolean,
//    isBefore: Boolean
//) {
//    val minHeight: Dp
//    val lastHeight: Dp
//
//    with(LocalDensity.current) {
//        val screenWidth = LocalConfiguration.current.screenWidthDp.dp.toPx()
//        minHeight = (screenWidth * comicState.comic.height / comicState.comic.width).toDp() - 5.dp
//        lastHeight = comicState.comic.lastHeight.toDp()
//    }
//
//    Surface(
//        modifier = modifier
//            .fillMaxSize(),
//        color = Color.Black
//    ) {
//        Box(
//            modifier = modifier
//                .fillMaxSize()
//                .clickable(
//                    interactionSource = NoRippleInteractionSource(),
//                    indication = null,
//                    onClick = onClick
//                )
//        ) {
//            ToongetherScrollbar(
//                modifier = modifier
//                    .padding(top = 50.dp, bottom = 35.dp)
//                    .systemBarsPadding(),
//                listState = lazyListState,
//                isShow = isShowTabs
//            ) {
//                LazyColumn(
//                    modifier = modifier
//                        .fillMaxSize(),
//                    state = lazyListState
//                ) {
//                    itemsIndexed(
//                        items = comicState.comic.imageUrl
//                    ) { index, imageUrl ->
//                        if (index < comicState.comic.endIndex) {
//                            ComicItem(height = minHeight, imageUrl = imageUrl)
//                        } else if (index == comicState.comic.endIndex) {
//                            ComicItem(height = lastHeight, imageUrl = imageUrl)
//                        }
//                        recomposition.invoke()
//                    }
//                }
//            }
//
//            AnimatedVisibility(
//                visible = isShowTabs,
//                enter = fadeIn(),
//                exit = fadeOut()
//            ) {
//                ToongetherTopAppBarWithBack(
//                    modifier = modifier
//                        .background(TransparentBlack)
//                        .statusBarsPadding(),
//                    title = comicState.comic.title,
//                    onClickBack = onClickBack,
//                    backgroundColor = Color.Transparent
//                )
//            }
//            AnimatedVisibility(
//                modifier = modifier.align(Alignment.BottomCenter),
//                visible = isShowTabs,
//                enter = fadeIn(),
//                exit = fadeOut()
//            ) {
//                Row(
//                    modifier = modifier
//                        .fillMaxWidth()
//                        .wrapContentSize()
//                        .background(TransparentBlack)
//                        .navigationBarsPadding()
//                        .padding(vertical = 8.dp)
//                ) {
//                    Spacer(modifier = modifier.width(16.dp))
//
//                    Icon(
//                        modifier = modifier
//                            .size(20.dp)
//                            .clickable(
//                                interactionSource = NoRippleInteractionSource(),
//                                indication = null,
//                                onClick = onClickLike
//                            ),
//                        imageVector = if (liked.not()) ToongetherIcons.OutlinedHeart else ToongetherIcons.FilledHeart,
//                        contentDescription = null,
//                        tint = if (liked.not()) Color.White else Red
//                    )
//
//                    Spacer(modifier = modifier.width(5.dp))
//
//                    Text(
//                        text = "$likeCount",
//                        fontFamily = pretendard,
//                        fontSize = 16.sp,
//                        fontWeight = FontWeight.Normal,
//                        color = Color.White
//                    )
//                    /*
//                    Spacer(modifier = modifier.width(20.dp))
//
//                    Icon(
//                        modifier = modifier
//                            .size(20.dp)
//                            .clickable(
//                                interactionSource = NoRippleInteractionSource(),
//                                indication = null,
//                                onClick = onClickComment
//                            ),
//                        imageVector = ToongetherIcons.OutlinedMessage,
//                        contentDescription = null,
//                        tint = Color.White
//                    )
//
//                    Spacer(modifier = modifier.width(5.dp))
//
//                    Text(
//                        text = "$commentCount",
//                        fontFamily = pretendard,
//                        fontSize = 16.sp,
//                        fontWeight = FontWeight.Normal,
//                        color = Color.White
//                    ) */
//
//                    Spacer(modifier = modifier.weight(1f))
//
//                    if (isBefore) {
//                        Row(
//                            modifier = modifier
//                                .clickable(
//                                    interactionSource = NoRippleInteractionSource(),
//                                    indication = null,
//                                    onClick = onClickBefore
//                                ),
//                            verticalAlignment = Alignment.CenterVertically
//                        ) {
//                            Icon(
//                                modifier = modifier.size(8.dp, 13.dp),
//                                imageVector = ToongetherIcons.LeftArrow,
//                                contentDescription = null,
//                                tint = Color.White
//                            )
//
//                            Spacer(modifier = modifier.width(5.dp))
//
//                            Text(
//                                text = "이전 화",
//                                fontFamily = pretendard,
//                                fontSize = 16.sp,
//                                fontWeight = FontWeight.Medium,
//                                color = Color.White
//                            )
//                        }
//                    }
//
//                    if (isNext && isBefore) {
//                        Spacer(modifier = modifier.width(12.dp))
//
//                        Text(
//                            text = "|",
//                            fontFamily = pretendard,
//                            fontSize = 16.sp,
//                            fontWeight = FontWeight.Medium,
//                            color = Color.White
//                        )
//
//                        Spacer(modifier = modifier.width(12.dp))
//                    }
//
//                    if (isNext) {
//                        Row(
//                            modifier = modifier
//                                .clickable(
//                                    interactionSource = NoRippleInteractionSource(),
//                                    indication = null,
//                                    onClick = onClickAfter
//                                ),
//                            verticalAlignment = Alignment.CenterVertically
//                        ) {
//                            Text(
//                                text = "다음 화",
//                                fontFamily = pretendard,
//                                fontSize = 16.sp,
//                                fontWeight = FontWeight.Medium,
//                                color = Color.White
//                            )
//
//                            Spacer(modifier = modifier.width(5.dp))
//
//                            Icon(
//                                modifier = modifier.size(8.dp, 13.dp),
//                                imageVector = ToongetherIcons.RightArrow,
//                                contentDescription = null,
//                                tint = Color.White
//                            )
//                        }
//                    }
//                    Spacer(modifier = modifier.width(16.dp))
//                }
//            }
//        }
//    }
//}
//
//@Composable
//private fun ComicItem(
//    modifier: Modifier = Modifier,
//    height: Dp,
//    imageUrl: String
//) {
//    Box(
//        modifier = modifier
//            .fillMaxWidth()
//            .defaultMinSize(minHeight = height)
//            .background(Color.Black)
//    ) {
//        AsyncImage(
//            modifier = modifier
//                .fillMaxWidth(),
//            model = imageUrl,
//            contentDescription = null,
//            contentScale = ContentScale.Crop
//        )
//    }
//}
//
//private const val PlusSecond: Long = 3
