package kr.toongether.login

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kr.hs.dgsw.smartschool.datastore.ToongetherPreferencesDataSource
import kr.toongether.domain.LoginUseCase
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val toongetherPreferences: ToongetherPreferencesDataSource
) : ContainerHost<LoginState, LoginSideEffect>, ViewModel() {

    override val container = container<LoginState, LoginSideEffect>(LoginState())

    fun login(
        userId: String,
        password: String
    ) = intent {
        reduce { state.copy(isLoading = true) }
        loginUseCase(
            Login(userId, password)
        ).onSuccess {
            reduce { state.copy(isLoading = false) }
            toongetherPreferences.apply {
                saveAccessToken(it.accessToken)
                saveRefreshToken(it.refreshToken)
                saveId(userId)
                savePassword(password)
            }
            postSideEffect(LoginSideEffect.NavigateToMy)
        }.onFailure {
            postSideEffect(LoginSideEffect.Toast(it.message!!))
            reduce { state.copy(isLoading = false) }
        }
    }
}
