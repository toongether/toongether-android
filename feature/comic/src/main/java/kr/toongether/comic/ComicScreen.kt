package kr.toongether.comic

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import kr.toongether.designsystem.component.ToongetherScrollbar
import kr.toongether.designsystem.component.ToongetherTopAppBar
import kr.toongether.designsystem.icon.ToongetherIcons
import kr.toongether.designsystem.icon.icons.Back
import kr.toongether.designsystem.theme.TransparentBlack
import kr.toongether.designsystem.utils.NoRippleInteractionSource
import org.orbitmvi.orbit.compose.collectAsState
import java.time.LocalTime
import kotlin.concurrent.timer

@Composable
internal fun ComicRoute(
    id: Long,
    title: String,
    writer: String,
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: ComicViewModel = hiltViewModel()
) {
    val comicState by viewModel.collectAsState()
    val lazyListState = rememberLazyListState()

    var isShowTabs by remember { mutableStateOf(true) }
    var toggledTime: LocalTime? by remember { mutableStateOf(null) }
    var isTopOrBottom by remember { mutableStateOf(true) }

    fun showTabs() {
        if (toggledTime != null) {
            toggledTime = null
            isShowTabs = false
        } else {
            toggledTime = LocalTime.now().plusSeconds(PlusSecond)
            isShowTabs = true
            timer(period = 500) {
                if (toggledTime == null) {
                    isShowTabs = false
                } else {
                    if (LocalTime.now() > toggledTime) {
                        isShowTabs = false
                        toggledTime = null
                    }
                }
            }
        }
    }

    LaunchedEffect(true) {
        viewModel.getComicList(id)
        showTabs()
    }

    ComicScreen(
        modifier = modifier,
        lazyListState = lazyListState,
        title = title,
        writer = writer,
        onClickBack = navController::popBackStack,
        comicState = comicState,
        onClick = ::showTabs,
        isShowTabs = isShowTabs || isTopOrBottom,
        recomposition = {
            isTopOrBottom = lazyListState.layoutInfo.visibleItemsInfo.firstOrNull()?.index == 0 ||
                lazyListState.layoutInfo.visibleItemsInfo.lastOrNull()?.index ==
                lazyListState.layoutInfo.totalItemsCount - 1
        }
    )
}

@Composable
internal fun ComicScreen(
    modifier: Modifier = Modifier,
    lazyListState: LazyListState,
    title: String,
    writer: String,
    onClickBack: () -> Unit,
    comicState: ComicState,
    onClick: () -> Unit,
    isShowTabs: Boolean,
    recomposition: () -> Unit
) {
    val minHeight: Dp
    val lastHeight: Dp

    with(LocalDensity.current) {
        val screenWidth = LocalConfiguration.current.screenWidthDp.dp.toPx()
        minHeight = (screenWidth * comicState.comicList.height / comicState.comicList.width).toDp() - 5.dp
        lastHeight = comicState.comicList.lastHeight.toDp()
    }

    Surface(
        modifier = modifier
            .fillMaxSize(),
        color = Color.Black
    ) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .clickable(
                    interactionSource = NoRippleInteractionSource(),
                    indication = null,
                    onClick = onClick
                )
        ) {
            ToongetherScrollbar(
                modifier = modifier
                    .padding(top = 90.dp, bottom = 35.dp)
                    .navigationBarsPadding(),
                listState = lazyListState,
                isShow = isShowTabs
            ) {
                LazyColumn(
                    modifier = modifier
                        .fillMaxSize(),
                    state = lazyListState
                ) {
                    itemsIndexed(
                        items = comicState.comicList.imageUrl
                    ) { index, imageUrl ->
                        if (index < comicState.comicList.endIndex) {
                            ComicItem(height = minHeight, imageUrl = imageUrl)
                        } else if (index == comicState.comicList.endIndex) {
                            ComicItem(height = lastHeight, imageUrl = imageUrl)
                        }
                        recomposition.invoke()
                    }
                }
            }

            AnimatedVisibility(
                visible = isShowTabs,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                ToongetherTopAppBar(
                    modifier = modifier
                        .height(90.dp)
                        .background(TransparentBlack)
                        .statusBarsPadding(),
                    title = title,
                    subTitle = writer,
                    navigationIcon = ToongetherIcons.Back,
                    onNavigationClick = onClickBack,
                    backgroundColor = Color.Transparent
                )
            }
            AnimatedVisibility(
                modifier = modifier.align(Alignment.BottomCenter),
                visible = isShowTabs,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                Surface(
                    modifier = modifier
                        .background(TransparentBlack)
                        .navigationBarsPadding(),
                    color = Color.Transparent
                ) {
                    Spacer(
                        modifier = modifier
                            .fillMaxWidth()
                            .height(35.dp)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
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
        GlideImage(
            modifier = modifier
                .fillMaxWidth(),
            model = imageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    }
}

private const val PlusSecond: Long = 3
