package kr.hs.dgsw.smartschool.datastore

import androidx.datastore.core.DataStore
import kotlinx.coroutines.flow.map
import kr.toongether.datastore.TokenPreferences
import kr.toongether.datastore.copy
import javax.inject.Inject

class ToongetherPreferencesDataSource @Inject constructor(
    private val tokenPreferences: DataStore<TokenPreferences>
) {
    val accessToken = tokenPreferences.data.map { it.accessToken }
    val refreshToken = tokenPreferences.data.map { it.refreshToken }
    val id = tokenPreferences.data.map { it.id }
    val pw = tokenPreferences.data.map { it.pw }
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
