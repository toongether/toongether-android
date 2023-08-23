package kr.hs.dgsw.smartschool.datastore

import androidx.datastore.core.DataStore
import kotlinx.coroutines.flow.map
import kr.toongether.datastore.TokenPreferences
import kr.toongether.datastore.copy
import kr.toongether.model.Token
import javax.inject.Inject

class ToongetherPreferencesDataSource @Inject constructor(
    private val tokenPreferences: DataStore<TokenPreferences>
) {
    val tokenData = tokenPreferences.data
        .map {
            Token(
                accessToken = it.accessToken,
                refreshToken = it.refreshToken
            )
        }

    suspend fun setToken(accessToken: String, refreshToken: String) {
        tokenPreferences.updateData {
            it.copy {
                this.accessToken = accessToken
                this.refreshToken = refreshToken
            }
        }
    }
}
