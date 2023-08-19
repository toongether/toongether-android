package kr.toongether.login

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kr.toongether.domain.LoginUseCase
import kr.toongether.model.Login
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ContainerHost<LoginState, LoginSideEffect>, ViewModel() {

    override val container = container<LoginState, LoginSideEffect>(LoginState())

    fun login(
        userId: String,
        password: String
    ) = intent {
        reduce {
            state.copy(
                isLoading = true
            )
        }
        loginUseCase.invoke(
            Login(userId, password)
        ).onSuccess {
            reduce {
                state.copy(
                    token = it,
                    isLoading = false
                )
            }
        }.onFailure {
            postSideEffect(LoginSideEffect.Toast("서버 연결에 실패했습니다."))
            reduce {
                state.copy(
                    error = it,
                    isLoading = false
                )
            }
        }
    }
}
