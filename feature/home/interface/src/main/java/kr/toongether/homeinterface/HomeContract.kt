package kr.toongether.homeinterface

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kr.toongether.model.HomeView

data class HomeState(
    val homeViews: List<HomeView> = emptyList(),
    val isLoading: Boolean = false
)

sealed class HomeSideEffect {
    data class Toast(val text: String) : HomeSideEffect()
}
