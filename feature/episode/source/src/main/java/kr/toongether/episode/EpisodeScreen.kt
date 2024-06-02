package kr.toongether.episode

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.graphics.toColor
import androidx.core.graphics.toColorInt
import androidx.hilt.navigation.compose.hiltViewModel
import kr.toongether.episodeinterface.EpisodeScreen
import kr.toongether.episodeinterface.EpisodeUiState
import org.orbitmvi.orbit.compose.collectAsState

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun EpisodeScreen(
    id: Long,
    backgroundColor: String,
    backgroundImage: String,
    modifier: Modifier = Modifier,
    navigateToComic: (seriesId: Long, episodeNumber: Int) -> Unit,
    popBackStack: () -> Unit,
    viewModel: EpisodeViewModel = hiltViewModel(),
    sharedTransitionScope: SharedTransitionScope,
    animatedContentScope: AnimatedContentScope
) {
    val state by viewModel.collectAsState()

    LaunchedEffect(id) {
        viewModel.getSeriesEpisodeList(id)
    }

    EpisodeScreen(
        modifier = modifier,
        uiState = state,
        id = id,
        backgroundColor = Color(backgroundColor.toColorInt()),
        backgroundImage = backgroundImage,
        onItemClick = {
            navigateToComic(id, it.episodeNumber)
        },
        onClickBack = popBackStack,
        sharedTransitionScope = sharedTransitionScope,
        animatedContentScope = animatedContentScope
    )
}
