package kr.toongether.comic

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import kr.toongether.comicinterface.ComicScreen
import kr.toongether.comicinterface.ComicSideEffect
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun ComicScreen(
    seriesId: Long,
    episodeNumber: Long,
    navigateToComic: (Long) -> Unit,
    navigateToLogin: () -> Unit,
    popBackStack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: ComicViewModel = hiltViewModel(),
) {
    val comicState by viewModel.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getComic(seriesId, episodeNumber)
    }

    viewModel.collectSideEffect {
        when (it) {
            is ComicSideEffect.NavigateToLogin -> navigateToLogin()
        }
    }

    ComicScreen(
        modifier = modifier,
        onBackClick = popBackStack,
        uiState = comicState,
        onLikeClick = viewModel::like,
        navigateToComic = navigateToComic,
    )
}
