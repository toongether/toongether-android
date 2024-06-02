package kr.toongether.my

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kr.hs.dgsw.smartschool.datastore.UserPreferencesDataSource
import kr.toongether.data.UserRepository
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    private val toongetherPreferences: UserPreferencesDataSource,
    private val userRepository: UserRepository,
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
        userRepository.getUserInfo()
            .onStart { reduce { state.copy(isLoading = true) } }
            .catch {
                postSideEffect(MySideEffect.Toast(it.message!!))
                reduce {
                    state.copy(
                        isLoading = false
                    )
                }
            }
            .onEach {
                reduce {
                    state.copy(
                        userInfo = it,
                        isLoading = false
                    )
                }
            }
            .collect()
    }

    fun deleteUser() = intent {
        runCatching {
            userRepository.deleteUser()
        }
            .onSuccess {
                postSideEffect(MySideEffect.NavigateToMy)
                deleteToken()
            }.onFailure {
                postSideEffect(MySideEffect.Toast(it.message!!))
            }
    }
}
