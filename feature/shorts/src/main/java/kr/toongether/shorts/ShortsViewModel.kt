package kr.toongether.shorts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kr.toongether.domain.GetPagingShortsUseCase
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class ShortsViewModel @Inject constructor(
    private val getPagingShortsUseCase: GetPagingShortsUseCase
) : ContainerHost<ShortsState, ShortsSideEffect>, ViewModel() {

    override val container =
        container<ShortsState, ShortsSideEffect>(
            ShortsState(
                getPagingShortsUseCase.invoke().cachedIn(viewModelScope)
            )
        )

    fun getPagingShorts() = intent {
        reduce {
            state.copy(
                shortsList = getPagingShortsUseCase.invoke().cachedIn(viewModelScope)
            )
        }
    }
}
