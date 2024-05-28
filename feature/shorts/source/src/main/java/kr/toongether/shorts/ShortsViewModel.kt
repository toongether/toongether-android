package kr.toongether.shorts

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kr.toongether.data.ShortsRepository
import kr.toongether.shortsinterface.ShortsSideEffect
import kr.toongether.shortsinterface.ShortsUiState
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class ShortsViewModel @Inject constructor(
    private val shortsRepository: ShortsRepository
) : ContainerHost<ShortsUiState, ShortsSideEffect>, ViewModel() {

    override val container = container<ShortsUiState, ShortsSideEffect>(ShortsUiState.Loading)

    init {
        intent {
            shortsRepository.getShortsList()
                .onStart { reduce { ShortsUiState.Loading } }
                .catch { reduce { ShortsUiState.Error(it.message.toString()) } }
                .onEach {
                    val shortsList = it.shorts.shuffled()
                    val shortsDetails = List(shortsList.size) { index ->
                        shortsRepository.getShorts(shortsList[index].id).first()
                    }
                    reduce { ShortsUiState.Success(shortsList, shortsDetails) }
                }
                .collect()
        }
    }
}
