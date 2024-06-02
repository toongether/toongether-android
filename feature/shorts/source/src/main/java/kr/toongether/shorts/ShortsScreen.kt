package kr.toongether.shorts

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import kr.toongether.shortsinterface.ShortsScreen
import kr.toongether.shortsinterface.ShortsSideEffect
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun ShortsScreen(
    modifier: Modifier = Modifier,
    navigateToLogin: () -> Unit,
    viewModel: ShortsViewModel = hiltViewModel()
) {
    val state by viewModel.collectAsState()

    viewModel.collectSideEffect {
        when (it) {
            is ShortsSideEffect.NavigateToLogin -> navigateToLogin()
        }
    }

    ShortsScreen(
        modifier = modifier,
        uiState = state,
        onClickLike = { shortsId, index -> viewModel.like(shortsId, index) }
    )
}
