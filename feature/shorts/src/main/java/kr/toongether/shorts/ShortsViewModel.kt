package kr.toongether.shorts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kr.toongether.domain.GetPagingShortsUseCase
import kr.toongether.model.Shorts
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class ShortsViewModel @Inject constructor(
    private val getPagingShortsUseCase: GetPagingShortsUseCase
) : ContainerHost<ShortsState, ShortsSideEffect>, ViewModel() {

    override val container = container<ShortsState, ShortsSideEffect>(ShortsState())

    fun getPagingShorts(): Flow<PagingData<Shorts>> =
        getPagingShortsUseCase.invoke().cachedIn(viewModelScope)
}