package kr.toongether.shorts

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kr.toongether.designsystem.component.ToongetherScrollableTabRow
import kr.toongether.designsystem.component.ToongetherTopAppBar
import kr.toongether.model.ComicGenre
import kr.toongether.shorts.genre.prerelease.PreReleaseScreen

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun ShortsRoute(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    ShortsScreen(
        modifier = modifier,
        pagerState = pagerState,
        coroutineScope = coroutineScope,
        navController = navController
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun ShortsScreen(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    coroutineScope: CoroutineScope,
    navController: NavController
) {
    Surface(
        modifier = modifier
            .fillMaxSize(),
        color = Color.Black
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
        ) {
            ToongetherTopAppBar(
                title = "단편 웹툰",
                subTitle = "최신순"
            )

            ToongetherScrollableTabRow(
                modifier = modifier.height(40.dp),
                tabs = ComicGenre.values().toList().map { it.title },
//                selectedTabIndex = pagerState.currentPage,
                selectedTabIndex = 0,
                onTabClick = { tabIndex ->
                    coroutineScope.launch {
//                        pagerState.animateScrollToPage(tabIndex)
                        pagerState.animateScrollToPage(0)
                    }
                }
            )
            PreReleaseScreen(navController = navController)
//            HorizontalPager(
//                modifier = modifier.fillMaxSize(),
//                pageCount = ComicGenre.values().size,
//                state = pagerState
//            ) { page ->
//                when (page) {
//                    0 -> PreReleaseScreen(navController = navController)
//                }
//            }
        }
    }
}
