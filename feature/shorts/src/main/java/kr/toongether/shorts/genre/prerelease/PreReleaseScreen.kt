package kr.toongether.shorts.genre.prerelease

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshState
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import kr.toongether.comic.navigation.navigateToComic
import kr.toongether.common.shortToast
import kr.toongether.designsystem.component.ToongetherCircularProgressIndicator
import kr.toongether.model.Shorts
import kr.toongether.ui.shortsCardItems
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PreReleaseScreen(
    modifier: Modifier = Modifier,
    viewModel: PreReleaseViewModel = hiltViewModel(),
    context: Context = LocalContext.current,
    navController: NavController
) {
    val preReleaseUiState by viewModel.collectAsState()

    val refreshState = rememberPullRefreshState(
        refreshing = preReleaseUiState.isLoading,
        onRefresh = viewModel::getShortsList
    )

    viewModel.collectSideEffect {
        when (it) {
            is PreReleaseSideEffect.Toast -> context.shortToast(it.text)
        }
    }

    PreReleaseScreen(
        modifier = modifier,
        preReleaseUiState = preReleaseUiState,
        isRefreshing = preReleaseUiState.isLoading,
        refreshState = refreshState,
        onItemClick = navController::navigateToComic
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PreReleaseScreen(
    modifier: Modifier = Modifier,
    preReleaseUiState: PreReleaseState,
    isRefreshing: Boolean,
    refreshState: PullRefreshState,
    onItemClick: (Shorts) -> Unit
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .pullRefresh(refreshState),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            Box(
                modifier = modifier
                    .background(Color.Black)
                    .fillMaxWidth()
                    .height(
                        if (isRefreshing) {
                            70.dp
                        } else {
                            lerp(0.dp, 70.dp, refreshState.progress.coerceIn(0f..1f))
                        }
                    )
            ) {
                if (isRefreshing) {
                    ToongetherCircularProgressIndicator(
                        modifier.align(Alignment.Center)
                    )
                }
            }
        }

        shortsCardItems(
            items = preReleaseUiState.shortsList,
            onItemClick = onItemClick
        )
    }
}
