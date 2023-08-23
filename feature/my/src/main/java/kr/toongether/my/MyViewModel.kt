package kr.toongether.my

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kr.hs.dgsw.smartschool.datastore.ToongetherPreferencesDataSource
import kr.toongether.datastore.TokenPreferences
import kr.toongether.model.Token
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    private val toongetherPreferences: ToongetherPreferencesDataSource
) : ViewModel() {

    val tokenState = toongetherPreferences.tokenData.stateIn(
        viewModelScope,
        SharingStarted.Eagerly,
        Token("", "")
    )
}
