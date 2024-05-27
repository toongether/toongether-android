package kr.toongether.episode

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import kr.toongether.episodeinterface.EpisodeScreen
import org.orbitmvi.orbit.compose.collectAsState

@ExperimentalMaterial3Api
@Composable
fun EpisodeScreen(
    id: Long,
    modifier: Modifier = Modifier,
    navigateToComic: (seriesId: Long, episodeNumber: Int) -> Unit,
    popBackStack: () -> Unit,
    viewModel: EpisodeViewModel = hiltViewModel()
) {
    val state by viewModel.collectAsState()

    LaunchedEffect(id) {
        viewModel.getSeriesEpisodeList(id)
    }

    EpisodeScreen(
        modifier = modifier,
        uiState = state,
        onItemClick = {
            navigateToComic(id, it.episodeNumber)
        },
        onClickBack = popBackStack,
    )
}
