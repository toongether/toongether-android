package kr.toongether.signup

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kr.toongether.domain.CheckDuplicateEmailUseCase
import kr.toongether.domain.CheckDuplicateUserUseCase
import kr.toongether.domain.CheckEmailUseCase
import kr.toongether.domain.SendEmailUseCase
import kr.toongether.domain.SignupUseCase
import kr.toongether.model.Email
import kr.toongether.model.Signup
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor(
    private val signupUseCase: SignupUseCase,
    private val checkEmailUseCase: CheckEmailUseCase,
    private val sendEmailUseCase: SendEmailUseCase,
    private val checkDuplicateEmailUseCase: CheckDuplicateEmailUseCase,
    private val checkDuplicateUserUseCase: CheckDuplicateUserUseCase
) : ContainerHost<SignupState, SignupSideEffect>, ViewModel() {

    override val container = container<SignupState, SignupSideEffect>(SignupState())

    fun sendEmail(email: String) = intent {
        reduce {
            state.copy(
                isLoading = true
            )
        }
        sendEmailUseCase.invoke(Email(email))
            .onSuccess {
                postSideEffect(SignupSideEffect.NavigateToCheckEmail)
                reduce {
                    state.copy(
                        isLoading = false
                    )
                }
            }
            .onFailure {
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
        reduce {
            state.copy(
                isLoading = true
            )
        }
        checkEmailUseCase.invoke(email = email, code = code)
            .onSuccess {
                if (it) {
                    postSideEffect(SignupSideEffect.NavigateToInputPassword)
                } else {
                    postSideEffect(SignupSideEffect.Toast("인증번호가 일치하지 않아요."))
                }
                reduce { state.copy(isLoading = false) }
            }
            .onFailure {
                postSideEffect(SignupSideEffect.Toast(it.message!!))
                reduce { state.copy(isLoading = false) }
            }
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
        signupUseCase.invoke(
            Signup(
                userId = userId,
                password = password,
                name = name,
                email = email,
                code
            )
        ).onSuccess {
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
        reduce { state.copy(isLoading = true) }
        checkDuplicateUserUseCase(userId)
            .onSuccess {
                if (it) {
                    postSideEffect(SignupSideEffect.SuccessCheckDuplicateUser)
                    reduce { state.copy(isLoading = false) }
                } else {
                    postSideEffect(SignupSideEffect.Toast("중복된 아이디에요."))
                    reduce { state.copy(isLoading = false) }
                }
            }.onFailure {
                postSideEffect(SignupSideEffect.Toast(it.message!!))
                reduce { state.copy(isLoading = false) }
            }
    }

    fun checkDuplicateEmail(email: String) = intent {
        reduce { state.copy(isLoading = true) }
        checkDuplicateEmailUseCase(email)
            .onSuccess {
                if (it) {
                    postSideEffect(SignupSideEffect.SuccessCheckDuplicateEmail)
                    reduce { state.copy(isLoading = false) }
                } else {
                    postSideEffect(SignupSideEffect.Toast("중복된 이메일이에요."))
                    reduce { state.copy(isLoading = false) }
                }
            }.onFailure {
                postSideEffect(SignupSideEffect.Toast(it.message!!))
                reduce { state.copy(isLoading = false) }
            }
    }
}
