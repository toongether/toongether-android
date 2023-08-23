package kr.toongether.my

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import kr.toongether.designsystem.component.ToongetherScrollableTabRow
import kr.toongether.designsystem.component.ToongetherTopAppBar
import kr.toongether.model.ComicGenre

@Composable
internal fun MyRoute(
    modifier: Modifier = Modifier,
//    navController: NavController
) {
    MyScreen(
        modifier = modifier,
    )
}

@Composable
internal fun MyScreen(
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier
            .fillMaxSize(),
        color = Color.Black
    ) {
        Box(
            modifier = modifier
                .fillMaxSize()
        ) {
            Column {
                ToongetherTopAppBar(
                    title = "마이 페이지"
                )

                ToongetherScrollableTabRow(
                    tabs = ComicGenre.values().toList().map { it.title },
//                selectedTabIndex = pagerState.currentPage,
                    selectedTabIndex = 0,
                    onTabClick = { tabIndex ->
                    }
                )
            }
        }
    }
}
