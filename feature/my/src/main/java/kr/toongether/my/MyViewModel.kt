package kr.toongether.my

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kr.hs.dgsw.smartschool.datastore.ToongetherPreferencesDataSource
import kr.toongether.domain.DeleteUserUseCase
import kr.toongether.domain.GetUserUseCase
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    private val toongetherPreferences: ToongetherPreferencesDataSource,
    private val getUserUseCase: GetUserUseCase,
    private val deleteUserUseCase: DeleteUserUseCase
) : ContainerHost<MyState, MySideEffect>, ViewModel() {

    override val container = container<MyState, MySideEffect>(MyState())

    val accessToken = toongetherPreferences.accessToken.stateIn(
        viewModelScope,
        SharingStarted.Eagerly,
        ""
    )

    fun deleteToken() = intent {
        toongetherPreferences.deleteRefreshToken()
        toongetherPreferences.deleteAccessToken()
        postSideEffect(MySideEffect.NavigateToLogin)
    }

    fun getUser() = intent {
        reduce {
            state.copy(
                isLoading = true
            )
        }
        getUserUseCase.invoke()
            .onSuccess {
                reduce {
                    state.copy(
                        userInfo = it,
                        isLoading = false
                    )
                }
            }.onFailure {
                postSideEffect(MySideEffect.Toast(it.message!!))
                reduce {
                    state.copy(
                        isLoading = false
                    )
                }
            }
    }

    fun deleteUser() = intent {
        deleteUserUseCase.invoke()
            .onSuccess {
                postSideEffect(MySideEffect.NavigateToMy)
                deleteToken()
            }.onFailure {
                postSideEffect(MySideEffect.Toast(it.message!!))
            }
    }
}
