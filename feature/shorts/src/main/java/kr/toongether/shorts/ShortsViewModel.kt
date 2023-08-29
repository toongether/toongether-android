package kr.toongether.shorts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.compose.collectAsLazyPagingItems
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kr.toongether.domain.GetPagingShortsUseCase
import kr.toongether.domain.GetShortsListUseCase
import kr.toongether.model.ShortsList
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class ShortsViewModel @Inject constructor(
    private val getPagingShortsUseCase: GetPagingShortsUseCase
) : ContainerHost<ShortsState, ShortsSideEffect>, ViewModel() {

    override val container = container<ShortsState, ShortsSideEffect>(ShortsState())

    init {
        getPagingShorts()
    }

    fun getPagingShorts(): Flow<PagingData<ShortsList>> =
        getPagingShortsUseCase.invoke().cachedIn(viewModelScope)
}
