package kr.hs.dgsw.smartschool.datastore.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.dataStoreFile
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kr.hs.dgsw.smartschool.datastore.UserPreferencesSerializer
import kr.hs.dgsw.smartschool.datastore.model.User
import kr.toongether.common.network.Dispatcher
import kr.toongether.common.network.ToongetherDispatcher
import kr.toongether.common.network.di.ApplicationScope
import java.util.prefs.Preferences
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {
    @Provides
    @Singleton
    fun providesTokenPreferencesDataStore(
        @ApplicationContext context: Context,
        @Dispatcher(ToongetherDispatcher.IO) ioDispatcher: CoroutineDispatcher,
        @ApplicationScope scope: CoroutineScope,
        preferencesSerializer: UserPreferencesSerializer
    ): DataStore<User> =
        DataStoreFactory.create(
            serializer = preferencesSerializer,
            scope = CoroutineScope(scope.coroutineContext + ioDispatcher)
        ) {
            context.dataStoreFile("preferences.pb")
        }
}
