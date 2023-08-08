package kr.toongether.shorts

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kr.toongether.designsystem.component.ToongetherScrollableTabRow
import kr.toongether.designsystem.component.ToongetherTopAppBar
import kr.toongether.designsystem.theme.pretendard
import kr.toongether.model.ComicGenre
import kr.toongether.shorts.genre.prerelease.PreReleaseScreen

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun ShortsRoute(
    modifier: Modifier = Modifier,
) {
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    ShortsScreen(
        modifier = modifier,
        pagerState = pagerState,
        coroutineScope = coroutineScope
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun ShortsScreen(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    coroutineScope: CoroutineScope,
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
                title = {
                    Row(
                        modifier = modifier
                            .padding(bottom = 10.dp)
                    ) {
                        Box(
                            modifier = modifier
                                .fillMaxHeight()
                        ) {
                            Text(
                                modifier = modifier.align(Alignment.BottomCenter),
                                text = "단편 웹툰",
                                fontFamily = pretendard,
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                fontSize = 26.sp
                            )
                        }
                        Spacer(modifier = modifier.size(5.dp))
                        Box(
                            modifier = modifier
                                .fillMaxHeight()
                        ) {
                            Text(
                                modifier = modifier.align(Alignment.BottomCenter),
                                text = "최신순",
                                fontFamily = pretendard,
                                fontWeight = FontWeight.Normal,
                                color = Color.White,
                                fontSize = 14.sp
                            )
                        }
                    }
                }
            )

            ToongetherScrollableTabRow(
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

            HorizontalPager(
                modifier = modifier.fillMaxSize(),
                pageCount = ComicGenre.values().size,
                state = pagerState,
            ) { page ->
                when (page) {
                    0 -> PreReleaseScreen()
                }
            }
        }
    }
}
