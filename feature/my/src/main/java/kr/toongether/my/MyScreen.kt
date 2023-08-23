package kr.toongether.my

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import kr.toongether.designsystem.component.ToongetherButton
import kr.toongether.designsystem.component.ToongetherScrollableTabRow
import kr.toongether.designsystem.component.ToongetherTopAppBar
import kr.toongether.designsystem.theme.pretendard
import kr.toongether.model.ComicGenre
import kr.toongether.signup.navigation.navigateToSignup

@Composable
internal fun MyRoute(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    MyScreen(
        modifier = modifier,
        navController = navController
    )
}

@Composable
internal fun MyScreen(
    modifier: Modifier = Modifier,
    navController: NavController
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
                    title = "마이 페이지",
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
