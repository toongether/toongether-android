package kr.toongether.comic

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import kr.toongether.designsystem.component.ToongetherTopAppBar
import kr.toongether.designsystem.icon.ToongetherIcons
import kr.toongether.designsystem.icon.icons.Back
import kr.toongether.designsystem.theme.TransparentBlack
import kr.toongether.designsystem.theme.pretendard
import org.orbitmvi.orbit.compose.collectAsState

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
    viewModel.getComicList(id)

    ComicScreen(
        modifier = modifier,
        title = title,
        writer = writer,
        onClickBack = { navController.popBackStack() },
        comicState = comicState
    )
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
internal fun ComicScreen(
    modifier: Modifier = Modifier,
    title: String,
    writer: String,
    onClickBack: () -> Unit,
    comicState: ComicState
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
            LazyColumn(
                modifier = modifier.fillMaxSize()
            ) {
                itemsIndexed(
                    items = comicState.comicList.imageUrl,
                ) { index, imageUrl ->
                    GlideImage(
                        modifier = modifier
                            .fillMaxWidth(),
                        model = imageUrl,
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                }
            }

            ToongetherTopAppBar(
                modifier = modifier
                    .background(TransparentBlack)
                    .statusBarsPadding(),
                title = title,
                subTitle = writer,
                navigationIcon = ToongetherIcons.Back,
                onNavigationClick = onClickBack,
                backgroundColor = Color.Transparent
            )

            Surface(
                modifier = modifier
                    .align(Alignment.BottomCenter)
                    .background(TransparentBlack)
                    .navigationBarsPadding(),
                color = Color.Transparent
            ) {
                Spacer(modifier = modifier
                    .fillMaxWidth()
                    .height(35.dp))
            }
        }
    }
}
