package kr.toongether.shorts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import kr.toongether.designsystem.component.ToongetherTopAppBar
import kr.toongether.model.Shorts
import kr.toongether.ui.shortsCardItems

@Composable
internal fun ShortsRoute(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: ShortsViewModel = hiltViewModel()
) {
    val shortsList = viewModel.getPagingShorts().collectAsLazyPagingItems()
//    val state by viewModel.collectAsState()

    ShortsScreen(
        modifier = modifier,
        shortsList = shortsList,
        onItemClick = { navController.popBackStack() }
    )
}

@Composable
internal fun ShortsScreen(
    modifier: Modifier = Modifier,
    shortsList: LazyPagingItems<Shorts>,
    onItemClick: (Shorts) -> Unit
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

            LazyColumn(
                modifier = modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                shortsCardItems(
                    items = shortsList,
                    onItemClick = onItemClick
                )
            }
        }
    }
}
