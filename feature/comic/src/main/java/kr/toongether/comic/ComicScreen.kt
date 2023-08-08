package kr.toongether.comic

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kr.toongether.designsystem.component.ToongetherTopAppBar
import kr.toongether.designsystem.icon.ToongetherIcons
import kr.toongether.designsystem.icon.icons.Back
import kr.toongether.designsystem.theme.pretendard

@Composable
internal fun ComicRoute(
    id: Long,
    title: String,
    writer: String,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    ComicScreen(
        modifier = modifier,
        title = title,
        writer = writer,
        onClickBack = { navController.popBackStack() }
    )
}

@Composable
internal fun ComicScreen(
    modifier: Modifier = Modifier,
    title: String,
    writer: String,
    onClickBack: () -> Unit
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
            ToongetherTopAppBar(
                title = title,
                subTitle = writer,
                navigationIcon = ToongetherIcons.Back,
                onNavigationClick = onClickBack
            )

            Surface(
                modifier = modifier.align(Alignment.BottomCenter),
                color = Color(0x80000000)
            ) {
                Spacer(modifier = modifier
                    .fillMaxWidth()
                    .width(35.dp))
            }
        }
    }
}
