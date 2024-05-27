package kr.toongether.shorts

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import kr.toongether.shortsinterface.ShortsScreen
import org.orbitmvi.orbit.compose.collectAsState

@ExperimentalMaterialApi
@ExperimentalMaterial3Api
@Composable
fun ShortsScreen(
    modifier: Modifier = Modifier,
    navigateToComic: (shortsId: Long) -> Unit,
    viewModel: ShortsViewModel = hiltViewModel()
) {
    val state by viewModel.collectAsState()
//    var isRefreshing by remember { mutableStateOf(false) }
//    val pullRefreshState = rememberPullRefreshState(
//        refreshing = isRefreshing,
//        onRefresh = {
//            isRefreshing = true
//            viewModel.fetchPagingShorts()
//        },
//    )

    ShortsScreen(
        modifier = modifier,
        shortsList = state.shortsList.collectAsLazyPagingItems(),
        onComicClick = { navigateToComic(it.id) },
    )
}
