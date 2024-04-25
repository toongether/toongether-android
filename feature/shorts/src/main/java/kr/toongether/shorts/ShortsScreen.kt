package kr.toongether.shorts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshIndicator
import com.google.accompanist.swiperefresh.SwipeRefreshState
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import kr.toongether.comic.navigation.navigateToComic
import kr.toongether.designsystem.component.ToongetherTopAppBar
import kr.toongether.ui.LoadingScreen
import kr.toongether.ui.shortsCardItems
import org.orbitmvi.orbit.compose.collectAsState

@Composable
internal fun ShortsRoute(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: ShortsViewModel = hiltViewModel()
) {
    val state by viewModel.collectAsState()
    val swipeRefreshState = rememberSwipeRefreshState(isRefreshing = state.isLoading)

    ShortsScreen(
        modifier = modifier,
        shortsList = state.shortsList.collectAsLazyPagingItems(),
        onItemClick = { navController.navigateToComic(shortsId = it.id) },
        onRefresh = viewModel::fetchPagingShorts,
        swipeRefreshState = swipeRefreshState
    )
}

@Composable
internal fun ShortsScreen(
    modifier: Modifier = Modifier,
    shortsList: LazyPagingItems<Shorts>,
    onItemClick: (Shorts) -> Unit,
    onRefresh: () -> Unit,
    swipeRefreshState: SwipeRefreshState
) {
    Surface(
        modifier = modifier
            .fillMaxSize()
            .statusBarsPadding(),
        color = Color.Black
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
        ) {
            ToongetherTopAppBar(
                title = "단편 웹툰"
            )

            when (shortsList.loadState.refresh) {
                is LoadState.Loading -> {
                    LoadingScreen()
                }
                is LoadState.Error -> {
                    // TODO : Error 처리
                }
                else -> {
                    SwipeRefresh(
                        state = swipeRefreshState,
                        onRefresh = onRefresh,
                        indicator = { state, refreshTrigger ->
                            SwipeRefreshIndicator(
                                state = state,
                                refreshTriggerDistance = refreshTrigger,
                                backgroundColor = Color.Black,
                                contentColor = Color.White
                            )
                        }
                    ) {
                        LazyColumn(
                            modifier = modifier
                                .fillMaxSize(),
                            verticalArrangement = Arrangement.spacedBy(20.dp)
                        ) {
                            shortsCardItems(
                                items = shortsList,
                                onItemClick = onItemClick,
                                onClickLike = {}
                                /* onClickComment = {} */
                            )
                        }
                    }
                }
            }
        }
    }
}
