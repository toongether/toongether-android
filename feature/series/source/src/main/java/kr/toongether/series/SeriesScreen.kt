package kr.toongether.series

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import kr.toongether.seriesinterface.SeriesScreen
import org.orbitmvi.orbit.compose.collectAsState

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun SeriesScreen(
    navigateToEpisode: (Long, String, String) -> Unit,
    viewModel: SeriesViewModel = hiltViewModel(),
    sharedTransitionScope: SharedTransitionScope,
    animatedContentScope: AnimatedContentScope
) {
    val uiState by viewModel.collectAsState()

    SeriesScreen(
        uiState = uiState,
        onSeriesClick = {
            navigateToEpisode(
                it.id,
                it.titleMaker.color,
                it.titleMaker.backgroundImage
            )
        },
        sharedTransitionScope = sharedTransitionScope,
        animatedContentScope = animatedContentScope
    )
}
