package kr.toongether.shorts

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import kr.toongether.shortsinterface.ShortsScreen
import org.orbitmvi.orbit.compose.collectAsState

@ExperimentalMaterial3Api
@Composable
fun ShortsScreen(
    modifier: Modifier = Modifier,
    navigateToComic: (shortsId: Long) -> Unit,
    viewModel: ShortsViewModel = hiltViewModel()
) {
    val state by viewModel.collectAsState()

    ShortsScreen(
        modifier = modifier,
        uiState = state,
    )
}
