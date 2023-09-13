package kr.hs.dgsw.smartschool.datastore

import androidx.datastore.core.DataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kr.toongether.datastore.TokenPreferences
import kr.toongether.datastore.copy
import kr.toongether.model.Token
import javax.inject.Inject

class ToongetherPreferencesDataSource @Inject constructor(
    private val tokenPreferences: DataStore<TokenPreferences>,
) {
    val accessToken = tokenPreferences.data.map { it.accessToken }
    val refreshToken = tokenPreferences.data.map { it.refreshToken }

    suspend fun saveAccessToken(token: String) {
        tokenPreferences.updateData {
            it.copy {
                accessToken = token
            }
        }
    }

    suspend fun saveRefreshToken(token: String) {
        tokenPreferences.updateData {
            it.copy {
                refreshToken = token
            }
        }
    }

    suspend fun deleteAccessToken() {
        tokenPreferences.updateData {
            it.copy {
                accessToken = ""
            }
        }
    }

    suspend fun deleteRefreshToken() {
        tokenPreferences.updateData {
            it.copy {
                refreshToken = ""
            }
        }
    }
}
