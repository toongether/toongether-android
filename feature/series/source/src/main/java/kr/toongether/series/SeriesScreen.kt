package kr.toongether.series

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import kotlinx.coroutines.launch
import kr.toongether.model.Series
import org.orbitmvi.orbit.compose.collectAsState
import kr.toongether.seriesinterface.SeriesScreen
import kr.toongether.seriesinterface.SeriesUiState

@ExperimentalMaterial3Api
@ExperimentalFoundationApi
@Composable
fun SeriesScreen(
    modifier: Modifier = Modifier,
    navigateToEpisode: (episodeId: Long) -> Unit,
    viewModel: SeriesViewModel = hiltViewModel()
) {
    val uiState by viewModel.collectAsState()

    SeriesScreen(
        uiState = uiState,
        onTabClick = {},
        onComicClick = {},
    )
}
