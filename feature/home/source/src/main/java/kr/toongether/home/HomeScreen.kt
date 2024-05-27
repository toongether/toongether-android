package kr.toongether.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import kr.toongether.homeinterface.HomeScreen
import org.orbitmvi.orbit.compose.collectAsState

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navigateToComic: (shortsId: Long) -> Unit,
    navigateToEpisode: (seriesId: Long) -> Unit,
    viewModel: HomeViewModel = hiltViewModel(),
    alert: (@Composable () -> Unit) -> Unit
) {
    val state by viewModel.collectAsState()

    LaunchedEffect(state.isLoading) {
        alert {
            if (state.isLoading) {
                Box(
                    modifier = modifier
                        .fillMaxSize()
                        .background(Color.Black)
                ) {
                    Image(
                        modifier = modifier.align(Alignment.Center),
                        painter = painterResource(id = kr.toongether.designsystem.R.drawable.ic_toongether),
                        contentDescription = null
                    )
                }
            }
        }
    }

    HomeScreen(
        modifier = modifier,
        homeViews = state.homeViews,
        onClickShorts = navigateToComic,
        onClickSeries = navigateToEpisode
    )
}
