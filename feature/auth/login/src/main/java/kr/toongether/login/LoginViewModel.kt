package kr.toongether.login

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kr.hs.dgsw.smartschool.datastore.ToongetherPreferencesDataSource
import kr.toongether.data.UserRepository
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val toongetherPreferences: ToongetherPreferencesDataSource
) : ContainerHost<LoginState, LoginSideEffect>, ViewModel() {

    override val container = container<LoginState, LoginSideEffect>(LoginState())

    fun login(
        userId: String,
        password: String
    ) = intent {
        userRepository.login(userId, password)
            .onStart { reduce { state.copy(isLoading = true) } }
            .catch {
                postSideEffect(LoginSideEffect.Toast(it.message!!))
                reduce { state.copy(isLoading = false) }
            }
            .onEach {
                reduce { state.copy(isLoading = false) }
                toongetherPreferences.apply {
                    saveAccessToken(it.accessToken)
                    saveRefreshToken(it.refreshToken)
                    saveId(userId)
                    savePassword(password)
                }
                postSideEffect(LoginSideEffect.NavigateToMy)
            }
            .collect()
    }
}
