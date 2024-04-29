package kr.toongether.signup

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kr.toongether.data.EmailRepository
import kr.toongether.data.UserRepository
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor(
    private val emailRepository: EmailRepository,
    private val userRepository: UserRepository
) : ContainerHost<SignupState, SignupSideEffect>, ViewModel() {

    override val container = container<SignupState, SignupSideEffect>(SignupState())

    fun sendEmail(email: String) = intent {
        reduce {
            state.copy(
                isLoading = true
            )
        }
        runCatching {
            emailRepository.sendEmail(email)
        }.onSuccess {
            postSideEffect(SignupSideEffect.NavigateToCheckEmail)
            reduce {
                state.copy(
                    isLoading = false
                )
            }
        }.onFailure {
            postSideEffect(SignupSideEffect.Toast(it.message!!))
            reduce {
                state.copy(
                    isLoading = false,
                    error = it
                )
            }
        }
    }

    fun checkEmail(email: String, code: String) = intent {
        emailRepository.checkEmail(email = email, code = code)
            .onStart { reduce { state.copy(isLoading = true) } }
            .onEach {
                if (it) {
                    postSideEffect(SignupSideEffect.NavigateToInputPassword)
                } else {
                    postSideEffect(SignupSideEffect.Toast("인증번호가 일치하지 않아요."))
                }
                reduce { state.copy(isLoading = false) }
            }
            .catch {
                postSideEffect(SignupSideEffect.Toast(it.message!!))
                reduce { state.copy(isLoading = false) }
            }
            .collect()
    }

    fun signup(
        userId: String,
        password: String,
        name: String,
        email: String,
        code: String
    ) = intent {
        reduce {
            state.copy(
                isLoading = true
            )
        }
        runCatching {
            userRepository.signup(userId, password, name, email, code)
        }
            .onSuccess {
                postSideEffect(SignupSideEffect.NavigateToMy)
                postSideEffect(SignupSideEffect.Toast("회원가입을 성공했습니다."))
                reduce {
                    state.copy(
                        isLoading = false
                    )
                }
            }.onFailure {
                postSideEffect(SignupSideEffect.Toast(it.message!!))
                reduce {
                    state.copy(
                        isLoading = false,
                        error = it
                    )
                }
            }
    }

    fun checkDuplicateUser(userId: String) = intent {
        userRepository.validateUser(userId)
            .onStart { reduce { state.copy(isLoading = true) } }
            .onEach {
                if (it) {
                    postSideEffect(SignupSideEffect.SuccessCheckDuplicateUser)
                    reduce { state.copy(isLoading = false) }
                } else {
                    postSideEffect(SignupSideEffect.Toast("중복된 아이디에요."))
                    reduce { state.copy(isLoading = false) }
                }
            }
            .catch {
                postSideEffect(SignupSideEffect.Toast(it.message!!))
                reduce { state.copy(isLoading = false) }
            }
            .collect()
    }

    fun checkDuplicateEmail(email: String) = intent {
        emailRepository.validateEmail(email)
            .onStart { reduce { state.copy(isLoading = true) } }
            .onEach {
                if (it) {
                    postSideEffect(SignupSideEffect.SuccessCheckDuplicateEmail)
                    reduce { state.copy(isLoading = false) }
                } else {
                    postSideEffect(SignupSideEffect.Toast("중복된 이메일이에요."))
                    reduce { state.copy(isLoading = false) }
                }
            }
            .catch {
                postSideEffect(SignupSideEffect.Toast(it.message!!))
                reduce { state.copy(isLoading = false) }
            }
            .collect()
    }
}
