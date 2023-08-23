package kr.hs.dgsw.smartschool.datastore

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import com.google.protobuf.InvalidProtocolBufferException
import kr.toongether.datastore.TokenPreferences
import java.io.InputStream
import java.io.OutputStream
import javax.inject.Inject

class TokenPreferencesSerializer @Inject constructor() : Serializer<TokenPreferences> {
    override val defaultValue: TokenPreferences = TokenPreferences.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): TokenPreferences {
        try {
            return TokenPreferences.parseFrom(input)
        } catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto.", exception)
        }
    }

    override suspend fun writeTo(t: TokenPreferences, output: OutputStream) =
        t.writeTo(output)

}