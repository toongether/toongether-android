package kr.toongether.my

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kr.hs.dgsw.smartschool.datastore.ToongetherPreferencesDataSource
import kr.toongether.model.Token
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    private val toongetherPreferences: ToongetherPreferencesDataSource
) : ViewModel() {

    val accessToken = toongetherPreferences.accessToken.stateIn(
        viewModelScope,
        SharingStarted.Eagerly,
        ""
    )

    fun deleteToken() = viewModelScope.launch(Dispatchers.IO) {
        toongetherPreferences.deleteAccessToken()
        toongetherPreferences.deleteRefreshToken()
    }
}
